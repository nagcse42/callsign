package com.assignment.callsign.ticketing.service.impl;

import com.assignment.callsign.common.Constants;
import com.assignment.callsign.entity.DeliveryDetails;
import com.assignment.callsign.ticketing.service.TicketGeneratorRule;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class EstimatedGreaterThanExpectedTimeRule  implements TicketGeneratorRule {

    @Override
    public boolean ticketRequired(DeliveryDetails deliveryDetails) {
        long timeToDeliver = ChronoUnit.MINUTES.between(LocalDateTime.now(), deliveryDetails.getExpectedDeliveryTime());

        return Constants.ORDER_STATUS_PREPARING.equalsIgnoreCase(deliveryDetails.getDeliveryStatus())
                && timeToDeliver > Constants.MEAN_DELIVERY_TIME;
    }

    @Override
    public int getPriority() {
        return 3;
    }
}
