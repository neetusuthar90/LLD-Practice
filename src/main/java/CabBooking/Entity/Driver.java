package CabBooking.Entity;

import CabBooking.Enum.DriverStatus;
import CabBooking.Enum.VehicleType;

public class Driver {
    private int driverId;
    private String driverName;
    private VehicleType vehicleType;
    private DriverStatus driverStatus;
    private Location currentLocation;

    public Driver(int driverId, String driverName, VehicleType vehicleType, Location location) {
        this.driverId = driverId;
        this.driverName = driverName;
        this.vehicleType = vehicleType;
        this.driverStatus = DriverStatus.AVAILABLE;
        this.currentLocation = location;
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }

    public DriverStatus getDriverStatus() {
        return driverStatus;
    }

    public void setDriverStatus(DriverStatus driverStatus) {
        this.driverStatus = driverStatus;
    }

    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
}
