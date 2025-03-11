package CabBooking.Services;

import CabBooking.Entity.Driver;
import CabBooking.Entity.Location;
import CabBooking.Enum.DriverStatus;

import java.util.List;

public class LeastTimeDriverMatchingStrategy implements DriverMatchingStrategy {
    @Override
    public Driver matchDriver(Location riderLocation, List<Driver> driverList){
        Driver matchDriver = null;
        double minDist = Double.MAX_VALUE;
        int count = 0;
        for(Driver driver:driverList){
            if(driver.getDriverStatus().equals(DriverStatus.BUSY)){
                System.out.println("What the hell");
                continue;
            }
            count++;
            Location driverLocation = driver.getCurrentLocation();
            double distance = calculateDistance(driverLocation, riderLocation);
            if(distance < minDist){
                minDist = distance;
                matchDriver = driver;
            }
        }
        System.out.println(count);
        return matchDriver;
    }

    public double calculateDistance(Location start, Location end) {
        return Math.sqrt(Math.pow(start.getLatitude()- end.getLatitude(), 2)
                + Math.pow(start.getLongitude() - end.getLongitude(), 2));
    }
}
