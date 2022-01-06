package com.assignment.callsign.service;

import com.assignment.callsign.entity.TicketDetails;

import java.util.List;

public interface TicketService {
    List<TicketDetails> fetchAllTickets();
}
