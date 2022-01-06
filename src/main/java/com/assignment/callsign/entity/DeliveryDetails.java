package com.assignment.callsign.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "CARD_DETAILS")
public class DeliveryDetails {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "DELIVERY_ID")
    private int deliveryId;

    @Column(name = "CUSTOMER_TYPE")
    private String customerType;

    @Column(name = "DELIVERY_STATUS")
    private String deliveryStatus;

    @Column(name = "EXPECTED_DELIVERY_TIME")
    private LocalDateTime expectedDeliveryTime;

    @Column(name = "CURRENT_DISTANCE_FROM_DESTINATION_IN_METERS")
    private int currentDistFromDestinationInMeters;

    @Column(name = "TIME_TO_REACH_DESTINATION")
    private LocalDateTime timeToReachDestination;

    @CreatedDate
    @Column(name = "ISSUED_TIME")
    private LocalDateTime createdTime;

    @LastModifiedDate
    @Column(name = "UPDATED_TIME")
    private LocalDateTime updatedTime;

    public DeliveryDetails(int deliveryId, String customerType, String deliveryStatus, LocalDateTime expectedDeliveryTime, int currentDistFromDestinationInMeters, LocalDateTime timeToReachDestination, LocalDateTime createdTime, LocalDateTime updatedTime) {
        this.deliveryId = deliveryId;
        this.customerType = customerType;
        this.deliveryStatus = deliveryStatus;
        this.expectedDeliveryTime = expectedDeliveryTime;
        this.currentDistFromDestinationInMeters = currentDistFromDestinationInMeters;
        this.timeToReachDestination = timeToReachDestination;
        this.createdTime = createdTime;
        this.updatedTime = updatedTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(int deliveryId) {
        this.deliveryId = deliveryId;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public LocalDateTime getExpectedDeliveryTime() {
        return expectedDeliveryTime;
    }

    public void setExpectedDeliveryTime(LocalDateTime expectedDeliveryTime) {
        this.expectedDeliveryTime = expectedDeliveryTime;
    }

    public int getCurrentDistFromDestinationInMeters() {
        return currentDistFromDestinationInMeters;
    }

    public void setCurrentDistFromDestinationInMeters(int currentDistFromDestinationInMeters) {
        this.currentDistFromDestinationInMeters = currentDistFromDestinationInMeters;
    }

    public LocalDateTime getTimeToReachDestination() {
        return timeToReachDestination;
    }

    public void setTimeToReachDestination(LocalDateTime timeToReachDestination) {
        this.timeToReachDestination = timeToReachDestination;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public LocalDateTime getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(LocalDateTime updatedTime) {
        this.updatedTime = updatedTime;
    }
}
