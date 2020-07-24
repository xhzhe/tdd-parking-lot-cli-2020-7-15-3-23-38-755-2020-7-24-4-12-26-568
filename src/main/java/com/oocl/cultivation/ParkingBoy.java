package com.oocl.cultivation;

public class ParkingBoy {
    private final ParkingLot parkingLot;

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public String getReason(Ticket ticket) {
        if (ticket == null) {
            return "Please provide your parking ticket.";
        }
        return "Unrecognized parking ticket.";
    }
}