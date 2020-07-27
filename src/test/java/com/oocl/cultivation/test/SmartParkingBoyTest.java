package com.oocl.cultivation.test;

import com.oocl.cultivation.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class SmartParkingBoyTest {
    @Test
    public void should_return_5_size_of_parking_lot_when_park_given_10_cars() {
        //given
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot());
        parkingLots.add(new ParkingLot());
        SmartParkingBoy parkingBoy = new SmartParkingBoy(parkingLots);
        //when
        for (int times = 0; times < 10; times++) {
            parkingBoy.park(new Car());
        }
        //then
        assertEquals(parkingBoy.getParkingLotSize(0), 5);
        assertEquals(parkingBoy.getParkingLotSize(1), 5);
    }

    @Test
    public void should_return_null_when_parking_given_21_cars() {
        //given
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot());
        parkingLots.add(new ParkingLot());
        SmartParkingBoy parkingBoy = new SmartParkingBoy(parkingLots);
        Ticket ticket = new Ticket();
        //when
        for (int times = 0; times < 21; times++) {
            ticket = parkingBoy.park(new Car());
        }
        //then
        assertEquals(parkingBoy.getParkingLotSize(0), 10);
        assertEquals(parkingBoy.getParkingLotSize(1), 10);
        assertNull(ticket);
    }
}
