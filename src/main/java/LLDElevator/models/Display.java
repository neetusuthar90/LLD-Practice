package LLDElevator.models;

import LLDElevator.Enum.Direction;
import LLDElevator.Enum.FloorNumber;

public class Display {
    private FloorNumber floorNumber;
    private Direction direction;

    public Display(FloorNumber floorNumber, Direction direction){
        this.floorNumber = floorNumber;
        this.direction = direction;
    }

    public Display() {}

    public FloorNumber getFloorNumber(){
        return floorNumber;
    }

    public void setFloorNumber(FloorNumber floorNumber){
        this.floorNumber = floorNumber;
    }

    public Direction getDirection(){
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
