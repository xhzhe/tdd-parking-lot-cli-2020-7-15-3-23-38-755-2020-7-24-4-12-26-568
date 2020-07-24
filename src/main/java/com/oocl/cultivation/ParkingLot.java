package com.oocl.cultivation;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private Map<Ticket, Car> parkingLot;

    public ParkingLot() {
        this.parkingLot = new HashMap<>(16);
    }

    public Ticket park(Car car) {
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
