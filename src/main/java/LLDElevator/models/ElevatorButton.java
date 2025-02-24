package LLDElevator.models;

import LLDElevator.Enum.FloorNumber;
import LLDElevator.Interfaces.Button;

public class ElevatorButton implements Button {
    private boolean status;
    FloorNumber floorNumber;

    public ElevatorButton(boolean status, FloorNumber floorNumber) {
        this.status = status;
        this.floorNumber = floorNumber;
    }
    public ElevatorButton() {
    }

    public FloorNumber getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(FloorNumber floorNumber) {
        this.floorNumber = floorNumber;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public boolean isPressed(){
        return status;
    }

    @Override
    public boolean press(){
        status = !status;
        return status;
    }
}
