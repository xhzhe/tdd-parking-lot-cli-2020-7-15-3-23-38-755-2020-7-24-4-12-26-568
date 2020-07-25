package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.ParkingBoy;
import com.oocl.cultivation.ParkingLot;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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
        List<ParkingLot> result = parkingBoy.getParkingLots();
        //then
        assertEquals(result.get(0).size(), 5);
        assertEquals(result.get(1).size(), 5);
    }
}
