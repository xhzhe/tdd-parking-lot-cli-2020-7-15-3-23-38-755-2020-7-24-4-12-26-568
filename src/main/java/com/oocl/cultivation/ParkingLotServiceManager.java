package com.oocl.cultivation;

import java.util.List;
import java.util.Random;

public class ParkingLotServiceManager {
    private final List<Parkable> Parkables;

    public ParkingLotServiceManager(List<Parkable> Parkables) {
        this.Parkables = Parkables;
    }

    public Ticket park(Car car) {
        Random random = new Random(System.currentTimeMillis());
        int index = random.nextInt(Parkables.size());
        return Parkables.get(index).park(car);
    }
}
