package com.oocl.cultivation.test;

import com.oocl.cultivation.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotServiceManagerTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    void before() {
        System.setOut(new PrintStream(outContent));
    }
    private String systemOut() {
        return outContent.toString();
    }
    @Test
    public void should_return_ticket_when_park_given_car() {
        //given
        List<ParkingBoy> parkingBoys = new ArrayList<>();
        for (int times = 0; times < 5; times++) {
            parkingBoys.add(new ParkingBoy(new ParkingLot(), new NormalParkStrategy()));
        }
        ParkingLotServiceManager parkingLotServiceManager = new ParkingLotServiceManager(parkingBoys, null);
        //when
        Ticket ticket = parkingLotServiceManager.askBoyToPark(new Car());
        //then
        assertNotNull(ticket);
    }

    @Test
    public void should_return_ticket_when_park_itself_given_car() {
        //given
        List<ParkingBoy> parkingBoys = new ArrayList<>();
        for (int times = 0; times < 5; times++) {
            parkingBoys.add(new ParkingBoy(new ParkingLot(), new NormalParkStrategy()));
        }
        ParkingLotServiceManager parkingLotServiceManager = new ParkingLotServiceManager(parkingBoys, new ArrayList<>(Arrays.asList(new ParkingLot(), new ParkingLot())));
        //when
        Ticket ticket = parkingLotServiceManager.park(new Car());
        //then
        assertNotNull(ticket);
    }

    @Test
    public void should_return_message_when_park_given_too_much_cars() {
        //given
        List<ParkingBoy> parkingBoys = new ArrayList<>();
        for (int times = 0; times < 5; times++) {
            parkingBoys.add(new ParkingBoy(new ParkingLot(), new NormalParkStrategy()));
        }
        ParkingLotServiceManager parkingLotServiceManager = new ParkingLotServiceManager(parkingBoys, new ArrayList<>(Arrays.asList(new ParkingLot(), new ParkingLot())));
        Ticket ticket = new Ticket();
        //when
        for (int times = 0; times < 100; times++) {
            ticket = parkingLotServiceManager.park(new Car());
        }
        //then
        assertNull(ticket);
        assertTrue(systemOut().endsWith("Not enough position.\n"));
    }
}
