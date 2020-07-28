package com.oocl.cultivation;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot implements Parkable {
    public static final int DEFAULT_CAPACITY = 10;
    private final Map<Ticket, Car> parkingLot;
    private final int capacity;

    public ParkingLot() {
        this.capacity = DEFAULT_CAPACITY;
        this.parkingLot = new HashMap<>(16);
    }

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        this.parkingLot = new HashMap<>(16);
    }

    @Override
    public Ticket park(Car car) {
        if (this.parkingLot.size() >= this.capacity) {
            return null;
        }
        Ticket ticket = new Ticket();
        this.parkingLot.put(ticket, car);
        return ticket;
    }


    @Override
    public Car fetchCar(Ticket ticket) {
        return this.parkingLot.remove(ticket);
    }

    public int getCarsCount() {
        return this.parkingLot.size();
    }

    public int getCapacity() {
        return capacity;
    }

    public int getRemainingPosition() {
        return capacity - this.parkingLot.size();
    }

    public double getRemainingRate() {
        return (double) (capacity - this.parkingLot.size()) / this.capacity;
    }
}
