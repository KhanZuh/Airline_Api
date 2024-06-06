package com.example.airline_api.models;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class FlightDTO {

    private String destination;
    private int capacity;
    private LocalDate departureDate;
    private LocalTime departureTime;
    private List<Booking> bookings;


    public FlightDTO(String destination, int capacity, LocalDate departureDate, LocalTime departureTime, List<Booking> bookings) {
        this.destination = destination;
        this.capacity = capacity;
        this.departureDate = departureDate;
        this.departureTime = departureTime;
        this.bookings = bookings;
    }


    public FlightDTO() {
    }


    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }
}
