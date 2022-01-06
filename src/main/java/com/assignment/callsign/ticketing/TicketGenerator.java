package com.assignment.callsign.ticketing;

import com.assignment.callsign.common.Constants;
import com.assignment.callsign.entity.DeliveryDetails;
import com.assignment.callsign.entity.TicketDetails;
import com.assignment.callsign.jpa.DeliveryDetailsRepository;
import com.assignment.callsign.jpa.TicketDetailsRepository;
import com.assignment.callsign.ticketing.service.TicketGeneratorRule;
import com.assignment.callsign.ticketing.service.impl.EstimatedGreaterThanExpectedTimeRule;
import com.assignment.callsign.ticketing.service.impl.ExpectedTimeOfDeliveryPassed;
import com.assignment.callsign.ticketing.service.impl.VIPCustomerRule;
import io.jsonwebtoken.lang.Collections;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Component
public class TicketGenerator {
    private static final Logger logger = LoggerFactory.getLogger(TicketGenerator.class);

    @Autowired
    private DeliveryDetailsRepository deliveryDetailsRepository;

    @Autowired
    private TicketDetailsRepository ticketDetailsRepository;

    private final Set<TicketGeneratorRule> ticketGeneratorRules;

    public TicketGenerator(){
        ticketGeneratorRules = new HashSet<>();
    }

    public TicketGenerator(Set<TicketGeneratorRule> rules) {
        this.ticketGeneratorRules = rules;
    }

    @PostConstruct
    private void addRules() {
        ticketGeneratorRules.add(new VIPCustomerRule());
        ticketGeneratorRules.add(new ExpectedTimeOfDeliveryPassed());
        ticketGeneratorRules.add(new EstimatedGreaterThanExpectedTimeRule());
    }

    @Scheduled(fixedDelay = 5 * 60 * 1000, initialDelay = 15 * 60 * 1000)
    //@Scheduled(fixedDelay = 1000)
    public void generateTickets() {
        logger.info("Ticketing started");
        Set<DeliveryDetails> deliveryDetailsList = deliveryDetailsRepository.findUnDeliveredOrders();
        if(!Collections.isEmpty(deliveryDetailsList)) {
            for (DeliveryDetails deliveryDetails : deliveryDetailsList) {
                Optional<TicketGeneratorRule> ticketGeneratorRule = ticketGeneratorRules.stream()
                        .filter(calculationRule -> calculationRule.ticketRequired(deliveryDetails))
                        .findFirst();

                if(ticketGeneratorRule.isPresent()) {
                    generateAndSaveTicket(deliveryDetails, ticketGeneratorRule.get().getPriority());
                }
            }
        }
    }

    private void generateAndSaveTicket(DeliveryDetails deliveryDetails, int priority) {
        TicketDetails ticketDetails = new TicketDetails();
        ticketDetails.setDeliveryId(deliveryDetails.getDeliveryId());
        ticketDetails.setPriority(priority);
        ticketDetails.setStatus(Constants.TICKET_STATUS_CREATED);

        logger.info("Saving ticket details : {}", ticketDetails);
        ticketDetailsRepository.save(ticketDetails);
    }
}
