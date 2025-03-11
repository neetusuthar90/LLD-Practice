package CabBooking.Services;

import CabBooking.Entity.Driver;
import CabBooking.Enum.DriverStatus;
import CabBooking.Enum.VehicleType;
import CabBooking.Managers.DriverManager;

import javax.xml.stream.Location;
import java.util.List;

public class DriverService {
    private final DriverManager driverManager;
    private final DriverMatchingService matchingService;

    public DriverService(DriverManager driverManager, DriverMatchingService matchingService) {
        this.driverManager = driverManager;
        this.matchingService = matchingService;
    }

    public Driver findAvailableDriver(Location source, VehicleType vehicleType) {
        List<Driver> driverList = driverManager.getDriverList();
        return matchingService.findDriver((CabBooking.Entity.Location) source, driverList);
    }

    public void setDriverStatus(Driver driver, DriverStatus status) {
        driver.setDriverStatus(status);
    }
}
