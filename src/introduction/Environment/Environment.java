/* The implementation of our environment is done here. It is an environment
 * composed of 6 rooms, each of which contain NPCs. 
 * A method returnRoom was also implemented that simply returns a desired room.
 */
package introduction.Environment;

import java.util.ArrayList;

import java.util.List;

public class Environment implements java.io.Serializable{
	private static final long serialVersionUID = 42L ;

	private int numberOfRooms = 6;

	private List<Room> rooms = new ArrayList<>();

	public Environment() {

		rooms.add(new Room(Color.returnRandomColor()) );
		rooms.get(0).addDoorToRoom( Color.returnRandomColor(), 1, TypeOfDoor.NORMAL);
		rooms.get(0).addDoorToRoom( Color.returnRandomColor(), 3, TypeOfDoor.SPIKY);
		rooms.get(0).addVendorToRoom();
		rooms.get(0).addNunToRoom();

		rooms.add(new Room(Color.returnRandomColor()) );
		rooms.get(1).addDoorToRoom( Color.returnRandomColor(), 2, TypeOfDoor.NORMAL);
		rooms.get(1).addDoorToRoom( rooms.get(0).returnDoor(0).inspect(), 0, TypeOfDoor.NORMAL);
		rooms.get(1).addDoorToRoom( Color.returnRandomColor(), 3, TypeOfDoor.RIDDLE);
		rooms.get(1).addEnemyToRoom();
		rooms.get(1).addEnemyToRoom();
		rooms.get(1).addBegarToRoom();

		rooms.add(new Room(Color.returnRandomColor()) );
		rooms.get(2).addDoorToRoom( Color.returnRandomColor(), 4, TypeOfDoor.NORMAL);
		rooms.get(2).addDoorToRoom( rooms.get(1).returnDoor(0).inspect(), 1, TypeOfDoor.NORMAL);
		rooms.get(2).addNunToRoom();
		rooms.get(2).addEnemyToRoom();

		rooms.add(new Room(Color.returnRandomColor()) ); //a random
		rooms.get(3).addDoorToRoom( rooms.get(0).returnDoor(1).inspect(), 0, TypeOfDoor.SPIKY);
		rooms.get(3).addDoorToRoom( rooms.get(1).returnDoor(2).inspect(), 1, TypeOfDoor.RIDDLE);
		rooms.get(3).addDoorToRoom( Color.returnRandomColor(), 4, TypeOfDoor.NORMAL);
		rooms.get(3).addVendorToRoom();

		rooms.add(new Room(Color.returnRandomColor()) ); //a random
		rooms.get(4).addDoorToRoom( Color.returnRandomColor(), 5, TypeOfDoor.NORMAL);
		rooms.get(4).addDoorToRoom( rooms.get(2).returnDoor(0).inspect(), 2, TypeOfDoor.NORMAL);
		rooms.get(4).addDoorToRoom( rooms.get(3).returnDoor(1).inspect(), 3, TypeOfDoor.NORMAL);
		rooms.get(4).addVendorToRoom();
		rooms.get(4).addEnemyToRoom();

		rooms.add(new Room(Color.returnRandomColor()) );  //a random
		rooms.get(5).addDoorToRoom( rooms.get(4).returnDoor(0).inspect(), 4, TypeOfDoor.NORMAL);
		rooms.get(5).addEnemyToRoom();
		rooms.get(5).addNunToRoom();
		rooms.get(3).addBegarToRoom();
	}

	public Room returnRoom(int roomNumber) {
		if(roomNumber<numberOfRooms) {
			return rooms.get(roomNumber);
		} else {
			return rooms.get(roomNumber);
			//ADD CORRECT ELSE IMPLEMENTATION
		}
	}

}