package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ParkingBoy implements Parkable {
    protected final List<ParkingLot> parkingLots;

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLots = new ArrayList<>();
        this.parkingLots.add(parkingLot);
    }

    public ParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    @Override
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

    @Override
    public Ticket park(Car car) {
        boolean full = isParkingLotsFull();
        if (full) {
            System.out.print("Not enough position.\n");
        }
        Optional<ParkingLot> optionalParkingLot = parkingLots.stream().
                filter(parkingLot -> parkingLot.getCarsCount() < parkingLot.getCapacity()).
                findFirst();
        return optionalParkingLot.map(parkingLot -> parkingLot.park(car)).orElse(null);
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