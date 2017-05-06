package introduction.Environment.Doors;/* A door is implemented with its description (color), and the index of the next
 * room it goes to, and an index to the room it is currently in. 
 */

import introduction.Environment.TypeOfDoor;
import introduction.Inspectable;


public abstract class Door extends Inspectable {

    int nextRoom;
    TypeOfDoor type;
	
    public Door(String s, int next, TypeOfDoor setType) {
        super(s);
        this.nextRoom = next;
        this.type = setType;
	}

	public int returnNextRoom(){
        return nextRoom;
    }

    public TypeOfDoor returnType(){
	    return type;
    }

}