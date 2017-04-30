import java.util.*;


public class Room extends Inspectable{

    public List<Door> doorList = new ArrayList<Door>();
    public List<NPC> NPCList = new ArrayList<NPC>();

    int numOfDoors;

    public Room(String s, int numberOfDoors) {
        super(s);    
        this.numOfDoors=numberOfDoors;
    }
    
    public void addDoorToRoom(String color, int next, int previous) {
    	this.doorList.add( new Door(Color.returnRandomColor(), next, previous));
    }

    public void addEnemyToRoom(String description, int health, int damage){
        this.NPCList.add(new Enemy(description, health, damage));
    }
    
    public void addVendorToRoom(){
        this.NPCList.add(new ShadyVendorNPC());
    }
    
    public void addNurseToRoom(){
        this.NPCList.add(new NurseNPC());
    }
    
    public void addBegarToRoom(){
        this.NPCList.add(new BegarNPC());
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
        System.out.print("There's also a: ");
        for(int i = 0; i < NPCList.size() - 1; i++) {
            System.out.print(NPCList.get(i).inspect() + " and a ");
        }
        System.out.println(NPCList.get(NPCList.size()-1).inspect());

    }

	public void doorDescription() {
        System.out.println("You look around for doors. You see:");
        for(int i = 0; i < doorList.size(); i++){
            System.out.println("  (" + i + ") A " + doorList.get(i).inspect() + " door");
        }
    }

    public void NPCDescription() {
        System.out.println("You look around for people. You see:");
        for(int i = 0; i < NPCList.size(); i++){
            System.out.println("  (" + i + ")" + NPCList.get(i).inspect());
        }
    }
	
	
}
