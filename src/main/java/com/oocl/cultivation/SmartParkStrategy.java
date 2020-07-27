package com.oocl.cultivation;

import java.util.List;

public class SmartParkStrategy implements ParkStrategy {
    @Override
    public Ticket park(Car car, List<ParkingLot> parkingLots) {
        int indexOfParkingLot = 0;
        int remainingPosition = parkingLots.get(0).getRemainingPosition();
        for (int index = 0; index < parkingLots.size(); index++) {
            ParkingLot parkingLot = parkingLots.get(index);
            int margin = parkingLot.getRemainingPosition();
            if (margin > remainingPosition) {
                indexOfParkingLot = index;
                remainingPosition = margin;
            }
        }
        if (remainingPosition > 0) {
            return parkingLots.get(indexOfParkingLot).park(car);
        }
        return null;
    }
}
