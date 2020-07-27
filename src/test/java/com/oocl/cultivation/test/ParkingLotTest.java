package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.ParkingLot;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParkingLotTest {
    @Test
    public void should_return_1_when_park_given_car() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        //when
        parkingLot.park(new Car());
        //then
        assertEquals(1, parkingLot.getCarsCount());
    }

    @Test
    public void should_return_10_when_get_capacity_given_parking_lot() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        //when
        int capacity = parkingLot.getCapacity();
        //then
        assertEquals(10, capacity);
    }
}
