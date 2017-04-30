import java.util.*;


public class Room extends Inspectable{

    public List<Door> doorList = new ArrayList<Door>();
    int numOfDoors;

    public Room(String s, int numberOfDoors) {
        super(s);    
        this.numOfDoors=numberOfDoors;
    }
    
    public void addDoorToRoom(String color, int next, int previous) {
    	this.doorList.add( new Door(Color.returnRandomColor(), next, previous));
    }
    
    public Door returnDoor(int number) {
    	return doorList.get(number);  	
    }

	public void roomDescription() {
		System.out.print("A " + description +" room with a ");
        for(int i = 0; i < numOfDoors - 1; i++) {
            System.out.print(doorList.get(i).inspect() + " door and a ");
        }
        System.out.println(doorList.get(numOfDoors - 1).inspect() + " door.");
	}

	public void doorDescription() {
        System.out.println("You look around for doors. You see:");
        for(int i = 0; i < doorList.size(); i++){
            System.out.println("  (" + i + ") A " + doorList.get(i).inspect() + " door");
        }
    }
	
	
}
