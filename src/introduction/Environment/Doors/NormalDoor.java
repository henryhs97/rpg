package introduction.Environment.Doors;

import introduction.Environment.TypeOfDoor;
import introduction.Player.Player;

public class NormalDoor extends Door {

    public NormalDoor (String description, int next){
        super(description,next, TypeOfDoor.NORMAL);
    }

    public void interact(Player player){
        //Normal door. Doesn't do anything.
        System.out.println("You enter the next room.");
        return;
    }
}
