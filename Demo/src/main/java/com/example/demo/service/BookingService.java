package com.example.demo.service;

import java.util.List;

import com.example.demo.booking.dao.BookingDao;
import com.example.demo.domain.Booking;


public interface BookingService {

	public List<Booking> findUserBookings(String emailId);
}
