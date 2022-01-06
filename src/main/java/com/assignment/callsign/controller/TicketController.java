package com.assignment.callsign.controller;

import com.assignment.callsign.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @GetMapping("tickets")
    public ResponseEntity fetchAllTickets() {
        return ResponseEntity.ok(ticketService.fetchAllTickets());
    }
}
