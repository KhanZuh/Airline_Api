package com.example.airline_api.controllers;

import com.example.airline_api.models.Booking;
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
    private BookingService bookingService;

    // TODO: Display all bookings
    @GetMapping
    public ResponseEntity<List<Booking>> getAllBookings(){
        return null;
    }

    // Add details of a new booking
    @PostMapping(value = "/{id}")
    public ResponseEntity<Booking> bookPassengerOnFlight(
            @PathVariable Long passengerId,
            @PathVariable Long flightId,
            @RequestBody Booking booking) {
        // Call the bookPassengerOnFlight method from the BookingService
        Optional<Booking> savedBookingOptional = bookingService.bookPassengerOnFlight(passengerId, flightId, booking);

        // Check if the saved booking is present
        if (savedBookingOptional.isPresent()) {
            // Return the saved booking with a 201 Created status
            return new ResponseEntity<>(savedBookingOptional.get(), HttpStatus.CREATED);
        } else {
            // Return a 404 Not Found status if the passenger or flight is not found
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // TODO: Extension - Update passenger meal preference
    @PatchMapping
    public ResponseEntity<Booking> updateMealPreference(){
        return null;
    }

}
