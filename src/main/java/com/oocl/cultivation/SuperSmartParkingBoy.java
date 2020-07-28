package com.oocl.cultivation;

import java.util.Comparator;
import java.util.List;

public class SuperSmartParkingBoy extends ParkingBoy {

    public SuperSmartParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    public Ticket park(Car car) {
        return parkingLots.stream().max(Comparator.comparing(ParkingLot::getRemainingRate)).map(parkingLot -> parkingLot.park(car)).orElse(null);
    }
}
