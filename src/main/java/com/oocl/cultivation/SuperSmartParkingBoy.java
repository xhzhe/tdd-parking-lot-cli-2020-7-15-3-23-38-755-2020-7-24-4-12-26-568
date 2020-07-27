package com.oocl.cultivation;

import java.util.List;

public class SuperSmartParkingBoy extends ParkingBoy {

    public SuperSmartParkingBoy(ParkingLot parkingLot) {
        super(parkingLot);
    }

    public SuperSmartParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    public Ticket park(Car car) {
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
        return parkingLots.get(indexOfParkingLot).park(car);
    }
}
