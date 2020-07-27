package com.oocl.cultivation;

import java.util.List;

public class NormalParkStrategy implements ParkStrategy {
    @Override
    public Ticket park(Car car, List<ParkingLot> parkingLots) {
        for (ParkingLot parkingLot : parkingLots) {
            if (!(parkingLot.getCarsCount() + 1 > parkingLot.getCapacity())) {
                return parkingLot.park(car);
            }
        }
        return null;
    }
}
