package com.oocl.cultivation;

import java.util.List;

public class SmartParkingBoy extends ParkingBoy {

    public SmartParkingBoy(ParkingLot parkingLot) {
        super(parkingLot);
    }

    public SmartParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    public Ticket park(Car car) {
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
