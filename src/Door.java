public class Door extends Inspectable{

	int nextRoom, previousRoom;
	
    public Door(String s, int next, int previous) {
        super(s);
        this.nextRoom = next;
        this.previousRoom=previous;
	}
    

}