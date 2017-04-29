import java.util.*;


public class Room extends Inspectable{



    private List<Door> doorList = new ArrayList<Door>();

    private int numOfDoors;

    public Room(String s){
        super(s);
        Random rand = new Random();
        numOfDoors = rand.nextInt(5) + 1;
        for(int i = 0; i < numOfDoors; i++) {
            doorList.add(new Door(Color.returnRandomColor()));
        }
    }

	public void roomDescription() {
		System.out.print("a " + color +" room with a ");
        for(int i = 0; i < numOfDoors - 1; i++) {
            System.out.print(doorList.get(i).returnColor() + " door and a ");
        }
        System.out.print(doorList.get(numOfDoors - 1).returnColor() + " door.");
	}

	public void doorDescription() {
        System.out.println("You look around for doors. You see:");
        for(int i = 0; i < doorList.size(); i++){
            System.out.println("  (" + i + ") A " + doorList.get(i).returnColor() + " door");
        }
    }
	
	
}
