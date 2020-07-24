package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.ParkingBoy;
import com.oocl.cultivation.ParkingLot;
import com.oocl.cultivation.Ticket;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingBoyTest {
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
        String message = parkingBoy.getReason(null);
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
}
