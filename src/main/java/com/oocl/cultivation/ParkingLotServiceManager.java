package com.oocl.cultivation;

import java.util.List;
import java.util.Random;

public class ParkingLotServiceManager extends ParkingBoy {
    private final List<ParkingBoy> parkingBoys;

    public ParkingLotServiceManager(List<ParkingBoy> parkingBoys, List<ParkingLot> parkingLots) {
        super(parkingLots, new NormalParkStrategy());
        this.parkingBoys = parkingBoys;
    }

    public Ticket askBoyToPark(Car car) {
        Random random = new Random(System.currentTimeMillis());
        int index = random.nextInt(parkingBoys.size());
        return parkingBoys.get(index).park(car);
    }
}
