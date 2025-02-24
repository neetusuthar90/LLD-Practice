package CarRentalSystem.Services;

import CarRentalSystem.Car;
import CarRentalSystem.Enum.CarAvailability;
import CarRentalSystem.Enum.Location;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarManagement {
    private final List<Car> carList = new ArrayList<>();

    public void initializeCars(List<Car> cars) {
        carList.addAll(cars);
    }

    public List<Car> getAvailableCars() {
        return carList.stream()
                .filter(car -> car.getCarAvailability() == CarAvailability.AVAILABLE)
                .collect(Collectors.toList());
    }

    public Car getCarByNumber(int carId) {
        return carList.stream()
                .filter(car -> car.getCarId() == carId)
                .findFirst()
                .orElse(null);
    }

    public List<Car> getCarsByLocation(Location location) {
        return carList.stream()
                .filter(car -> car.getLocation() == location)
                .collect(Collectors.toList());
    }

    public void removeCar(Car car) {
        carList.remove(car);
    }

    public boolean updateHourlyRentalCost(int carId, int newCost) {
        for(Car car:carList){
            if(car.getCarId() == carId){
                car.setHourlyRentalCost(newCost);
                return true;
            }
        }
        return false;
    }
}
