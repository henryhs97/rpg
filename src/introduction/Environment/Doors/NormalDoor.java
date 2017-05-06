package introduction.Environment.Doors;

import introduction.Environment.TypeOfDoor;

public class NormalDoor extends Door {

    public NormalDoor (String description, int next){
        super(description,next, TypeOfDoor.NORMAL);
    }
}
