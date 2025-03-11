package CabBooking.Managers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import CabBooking.Entity.*;
import CabBooking.Enum.DriverStatus;
import CabBooking.Enum.VehicleType;
import CabBooking.Services.DriverMatchingService;
import CabBooking.Services.LeastTimeDriverMatchingStrategy;

public class TripManager {
    private Map<Integer, Trip> tripMap;

    public TripManager(DriverManager driverManager){
        this.tripMap = new HashMap<>();
    }

    public void addTrip(Trip trip){
        tripMap.put(trip.getTripId(), trip);
    }

    public void makePayment(Trip trip) {
        Payment newPayment = new Payment(trip.getTripId()+23, 150, trip);
        newPayment.setStatus();
        System.out.println("The payment is successful!");
        return;
    }
}
