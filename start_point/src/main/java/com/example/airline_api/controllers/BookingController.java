package com.example.airline_api.controllers;

import com.example.airline_api.models.Booking;
import com.example.airline_api.models.BookingDTO;
import com.example.airline_api.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    BookingService bookingService;

    // Display all bookings
    @GetMapping
    public ResponseEntity<List<Booking>> getAllBookings(){
        List<Booking> bookings = bookingService.getAllBookings();
        return new ResponseEntity<>(bookings, HttpStatus.OK);
    }

    // Add details of a new booking
    @PostMapping
    public ResponseEntity<Long> bookPassengerOnFlight(@RequestBody BookingDTO bookingDTO) {
        // Call the service method to book the passenger on the flight
        Long bookingId = bookingService.bookPassengerOnFlight(bookingDTO);

        // Check if the booking was successful
        if (bookingId != null) {
            // Return a response with the created booking ID and a status code of 201 CREATED
            return new ResponseEntity<>(bookingId, HttpStatus.CREATED);
        } else {
            // Return a response with a status code of 400 BAD REQUEST if the booking failed
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    // TODO: Extension - Update passenger meal preference
    @PatchMapping
    public ResponseEntity<Booking> updateMealPreference(){
        return null;
    }

}
