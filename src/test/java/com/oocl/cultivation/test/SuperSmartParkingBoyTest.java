package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.ParkingLot;
import com.oocl.cultivation.SmartParkingBoy;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SuperSmartParkingBoyTest {
    @Test
    public void should_return_correct_parking_lot_when_park_given_10_cars(){
        //given
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot(10));
        parkingLots.add(new ParkingLot(20));
        SuperSmartParkingBoy parkingBoy = new SuperSmartParkingBoy(parkingLots);
        //when
        for (int times = 0; times < 10; times++) {
            parkingBoy.park(new Car());
        }
        List<ParkingLot> result = parkingBoy.getParkingLots();
        //then
        assertEquals(result.get(0).size(), 4);
        assertEquals(result.get(1).size(), 6);
    }
}
