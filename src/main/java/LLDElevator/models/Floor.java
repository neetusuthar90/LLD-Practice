package LLDElevator.models;

import LLDElevator.Enum.FloorNumber;


public class Floor {
    private FloorNumber floorNumber;
    private OutsidePanel outsidePanel;

    public Floor(FloorNumber floorNumber, OutsidePanel outsidePanel) {
        this.floorNumber = floorNumber;
        this.outsidePanel = outsidePanel;
    }
    public FloorNumber getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(FloorNumber floorNumber) {
        this.floorNumber = floorNumber;
    }

    public OutsidePanel getOutsidePanel() {
        return outsidePanel;
    }

    public void setOutsidePanel(OutsidePanel outsidePanel) {
        this.outsidePanel = outsidePanel;
    }
}
