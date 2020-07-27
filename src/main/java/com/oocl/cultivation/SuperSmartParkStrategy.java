package com.oocl.cultivation;

import java.util.List;

public class SuperSmartParkStrategy implements ParkStrategy{
    @Override
    public Ticket park(Car car, List<ParkingLot> parkingLots) {
        int indexOfParkingLot = 0;
        double remainingRate = parkingLots.get(0).getRemainingRate();
        for (int index = 0; index < parkingLots.size(); index++) {
            ParkingLot parkingLot = parkingLots.get(index);
            double margin = parkingLot.getRemainingRate();
            if (margin > remainingRate) {
                indexOfParkingLot = index;
                remainingRate = margin;
            }
        }
        if (remainingRate > 0) {
            return parkingLots.get(indexOfParkingLot).park(car);
        }
        return null;
    }
}
