package com.oocl.cultivation;

public class ParkingBoy {
    private final ParkingLot parkingLot;

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public Car fetchCar(Ticket ticket) {
        return this.parkingLot.fetchCar(ticket);
    }

    public Ticket park(Car car) {
        if (this.parkingLot.size() + 1 > this.parkingLot.getCapacity()) {
            return null;
        }
        return this.parkingLot.park(car);
    }

    public String getReason(Ticket ticket) {
        if (ticket == null) {
            return "Please provide your parking ticket.";
        }
        return "Unrecognized parking ticket.";
    }

    public String getReason(Car car) {
        return "Not enough position.";
    }
}