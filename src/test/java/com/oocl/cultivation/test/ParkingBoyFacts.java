package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.ParkingLot;
import com.oocl.cultivation.Ticket;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingBoyFacts {
    @Test
    public void should_return_ticket_when_park_given_car() {
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
        assertEquals(car, carGetFromParkingLot);
    }

    @Test
    public void should_return_null_when_park_given_wrong_ticket() {
        //given
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
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();
        //when
        Ticket ticket = parkingLot.park(car);
        parkingLot.fetchCar(ticket);
        Car carFetchTwice = parkingLot.fetchCar(ticket);
        //then
        assertNull(carFetchTwice);
    }

    @Test
    public void should_return_null_when_park_given_too_much_car() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Ticket ticket = new Ticket();
        //when
        for (int times = 0; times < 11; times++) {
            ticket = parkingLot.park(new Car());
        }
        //then
        assertNull(ticket);
    }

    @Test
    public void should_return_correspond_car_when_park_given_correspond_ticket() {
        //given
        Car car1 = new Car();
        Car car2 = new Car();
        ParkingLot parkingLot = new ParkingLot();
        //when
        Ticket ticket1 = parkingLot.park(car1);
        Ticket ticket2 = parkingLot.park(car2);
        Car carGetFromParkingLot1 = parkingLot.fetchCar(ticket1);
        Car carGetFromParkingLot2 = parkingLot.fetchCar(ticket2);
        //then
        assertEquals(car1, carGetFromParkingLot1);
        assertEquals(car2, carGetFromParkingLot2);
    }
}
