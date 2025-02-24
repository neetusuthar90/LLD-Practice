package LLDElevator.models;

import LLDElevator.Enum.Direction;
import LLDElevator.Interfaces.Panel;

import java.util.ArrayList;
import java.util.List;

public class OutsidePanel implements Panel {
    private List<HallButton> hallButtons;

    public OutsidePanel(){
        hallButtons = new ArrayList<>();
        hallButtons.add(new HallButton(false, Direction.UP));
        hallButtons.add(new HallButton(false, Direction.DOWN));
        hallButtons.add(new HallButton(false, Direction.IDLE));
    }

    public void MoveUp(){

    }
    public void MoveDown(){

    }
}
