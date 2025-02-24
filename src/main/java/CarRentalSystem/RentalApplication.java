package CarRentalSystem;

import CarRentalSystem.Enum.*;
import CarRentalSystem.Services.CarManagement;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class RentalApplication {

    public static void main(String[] args) {
        SpringApplication.run(RentalApplication.class, args);
        System.out.println("🚗 Car Rental Application is running!");
    }

    @Bean
    public CommandLineRunner demoData(CarManagement carManagement) {
        return args -> {
            List<Car> cars = Arrays.asList(
                    new Car(1, 1001, CarType.SEDAN, CarAvailability.AVAILABLE, Brand.TATA, Location.PUNE, EngineType.PETROL, 1500, 2000),
                    new Car(2, 1002, CarType.SUV, CarAvailability.AVAILABLE, Brand.MARUTI, Location.MUMBAI, EngineType.CNG, 1700, 5000),
                    new Car(3, 1003, CarType.COMPACT_SUV, CarAvailability.AVAILABLE, Brand.KIA, Location.DELHI, EngineType.PETROL, 2000, 8000)
            );

            carManagement.initializeCars(cars);
            System.out.println("🚀 Demo data loaded successfully!");
        };
    }
}
