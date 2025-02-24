package LLDElevator.models;

import LLDElevator.Enum.DoorAction;

public class Door {
    DoorAction doorAction;

    public Door(DoorAction doorAction){
        this.doorAction = doorAction;
    }
    public Door() {}

    public void openDoor(){
        doorAction = DoorAction.OPEN;
    }

    public void closeDoor(){
        doorAction = DoorAction.CLOSE;
    }
}
