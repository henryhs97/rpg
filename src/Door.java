public class Door extends Inspectable{

	protected int nextRoom, currentRoom;
	
    public Door(String s, int next, int current) {
        super(s);
        this.nextRoom = next;
        this.currentRoom = current;
	}
    

}