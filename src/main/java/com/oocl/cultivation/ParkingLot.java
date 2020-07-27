package com.oocl.cultivation;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot implements Parkable {
    private final Map<Ticket, Car> parkingLot;
    private final int capacity;

    public ParkingLot() {
        this.capacity = 10;
        this.parkingLot = new HashMap<>(16);
    }

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        this.parkingLot = new HashMap<>(16);
    }

    public Ticket park(Car car) {
        Ticket ticket = new Ticket();
        this.parkingLot.put(ticket, car);
        return ticket;
    }


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
