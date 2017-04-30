import java.util.*;


public class Room extends Inspectable{

    private List<Door> doorList = new ArrayList<Door>();
    int numOfDoors;
    	
	Random ran = new Random();
	int random = ran.nextInt(3); //at most 3 doors per room
    

    public Room(String s, int current, int numberOfRooms) {
        super(s);
        Random rand = new Random();
        numOfDoors = rand.nextInt(5) + 1;       
        
        for(int i = 0; i < numOfDoors; i++) { //0 is reserved for previous one
            doorList.add(new Door(Color.returnRandomColor(), rand.nextInt(numberOfRooms)+1, current ) );
        }
    }
    
    public Door returnDoor(int number) {
    	return doorList.get(number);  	
    }

	public void roomDescription() {
		System.out.print("A " + color +" room with a ");
        for(int i = 0; i < numOfDoors - 1; i++) {
            System.out.print(doorList.get(i).returnColor() + " door and a ");
        }
        System.out.println(doorList.get(numOfDoors - 1).returnColor() + " door.");
	}

	public void doorDescription() {
        System.out.println("You look around for doors. You see:");
        for(int i = 0; i < doorList.size(); i++){
            System.out.println("  (" + i + ") A " + doorList.get(i).returnColor() + " door");
        }
    }
	
	
}
