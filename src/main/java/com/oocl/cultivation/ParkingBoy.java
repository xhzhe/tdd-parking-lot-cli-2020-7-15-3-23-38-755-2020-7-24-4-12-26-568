package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.List;

public class ParkingBoy {
    private final List<ParkingLot> parkingLots;

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLots = new ArrayList<>();
        this.parkingLots.add(parkingLot);
    }

    public ParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public Car fetchCar(Ticket ticket) {
        for (ParkingLot parkingLot : this.parkingLots) {
            Car car = parkingLot.fetchCar(ticket);
            if (car != null) {
                return car;
            }
        }
        return null;
    }

    public Ticket park(Car car) {
        for (ParkingLot parkingLot : this.parkingLots) {
            if (!(parkingLot.size() + 1 > parkingLot.getCapacity())) {
                return parkingLot.park(car);
            }
        }
        return null;
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

    public List<ParkingLot> getParkingLots() {
        return this.parkingLots;
    }
}