package com.oocl.cultivation;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private final Map<Ticket, Car> parkingLot;
    private int capacity;

    public ParkingLot() {
        this.capacity = 10;
        this.parkingLot = new HashMap<>(16);
    }

    public Ticket park(Car car) {
        if (this.parkingLot.size() + 1 > capacity) {
            return null;
        }
        Ticket ticket = new Ticket();
        this.parkingLot.put(ticket, car);
        return ticket;
    }


    public Car fetchCar(Ticket ticket) {
        Car car = this.parkingLot.get(ticket);
        this.parkingLot.remove(ticket);
        return car;
    }
}
