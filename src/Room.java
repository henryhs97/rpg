import java.util.*;


public class Room extends Inspectable{

    private List<Door> doorList = new ArrayList<Door>();
    int numOfDoors;

    public Room(String s, int current, int numberOfRooms) {
        super(s);
        Random rand = new Random();
        numOfDoors = rand.nextInt(3) + 1;       
        
        for(int i = 0; i < numOfDoors; i++) { //0 is reserved for previous one
            doorList.add(new Door(Color.returnRandomColor(), rand.nextInt(numberOfRooms)+1, current ) );
        }
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
