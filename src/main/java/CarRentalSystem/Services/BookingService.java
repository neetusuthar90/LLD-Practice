package CarRentalSystem.Services;

import CarRentalSystem.Booking;
import CarRentalSystem.Car;
import CarRentalSystem.Enum.CarAvailability;
import CarRentalSystem.Enum.Status;
import CarRentalSystem.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;

@Service
public class BookingService {

    @Autowired
    private CarManagement carManagement;

//    public List<Car> getAvailableCarsByTypeAndLocation(CarType type, Location location) {
//        return carList.stream()
//                .filter(car -> car.getCarAvailability() == CarAvailability.AVAILABLE)
//                .filter(car -> car.getLocation() == location)
//                .filter(car -> car.getCarType() == type)
//                .collect(Collectors.toList());
//    }

//    public Booking bookCar(User user, Car car, LocalDateTime startTime, LocalDateTime endTime){
//        Booking booking = null;
//        if(car.getCarAvailability() == CarAvailability.AVAILABLE){
//            long hours = Duration.between(startTime, endTime).toHours();
//            int totalCost = (int)hours * car.getHourlyRentalCost();
//
//            car.setCarAvailability(CarAvailability.BOOKED);
//            booking = new Booking(101,user, car.carId, startTime,endTime,totalCost);
//            booking.setStatus(Status.COMPLETED);
//        }
//        return booking;
//    }

        public Booking bookCar(User user, int carId, LocalDateTime startTime, LocalDateTime endTime) {
            Car car = carManagement.getCarByNumber(carId);
            if (car != null && car.getCarAvailability() == CarAvailability.AVAILABLE) {
                long hours = Duration.between(startTime, endTime).toHours();
                int totalCost = (int) hours * car.getHourlyRentalCost();

                car.setCarAvailability(CarAvailability.BOOKED);
                Booking booking = new Booking(101, user, car.getCarId(), startTime, endTime, totalCost);
                booking.setStatus(Status.COMPLETED);

                return booking;
            }
            return null;
        }
}
