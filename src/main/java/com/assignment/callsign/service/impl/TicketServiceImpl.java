package com.assignment.callsign.service.impl;

import com.assignment.callsign.entity.TicketDetails;
import com.assignment.callsign.jpa.TicketDetailsRepository;
import com.assignment.callsign.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketDetailsRepository ticketDetailsRepository;

    @Override
    public List<TicketDetails> fetchAllTickets() {
        return ticketDetailsRepository.findAll();
    }
}
