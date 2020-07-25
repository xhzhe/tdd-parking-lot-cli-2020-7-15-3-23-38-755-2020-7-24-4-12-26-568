package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.ParkingBoy;
import com.oocl.cultivation.ParkingLot;
import com.oocl.cultivation.Ticket;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ParkingLotServiceManagerTest {
    @Test
    public void should_return_ticket_when_park_given_car() {
        //given
        List<ParkingBoy> parkingBoys = new ArrayList<>();
        for (int times = 0; times < 5; times++) {
            parkingBoys.add(new ParkingBoy(new ParkingLot()));
        }
        ParkingLotServiceManager parkingLotServiceManager = new ParkingLotServiceManager(parkingBoys);
        //when
        Ticket ticket = parkingLotServiceManager.askBoyToPark(new Car());
        //then
        assertNotNull(ticket);
    }
}
