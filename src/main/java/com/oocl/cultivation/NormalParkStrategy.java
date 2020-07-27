package com.oocl.cultivation;

import java.util.List;
import java.util.Optional;

public class NormalParkStrategy implements ParkStrategy {
    @Override
    public Ticket park(Car car, List<ParkingLot> parkingLots) {
        Optional<ParkingLot> optionalParkingLot = parkingLots.stream().
                filter(parkingLot -> parkingLot.getCarsCount() < parkingLot.getCapacity()).
                findFirst();
        return optionalParkingLot.map(parkingLot -> parkingLot.park(car)).orElse(null);
    }
}
