package com.example.airline_api.components;

import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.repositories.FlightRepository;
import com.example.airline_api.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private PassengerRepository passengerRepository;



    @Override
    public void run(ApplicationArguments args) throws Exception {
        // Create and save flights
        Flight flight1 = new Flight("New York", 100, LocalDate.of(2023, 6, 15), LocalTime.of(10, 0));
        Flight flight2 = new Flight("London", 80, LocalDate.of(2023, 6, 20), LocalTime.of(14, 30));
        flightRepository.save(flight1);
        flightRepository.save(flight2);

        // Create and save passengers
        Passenger passenger1 = new Passenger("Aurora Frost", "aurora.frost@hotmail.com");
        Passenger passenger2 = new Passenger("Jasper Blackwood", "jasper.blackwood@gmail.com");
        passengerRepository.save(passenger1);
        passengerRepository.save(passenger2);


    }


    }
