package CabBooking.Managers;

import CabBooking.Entity.Driver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DriverManager {
    private List<Driver> driverList;
    private Map<Integer, Driver> driverMap;

    public DriverManager(){
        this.driverMap = new HashMap<>();
        this.driverList = new ArrayList<>();
    }

    public void addDriver(Driver driver){
        driverList.add(driver);
        driverMap.put(driver.getDriverId(), driver);
    }

    public Driver getDriverByDriverId(int driverId){
        return driverMap.get(driverId);
    }

    public List<Driver> getDriverList() {
        return driverList;
    }

    public void setDriverList(List<Driver> driverList) {
        this.driverList = driverList;
    }

    public Map<Integer, Driver> getDriverMap() {
        return driverMap;
    }

    public void setDriverMap(Map<Integer, Driver> driverMap) {
        this.driverMap = driverMap;
    }
}
