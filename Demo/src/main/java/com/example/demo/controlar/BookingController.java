package com.example.demo.controlar;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Booking;
import com.example.demo.service.BookingService;

@RestController
@RequestMapping("/booking")
public class BookingController {
	
	@Autowired
	private BookingService bookingService;

	@RequestMapping(value = "/{email:.+}", method = RequestMethod.GET)
	public List<Booking> findUserBookings(@PathVariable(name = "email", value = "email") String email) {

		List<Booking> bookings = bookingService.findUserBookings(email);
		System.out.println("bookings: "+bookings.get(0).getBookingAmount());
		return bookings;
	}

}
