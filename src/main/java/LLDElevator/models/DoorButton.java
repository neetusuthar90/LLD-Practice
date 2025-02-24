package LLDElevator.models;

import LLDElevator.Enum.DoorAction;
import LLDElevator.Interfaces.Button;


public class DoorButton implements Button {
    public boolean status;
    private DoorAction doorAction;

    public DoorButton(){}

    public DoorButton(boolean status, DoorAction doorAction){
        this.status = status;
        this.doorAction = doorAction;
    }

    public DoorAction getDoorAction() {
        return doorAction;
    }

    public void setDoorAction(DoorAction doorAction) {
        this.doorAction = doorAction;
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
