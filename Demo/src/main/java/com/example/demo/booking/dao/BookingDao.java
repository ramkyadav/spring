package com.example.demo.booking.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Booking;

@Repository
public interface BookingDao extends JpaRepository<Booking, Long> {
	
	List<Booking> findByCreatedBy(Long userId);

}