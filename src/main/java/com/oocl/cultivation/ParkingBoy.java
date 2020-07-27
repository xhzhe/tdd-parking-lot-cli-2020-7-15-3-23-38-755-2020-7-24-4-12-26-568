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
        if (ticket == null) {
            System.out.print("Please provide your parking ticket.\n");
            return null;
        }
        for (ParkingLot parkingLot : this.parkingLots) {
            Car car = parkingLot.fetchCar(ticket);
            if (car != null) {
                return car;
            }
        }
        System.out.print("Unrecognized parking ticket.\n");
        return null;
    }

    public Ticket park(Car car) {
        boolean full = isParkingLotsFull();
        if (full) {
            System.out.print("Not enough position.\n");
        }
        return parkStrategy.park(car, this.parkingLots);
    }

    private boolean isParkingLotsFull() {
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.getCarsCount() > 0) {
                return false;
            }
        }
        return true;
    }

    public int getParkingLotSize(int index) {
        return this.parkingLots.get(index).getCarsCount();
    }
}