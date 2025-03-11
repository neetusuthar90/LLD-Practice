package CabBooking;


import CabBooking.Entity.Driver;
import CabBooking.Entity.Location;
import CabBooking.Entity.Rider;
import CabBooking.Entity.Trip;
import CabBooking.Enum.VehicleType;
import CabBooking.Managers.DriverManager;
import CabBooking.Managers.RiderManager;
import CabBooking.Managers.TripManager;

public class Application {
    public static void main(String[] args){

        DriverManager driverManager = new DriverManager();
        RiderManager riderManager = new RiderManager();
        TripManager tripManager = new TripManager(driverManager);


        Rider neetuRider = new Rider(1, "Neetu");
        Rider liptanRider = new Rider(2, "Liptan");
        riderManager.addRider(neetuRider);
        riderManager.addRider(liptanRider);


        Driver rajeshDriver = new Driver(101, "Rajesh", VehicleType.AUTO, new Location(30.12, 132.22));
        Driver sureshDriver = new Driver(102, "Suresh", VehicleType.CAB, new Location(170.12, -132.22));
        Driver rameshDriver = new Driver(103, "Ramesh", VehicleType.AUTO, new Location(330.12, 244.22));
        driverManager.addDriver(rajeshDriver);
        driverManager.addDriver(sureshDriver);
        driverManager.addDriver(rameshDriver);

        Location source = new Location(37.979, 100.2);
        Location destination = new Location(267.53, -2568.8);

        //request ride
        Trip trip = tripManager.requestTrip(201, neetuRider, source, destination, VehicleType.AUTO);
        tripManager.addTrip(trip);

        tripManager.startTrip();

        tripManager.endTrip();

        tripManager.makePayment(trip);
    }
}
