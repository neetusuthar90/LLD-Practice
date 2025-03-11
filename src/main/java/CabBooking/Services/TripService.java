package CabBooking.Services;

import CabBooking.Entity.Driver;
import CabBooking.Entity.Location;
import CabBooking.Entity.Rider;
import CabBooking.Entity.Trip;
import CabBooking.Enum.DriverStatus;
import CabBooking.Enum.VehicleType;
import CabBooking.Managers.TripManager;

import java.util.List;

public class TripService {
    private final DriverService driverService;
    private final TripManager tripManager;

    public TripService(DriverService driverService, TripManager tripManager) {
        this.driverService = driverService;
        this.tripManager = tripManager;
    }

    public Trip requestTrip(int tripId, Rider rider, Location source, Location destination, VehicleType vehicleType) {
        Driver driver = driverService.findAvailableDriver(source, vehicleType);
        if (driver == null) {
            System.out.println("No suitable driver found.");
            return null;
        }
        Trip trip = new Trip(tripId, driver, rider, source, destination);
        driverService.setDriverStatus(driver, DriverStatus.BUSY);
        tripManager.addTrip(trip);
        return trip;
    }

    public void startTrip(Trip trip) {
        System.out.println("Trip started: " + trip.getTripId());
    }

    public void endTrip(Trip trip) {
        System.out.println("Trip ended: " + trip.getTripId());
        driverService.setDriverStatus(trip.getDriver(), DriverStatus.AVAILABLE);
    }
}

