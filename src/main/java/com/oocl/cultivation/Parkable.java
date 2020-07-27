package com.oocl.cultivation;

public interface Parkable {
    Ticket park(Car car);

    Car fetchCar(Ticket ticket);
}
