package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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
        Optional<Car> optionalCar = parkingLots.stream().map(parkingLot -> parkingLot.fetchCar(ticket)).filter(Objects::nonNull).findFirst();
        if (!optionalCar.isPresent()) {
            System.out.print("Unrecognized parking ticket.\n");
        }
        return optionalCar.orElse(null);
    }

    @Override
    public Ticket park(Car car) {
        if (isParkingLotsFull()) {
            System.out.print("Not enough position.\n");
        }
        Optional<ParkingLot> optionalParkingLot = parkingLots.stream().
                filter(parkingLot -> parkingLot.getCarsCount() < parkingLot.getCapacity()).
                findFirst();
        return optionalParkingLot.map(parkingLot -> parkingLot.park(car)).orElse(null);
    }

    private boolean isParkingLotsFull() {
        return parkingLots.stream().anyMatch(parkingLot -> parkingLot.getRemainingPosition() > 0);
    }

    public int getParkingLotSize(int index) {
        return this.parkingLots.get(index).getCarsCount();
    }
}