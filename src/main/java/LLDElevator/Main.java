package LLDElevator;

import LLDElevator.Enum.Direction;
import LLDElevator.Enum.DoorAction;
import LLDElevator.Enum.ElevatorNumber;
import LLDElevator.Enum.FloorNumber;
import LLDElevator.models.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        ElevatorSystem elevatorSystem = ElevatorSystem.getInstance();

        List<Elevator> elevators = new ArrayList<>();
        for (ElevatorNumber elevatorNumber : ElevatorNumber.values()) {
            Elevator elevator = new Elevator(
                    elevatorNumber,
                    new Door(DoorAction.CLOSE),
                    new InsidePanel(),
                    new Display(FloorNumber.FLOOR_NUMBER1, Direction.IDLE),
                    FloorNumber.FLOOR_NUMBER1,
                    Direction.IDLE
            );
            elevators.add(elevator);
        }
        elevatorSystem.setElevators(elevators);

        Floor floor1 = new Floor(FloorNumber.FLOOR_NUMBER1, new OutsidePanel());
        Floor floor5 = new Floor(FloorNumber.FLOOR_NUMBER5, new OutsidePanel());
        elevatorSystem.setFloors(List.of(floor1, floor5));

        System.out.println("Requesting an elevator to go UP from floor 1...");
        Elevator requestedElevator = elevatorSystem.requestElevator(Direction.UP, floor1);

        if (requestedElevator != null) {
            System.out.println("Elevator " + requestedElevator.getElevatorNumber() + " is dispatched.");

            // Open the elevator door
            elevatorSystem.openDoor(requestedElevator);
            System.out.println("Elevator door is now OPEN.");

            // Select the destination floor (e.g., Floor 5)
            elevatorSystem.selectFloor(FloorNumber.FLOOR_NUMBER5, requestedElevator);
            System.out.println("Floor 5 selected.");

            // Close the door and move the elevator
            elevatorSystem.closeDoor(requestedElevator);
            System.out.println("Elevator door is now CLOSED.");

            // Simulate elevator reaching the destination
            requestedElevator.setCurrentFloorNumber(FloorNumber.FLOOR_NUMBER5);
            requestedElevator.setCurrentDirection(Direction.IDLE);
            System.out.println("Elevator has reached Floor 5.");
        } else {
            System.out.println("No available elevator at the moment.");
        }
    }
}
