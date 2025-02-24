package CarRentalSystem;

import CarRentalSystem.Enum.*;

import java.util.List;

public class Car{
    public int carId;
    int carNumber;
    CarType carType;
    CarAvailability carAvailability;
    Location location;
    EngineType engineType;
    int dailyRentalCost;
    int hourlyRentalCost;
    Brand brand;

    public Car(int carId, int carNumber, CarType carType, CarAvailability carAvailability,
               Brand brand, Location location, EngineType engineType, int dailyRentalCost, int hourlyRentalCost) {
        this.brand = brand;
        this.hourlyRentalCost = hourlyRentalCost;
        this.dailyRentalCost = dailyRentalCost;
        this.engineType = engineType;
        this.location = location;
        this.carAvailability = carAvailability;
        this.carType = carType;
        this.carNumber = carNumber;
        this.carId = carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public void setCarNumber(int carNumber) {
        this.carNumber = carNumber;
    }

    public int getCarId() {
        return carId;
    }

    public int getCarNumber() {
        return carNumber;
    }

    public CarType getCarType() {
        return carType;
    }

    public CarAvailability getCarAvailability() {
        return carAvailability;
    }

    public Location getLocation() {
        return location;
    }

    public EngineType getEngineType() {
        return engineType;
    }

    public int getDailyRentalCost() {
        return dailyRentalCost;
    }

    public int getHourlyRentalCost() {
        return hourlyRentalCost;
    }

    public Brand getBrand() {
        return brand;
    }


    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    public void setCarAvailability(CarAvailability carAvailability) {
        this.carAvailability = carAvailability;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setEngineType(EngineType engineType) {
        this.engineType = engineType;
    }

    public void setDailyRentalCost(int dailyRentalCost) {
        this.dailyRentalCost = dailyRentalCost;
    }

    public void setHourlyRentalCost(int hourlyRentalCost) {
        this.hourlyRentalCost = hourlyRentalCost;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

}
