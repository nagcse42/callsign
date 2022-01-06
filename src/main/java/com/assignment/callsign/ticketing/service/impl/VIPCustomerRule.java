package com.assignment.callsign.ticketing.service.impl;

import com.assignment.callsign.common.Constants;
import com.assignment.callsign.entity.DeliveryDetails;
import com.assignment.callsign.ticketing.service.TicketGeneratorRule;
import org.apache.logging.log4j.util.Strings;

public class VIPCustomerRule implements TicketGeneratorRule {

    @Override
    public boolean ticketRequired(DeliveryDetails deliveryDetails) {
        return Strings.isNotBlank(deliveryDetails.getCustomerType())
                && Constants.CUSTOMER_TYPE_VIP.equalsIgnoreCase(deliveryDetails.getCustomerType());
    }

    @Override
    public int getPriority() {
        return 1;
    }
}
