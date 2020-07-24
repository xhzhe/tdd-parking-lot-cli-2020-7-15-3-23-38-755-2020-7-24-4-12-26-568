package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.ParkingLot;
import com.oocl.cultivation.Ticket;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingBoyFacts {
    @Test
    public void should_return_ticket_when_parking_given_car() {
        //given
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();
        //when
        Ticket ticket = parkingLot.park(car);
        //then
        assertNotNull(ticket);
    }

    @Test
    public void should_return_car_when_park_given_ticket() {
        //given
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();
        //when
        Ticket ticket = parkingLot.park(car);
        Car carGetFromParkingLot = parkingLot.fetchCar(ticket);
        //then
        assertNotNull(ticket);
        assertEquals(car, carGetFromParkingLot);
    }

    @Test
    public void should_return_null_when_park_given_wrong_ticket() {
        //given
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();
        Ticket ticket = new Ticket();
        //when
        Car carGetFromParkingLot = parkingLot.fetchCar(ticket);
        //then
        assertNull(carGetFromParkingLot);
    }

    @Test
    public void should_return_null_when_park_given_same_ticket_twice() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Ticket ticket = new Ticket();
        //when
        Car carGetFromParkingLot = parkingLot.fetchCar(ticket);
        Car carFetchTwice = parkingLot.fetchCar(ticket);
        //then
        assertNull(carFetchTwice);
    }
}
