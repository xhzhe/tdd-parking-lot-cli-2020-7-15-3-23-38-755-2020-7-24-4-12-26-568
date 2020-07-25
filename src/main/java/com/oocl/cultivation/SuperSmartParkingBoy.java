package com.oocl.cultivation;

import java.util.List;

public class SuperSmartParkingBoy extends ParkingBoy {
    public SuperSmartParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    public Ticket park(Car car) {
        List<ParkingLot> parkingLots = super.getParkingLots();
        int indexOfParkingLot = 0;
        double remainingRate = (double) (parkingLots.get(0).getCapacity() - parkingLots.get(0).size()) / parkingLots.get(0).getCapacity();
        for (int index = 0; index < parkingLots.size(); index++) {
            ParkingLot parkingLot = parkingLots.get(index);
            double margin = (double) (parkingLot.getCapacity() - parkingLot.size()) / parkingLot.getCapacity();
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
