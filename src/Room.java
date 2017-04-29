import java.lang.reflect.Array;
import java.util.*;
import java.util.Collection;

public class Room extends Inspectable{



    private List<Doors> doorList = new ArrayList<Doors>();

    private Doors door1= new Doors(Color.returnRandomColor());
	private Doors door2= new Doors(Color.returnRandomColor());

    public Room(String s){
        super(s);
        doorList.add(door1);
        doorList.add(door2);
    }

	public void roomDescription() {
		System.out.print("a " + color +" room with a " + doorList.get(doorList.indexOf(door1)).returnColor() + " door and a " +door2.returnColor() + " door." );
	}

	public void doorDescription() {
        System.out.println("You look around for doors. You see:");
        for(int i = 0; i < doorList.size(); i++){
            System.out.println("  (" + i + ") A " + doorList.get(i).returnColor() + " door");
        }
    }
	
	
}
