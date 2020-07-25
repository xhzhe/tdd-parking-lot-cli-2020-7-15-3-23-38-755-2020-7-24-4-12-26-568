package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.NormalParkStrategy;
import com.oocl.cultivation.ParkingBoy;
import com.oocl.cultivation.ParkingLot;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class NormalParkStrategyTest {
    @Test
    public void should_return_list_when_get_parking_lot_given_parking_boy() {
        //given
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot());
        parkingLots.add(new ParkingLot());
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots,new NormalParkStrategy());
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
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots,new NormalParkStrategy());
        //when
        for (int times = 0; times < 11; times++) {
            parkingBoy.park(new Car());
        }
        List<ParkingLot> result = parkingBoy.getParkingLots();
        //then
        assertEquals(result.get(0).size(), 10);
    }
}
