package com.example.airline_api.services;

import com.example.airline_api.models.Flight;
import com.example.airline_api.models.FlightDTO;
import com.example.airline_api.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightService {

    @Autowired
    FlightRepository flightRepository;



    public Flight addNewFlight(FlightDTO flightDTO) {
//         Create a new Flight entity
        Flight flight = new Flight();
        flight.setDestination(flightDTO.getDestination());
        flight.setCapacity(flightDTO.getCapacity());
        flight.setDepartureDate(flightDTO.getDepartureDate());
        flight.setDepartureTime(flightDTO.getDepartureTime());
//         Save the Flight entity using the FlightRepository
        return flightRepository.save(flight);

    }




    public List<Flight> getAllFlights() {
        // Retrieve all flights from the database
        return flightRepository.findAll();
    }

    public Optional<Flight> getFlightById(Long id) {
        // Retrieve a flight by its ID from the database
        return flightRepository.findById(id);
    }

}
