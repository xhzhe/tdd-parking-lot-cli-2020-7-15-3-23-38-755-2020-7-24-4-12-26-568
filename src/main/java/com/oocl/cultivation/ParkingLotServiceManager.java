package com.oocl.cultivation;

import java.util.List;
import java.util.Random;

public class ParkingLotServiceManager {
    private final List<parkable> parkables;

    public ParkingLotServiceManager(List<parkable> parkables) {
        this.parkables = parkables;
    }

    public Ticket park(Car car) {
        Random random = new Random(System.currentTimeMillis());
        int index = random.nextInt(parkables.size());
        return parkables.get(index).park(car);
    }
}
