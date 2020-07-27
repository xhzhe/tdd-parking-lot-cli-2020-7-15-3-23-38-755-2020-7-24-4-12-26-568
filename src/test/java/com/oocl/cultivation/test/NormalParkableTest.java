package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.ParkingBoy;
import com.oocl.cultivation.ParkingLot;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NormalParkableTest {
    @Test
    public void should_return_size_when_get_parking_lot_given_parking_boy() {
        //given
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot());
        parkingLots.add(new ParkingLot());
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        //when
        int result1 = parkingBoy.getParkingLotSize(0);
        int result2 = parkingBoy.getParkingLotSize(1);
        //then
        assertEquals(parkingLots.get(0).getCarsCount(), result1);
        assertEquals(parkingLots.get(1).getCarsCount(), result2);
    }

    @Test
    public void should_return_size_when_get_parking_lot_given_11_cars() {
        //given
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot());
        parkingLots.add(new ParkingLot());
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        //when
        for (int times = 0; times < 11; times++) {
            parkingBoy.park(new Car());
        }
        int result = parkingBoy.getParkingLotSize(0);
        //then
        assertEquals(result, 10);
    }
}
