package com.assignment.callsign.entity;

import javax.persistence.*;

@Entity
@Table(name = "CARD_DETAILS")
public class TicketDetails {
    @Id
    @Column(name = "TICKET_NUMBER")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "PRIORITY")
    private int priority;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "DELIVERY_ID")
    private int deliveryId;

    public TicketDetails(){}

    public TicketDetails(int priority, String status, int deliveryId) {
        this.priority = priority;
        this.status = status;
        this.deliveryId = deliveryId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(int deliveryId) {
        this.deliveryId = deliveryId;
    }
}
