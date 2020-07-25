package com.oocl.cultivation;

import java.util.List;

public interface ParkStrategy {
    Ticket park(Car car, List<ParkingLot> parkingLots);
}
