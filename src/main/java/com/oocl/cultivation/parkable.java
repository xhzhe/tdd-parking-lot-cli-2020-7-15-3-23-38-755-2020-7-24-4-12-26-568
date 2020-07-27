package com.oocl.cultivation;

public interface parkable {
    Ticket park(Car car);

    Car fetchCar(Ticket ticket);
}
