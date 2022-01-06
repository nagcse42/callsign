package com.assignment.callsign.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import com.assignment.callsign.entity.DeliveryDetails;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface DeliveryDetailsRepository extends JpaRepository<DeliveryDetails, Long> {

    @Query("SELECT d FROM DeliveryDetails d WHERE d.deliveryStatus != 'DELIVERED'")
    Set<DeliveryDetails> findUnDeliveredOrders();
}
