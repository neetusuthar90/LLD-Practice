package CabBooking.Services;

import CabBooking.Entity.Driver;
import CabBooking.Entity.Location;

import java.util.List;

public interface DriverMatchingStrategy {
    Driver matchDriver(Location source, List<Driver> driverList);
}
