package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.booking.dao.BookingDao;
import com.example.demo.domain.Booking;
import com.example.demo.domain.UserDetails;
import com.example.demo.user.dao.UserDao;

@Service
public class BookingServiceImpl implements BookingService{
	
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private BookingDao bookingDao;

	@Override
	public List<Booking> findUserBookings(String emailId){
		UserDetails userdetails = userDao.findByEmail(emailId);
		System.out.println(userdetails.getId());
		List<Booking> bookings = bookingDao.findByCreatedBy(userdetails.getId());
		return bookings;
	}
}
