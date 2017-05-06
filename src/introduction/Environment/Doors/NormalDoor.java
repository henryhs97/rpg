package introduction.Environment.Doors;

import introduction.Environment.TypeOfDoor;

/**
 * Created by sibdoo on 06/05/2017.
 */
public class NormalDoor extends Door {

    public NormalDoor (String description, int next){
        super(description,next, TypeOfDoor.NORMAL);
    }
}
