package LLDElevator.models;

import LLDElevator.Enum.Direction;
import LLDElevator.Enum.DoorAction;
import LLDElevator.Enum.FloorNumber;
import LLDElevator.Interfaces.Panel;

import java.util.ArrayList;
import java.util.List;

public class InsidePanel implements Panel {
    private List<ElevatorButton> elevatorButtonList;
    private List<DoorButton> doorButtons;

    public InsidePanel(){
        elevatorButtonList = new ArrayList<>();
        doorButtons = new ArrayList<>();
        for (int i = 0; i <15 ; i++) {
            elevatorButtonList.add(new ElevatorButton(false, FloorNumber.values()[i]));
        }
        for(int i = 0; i < 2; i++){
            doorButtons.add(new DoorButton(false, DoorAction.values()[i]));
        }
    }

    public boolean pressFloorButton(int floorNumber){
        return elevatorButtonList.get(floorNumber).press();
    }
    public boolean pressDoorButton(int doorNumber){
        return doorButtons.get(doorNumber).press();
    }
}
