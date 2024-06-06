package com.example.airline_api.models;

public class BookingDTO {

    private int seatNumber;
    private String mealPreference;
    private long passengerId;
    private long flightId;

    public BookingDTO(int seatNumber, String mealPreference, long passengerId, long flightId) {
        this.seatNumber = seatNumber;
        this.mealPreference = mealPreference;
        this.passengerId = passengerId;
        this.flightId = flightId;
    }

    public BookingDTO() {
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getMealPreference() {
        return mealPreference;
    }

    public void setMealPreference(String mealPreference) {
        this.mealPreference = mealPreference;
    }

    public long getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(long passengerId) {
        this.passengerId = passengerId;
    }

    public long getFlightId() {
        return flightId;
    }

    public void setFlightId(long flightId) {
        this.flightId = flightId;
    }

}
