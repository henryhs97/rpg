package introduction.Environment.Doors;/* A door is implemented with its description (color), and the index of the next
 * room it goes to, and an index to the room it is currently in. 
 */

import introduction.Environment.TypeOfDoor;
import introduction.Inspectable;
import introduction.Interfaces.Interactable;
import introduction.Player.Player;


public abstract class Door extends Inspectable implements Interactable {

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

    abstract public void interact(Player player);

    public TypeOfDoor returnType(){
	    return type;
    }

}