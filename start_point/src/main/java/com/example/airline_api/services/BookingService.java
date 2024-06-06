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

import java.util.Optional;

@Service
public class BookingService {

    // Autowire the BookingRepository to access booking-related database operations
    @Autowired
    private BookingRepository bookingRepository;

    // Autowire the PassengerRepository to access passenger-related database operations
    @Autowired
    private PassengerRepository passengerRepository;

    // Autowire the FlightRepository to access flight-related database operations
    @Autowired
    private FlightRepository flightRepository;

    public Optional<Booking> bookPassengerOnFlight(Long passengerId, Long flightId, Booking booking) {
        // Retrieve the passenger and flight entities from their respective repositories
        Optional<Passenger> passengerOptional = passengerRepository.findById(passengerId);
        Optional<Flight> flightOptional = flightRepository.findById(flightId);

        // Check if both passenger and flight exist
        if (passengerOptional.isPresent() && flightOptional.isPresent()) {
            Passenger passenger = passengerOptional.get();
            Flight flight = flightOptional.get();

            // Set the passenger and flight for the booking
            booking.setPassenger(passenger);
            booking.setFlight(flight);

            // Save the booking using the booking repository
            return Optional.of(bookingRepository.save(booking));
        }

        // Return an empty Optional if either passenger or flight is not found
        return Optional.empty();
    }

}

