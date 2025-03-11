package CabBooking.Managers;

import CabBooking.Entity.Rider;

import java.util.HashMap;
import java.util.Map;

public class RiderManager {
    private Map<Integer, Rider> riderMap;

    public RiderManager() {
        this.riderMap = new HashMap<>();
    }

    public void addRider(Rider rider){
        riderMap.put(rider.getRiderId(), rider);
    }

    public Rider getRiderById(int riderId){
        return riderMap.get(riderId);
    }
}
