package com.assignment.callsign.ticketing.service.impl;

import com.assignment.callsign.entity.DeliveryDetails;
import com.assignment.callsign.ticketing.service.TicketGeneratorRule;

import java.time.LocalDateTime;

public class ExpectedTimeOfDeliveryPassed implements TicketGeneratorRule {

    @Override
    public boolean ticketRequired(DeliveryDetails deliveryDetails) {
        return null != deliveryDetails.getExpectedDeliveryTime()
                && LocalDateTime.now().isAfter(deliveryDetails.getExpectedDeliveryTime());
    }

    @Override
    public int getPriority() {
        return 2;
    }
}
