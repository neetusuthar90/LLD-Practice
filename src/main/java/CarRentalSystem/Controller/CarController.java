package CarRentalSystem.Controller;

import CarRentalSystem.*;
import CarRentalSystem.Enum.Location;
import CarRentalSystem.Services.BookingService;
import CarRentalSystem.Services.CarManagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/cars")
public class CarController {

    @Autowired
    private CarManagement carManagement;

    @Autowired
    private BookingService bookingService;

    @GetMapping
    public String startRenting() {
        return "Start Renting";
    }

    @GetMapping("/available-cars")
    public List<Car> getAllAvailableCars() {
        return carManagement.getAvailableCars();
    }

    @GetMapping("/by-location")
    public List<Car> getCarsByLocation(@RequestParam String location) {
        try {
            Location locationEnum = Location.valueOf(location.toUpperCase());
            return carManagement.getCarsByLocation(locationEnum);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Invalid location. Available options are: PUNE, MUMBAI, DELHI.");
        }
    }


    @PostMapping("/book")
    public Booking bookCar(
            @RequestParam int carId,
            @RequestParam int userId,
            @RequestParam String userName,
            @RequestParam LocalDateTime startTime,
            @RequestParam LocalDateTime endTime) {
        User user = new User(userId, userName, 456);
        return bookingService.bookCar(user, carId, startTime, endTime);
    }

    @GetMapping("/{carId}")
    public Car getCarByNumber(@PathVariable int carId) {
        return carManagement.getCarByNumber(carId);
    }

    @DeleteMapping("/delete/{carId}")
    public String deleteCar(@PathVariable int carId) {
        Car car = carManagement.getCarByNumber(carId);
        if (car != null) {
            carManagement.removeCar(car);
            return "Car with ID " + carId + " has been removed.";
        } else {
            return "Car not found!";
        }
    }

    @PatchMapping("/{carId}/update-cost")
    public String updateHourlyRentalCost(@PathVariable int carId, @RequestParam int newCost){
        boolean updated = carManagement.updateHourlyRentalCost(carId, newCost);
        if(updated){
            return "Hourly rental cost updated successfully for car ID " + carId;
        }else{
            return "Car not found or update failed!";
        }
    }
}
