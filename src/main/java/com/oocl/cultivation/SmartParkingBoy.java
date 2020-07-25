package com.oocl.cultivation;

import java.util.List;

public class SmartParkingBoy extends ParkingBoy {

    public SmartParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    public Ticket park(Car car) {
        List<ParkingLot> parkingLots = super.getParkingLots();
        int indexOfParkingLot = 0;
        int remainingPosition = parkingLots.get(0).getCapacity() - parkingLots.get(0).size();
        for (int index = 0; index < parkingLots.size(); index++) {
            ParkingLot parkingLot = parkingLots.get(index);
            int margin = parkingLot.getCapacity() - parkingLot.size();
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
