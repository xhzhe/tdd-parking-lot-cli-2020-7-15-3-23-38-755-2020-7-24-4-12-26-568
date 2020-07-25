package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.ParkingBoy;
import com.oocl.cultivation.ParkingLot;
import com.oocl.cultivation.Ticket;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingBoyTest {

    @Test
    public void should_return_ticket_when_park_given_car() {
        //given
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        //when
        Ticket ticket = parkingBoy.park(car);
        //then
        assertNotNull(ticket);
    }

    @Test
    public void should_return_car_when_park_given_ticket() {
        //given
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        //when
        Ticket ticket = parkingBoy.park(car);
        Car carGetFromParkingLot = parkingBoy.fetchCar(ticket);
        //then
        assertEquals(car, carGetFromParkingLot);
    }

    @Test
    public void should_return_null_when_park_given_wrong_ticket() {
        //given
        Ticket ticket = new Ticket();
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        //when
        Car carGetFromParkingLot = parkingBoy.fetchCar(ticket);
        //then
        assertNull(carGetFromParkingLot);
    }

    @Test
    public void should_return_null_when_park_given_same_ticket_twice() {
        //given
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        //when
        Ticket ticket = parkingBoy.park(car);
        parkingBoy.fetchCar(ticket);
        Car carFetchTwice = parkingBoy.fetchCar(ticket);
        //then
        assertNull(carFetchTwice);
    }

    @Test
    public void should_return_null_when_park_given_too_much_car() {
        //given
        Ticket ticket = new Ticket();
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        //when
        for (int times = 0; times < 11; times++) {
            ticket = parkingBoy.park(new Car());
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
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        //when
        Ticket ticket1 = parkingBoy.park(car1);
        Ticket ticket2 = parkingBoy.park(car2);
        Car carGetFromParkingLot1 = parkingBoy.fetchCar(ticket1);
        Car carGetFromParkingLot2 = parkingBoy.fetchCar(ticket2);
        //then
        assertEquals(car1, carGetFromParkingLot1);
        assertEquals(car2, carGetFromParkingLot2);
    }

    @Test
    public void should_return_wrong_message_when_ask_parking_boy_given_non_provide_ticket() {
        //given
        Ticket ticket = new Ticket();
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        //when
        String message = parkingBoy.getReason(ticket);
        //then
        assertEquals("Unrecognized parking ticket.", message);
    }

    @Test
    public void should_return_wrong_message_when_ask_parking_boy_given_no_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        //when
        String message = parkingBoy.getReason((Ticket) null);
        //then
        assertEquals("Please provide your parking ticket.", message);
    }

    @Test
    public void should_return_wrong_message_when_ask_parking_boy_too_much_cars() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car = new Car();
        //when
        String message = parkingBoy.getReason(car);
        //then
        assertEquals("Not enough position.", message);
    }

    @Test
    public void should_return_list_when_get_parking_lot_given_parking_boy() {
        //given
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot());
        parkingLots.add(new ParkingLot());
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        //when
        List<ParkingLot> result = parkingBoy.getParkingLots();
        //then
        assertIterableEquals(parkingLots, result);
    }

    @Test
    public void should_return_full_list_when_get_parking_lot_given_11_cars() {
        //given
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot());
        parkingLots.add(new ParkingLot());
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        //when
        for (int times = 0; times < 11; times++) {
            parkingBoy.park(new Car());
        }
        List<ParkingLot> result = parkingBoy.getParkingLots();
        //then
        assertEquals(result.get(0).size(), 10);
    }
}
