package com.oocl.cultivation;

import java.util.Comparator;
import java.util.List;

public class SmartParkingBoy extends ParkingBoy {

    public SmartParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    public Ticket park(Car car) {
        return parkingLots.stream().max(Comparator.comparing(ParkingLot::getRemainingPosition)).map(parkingLot -> parkingLot.park(car)).orElse(null);
    }
}
