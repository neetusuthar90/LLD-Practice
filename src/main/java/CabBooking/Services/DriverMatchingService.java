package CabBooking.Services;

import CabBooking.Entity.Driver;
import CabBooking.Entity.Location;

import java.util.List;

public class DriverMatchingService {
    private final DriverMatchingStrategy strategy;

    public DriverMatchingService(DriverMatchingStrategy strategy) {
        this.strategy = strategy;
    }

    public Driver findDriver(Location source, List<Driver> driverList) {
        return strategy.matchDriver(source, driverList);
    }
}

