package introduction.Environment.Doors;/* A door is implemented with its description (color), and the index of the next
 * room it goes to, and an index to the room it is currently in. 
 */

import introduction.Inspectable;

public class Door extends Inspectable {

	private int nextRoom;
	private int previousRoom;
	
    public Door(String s, int next, int previous) {
        super(s);
        this.nextRoom = next;
        this.previousRoom = previous;
	}

	public int returnNextRoom(){
        return nextRoom;
    }

}