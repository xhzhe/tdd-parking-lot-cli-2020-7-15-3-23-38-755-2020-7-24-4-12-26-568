package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.List;

public class ParkingBoy {
    private final List<ParkingLot> parkingLots;
    private final ParkStrategy parkStrategy;

    public ParkingBoy(ParkingLot parkingLot, ParkStrategy parkStrategy) {
        this.parkingLots = new ArrayList<>();
        this.parkingLots.add(parkingLot);
        this.parkStrategy = parkStrategy;
    }

    public ParkingBoy(List<ParkingLot> parkingLots, ParkStrategy parkStrategy) {
        this.parkingLots = parkingLots;
        this.parkStrategy = parkStrategy;
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
        return parkStrategy.park(car, this.parkingLots);
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