package com.assignment.callsign.ticketing.service;

import com.assignment.callsign.entity.DeliveryDetails;

public interface TicketGeneratorRule {
    boolean ticketRequired(DeliveryDetails deliveryDetails);
    int getPriority();
}
