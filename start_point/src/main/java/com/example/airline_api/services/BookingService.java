package com.example.airline_api.services;

import com.example.airline_api.models.Booking;
import com.example.airline_api.models.BookingDTO;
import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.repositories.BookingRepository;
import com.example.airline_api.repositories.FlightRepository;
import com.example.airline_api.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    // Autowire the BookingRepository to access booking-related database operations
    @Autowired
    BookingRepository bookingRepository;

    // Autowire the PassengerRepository to access passenger-related database operations
    @Autowired
    PassengerRepository passengerRepository;

    // Autowire the FlightRepository to access flight-related database operations
    @Autowired
    FlightRepository flightRepository;

    // Method to retrieve all bookings
    public List<Booking> getAllBookings(){
        return bookingRepository.findAll();
    }


    public Long bookPassengerOnFlight(BookingDTO bookingDTO) {
        // Find the passenger by their ID
        Optional<Passenger> passengerOptional = passengerRepository.findById(bookingDTO.getPassengerId());
        // Find the flight by its ID
        Optional<Flight> flightOptional = flightRepository.findById(bookingDTO.getFlightId());

        // Check if both the passenger and flight exist
        if (passengerOptional.isPresent() && flightOptional.isPresent()) {
            Passenger passenger = passengerOptional.get();
            Flight flight = flightOptional.get();

            // Check if there is available capacity on the flight
            if (flight.getCapacity() > flight.getBookings().size()) {
                // Create a new Booking object
                Booking booking = new Booking();
                // Set the passenger for the booking
                booking.setPassenger(passenger);
                // Set the flight for the booking
                booking.setFlight(flight);
                // Set the seat number for the booking
                booking.setSeatNumber(bookingDTO.getSeatNumber());
                // Set the meal preference for the booking
                booking.setMealPreference(bookingDTO.getMealPreference());

                // Save the booking to the database
                Booking savedBooking = bookingRepository.save(booking);

                // Return the ID of the saved booking
                return savedBooking.getId();
            }
        }
        // Return null if the booking failed (passenger or flight not found, or flight is full)
        return null;
    }

}

