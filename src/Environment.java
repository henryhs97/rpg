/* The implementation of our environment is done here. It is an environment
 * composed of 6 rooms, each of which contain NPCs. 
 * A method returnRoom was also implemented that simply returns a desired room.
 */

public class Environment{
	int numberOfRooms = 6;
	
	private Room[] rooms=new Room[numberOfRooms];

	public Environment() {
		rooms[0]=new Room(Color.returnRandomColor(), 2);  //a random 
		rooms[0].addDoorToRoom( Color.returnRandomColor(), 1, 0);
		rooms[0].addDoorToRoom( Color.returnRandomColor(), 3, 0);
		rooms[0].addVendorToRoom();
		rooms[0].addNunToRoom();
		
		rooms[1]=new Room(Color.returnRandomColor(), 3);  //a random 
		rooms[1].addDoorToRoom( Color.returnRandomColor(), 2, 1);
		rooms[1].addDoorToRoom( rooms[1].returnDoor(0).inspect(), 0, 1);
		rooms[1].addDoorToRoom( Color.returnRandomColor(), 3, 1);
		rooms[1].addEnemyToRoom();
		rooms[1].addEnemyToRoom();
		rooms[1].addBegarToRoom();
			
		rooms[2]=new Room(Color.returnRandomColor(), 2);  //a random 
		rooms[2].addDoorToRoom( Color.returnRandomColor(), 4, 2);
		rooms[2].addDoorToRoom( rooms[1].returnDoor(0).inspect(), 1, 2);
		rooms[2].addNunToRoom();
		rooms[2].addEnemyToRoom();
		
		rooms[3]=new Room(Color.returnRandomColor(), 2);  //a random 
		rooms[3].addDoorToRoom( rooms[1].returnDoor(2).inspect(), 1, 3);
		rooms[3].addDoorToRoom( Color.returnRandomColor(), 4, 3);
		rooms[3].addVendorToRoom();
		
		rooms[4]=new Room(Color.returnRandomColor(), 3);  //a random 
		rooms[4].addDoorToRoom( Color.returnRandomColor(), 5, 4);
		rooms[4].addDoorToRoom( rooms[2].returnDoor(0).inspect(), 2, 4);
		rooms[4].addDoorToRoom( rooms[3].returnDoor(1).inspect(), 3, 4);
		rooms[4].addVendorToRoom();
		rooms[4].addEnemyToRoom();
		
		rooms[5]=new Room(Color.returnRandomColor(), 1);  //a random 
		rooms[5].addDoorToRoom( rooms[4].returnDoor(0).inspect(), 4, 5);	
		rooms[5].addEnemyToRoom();
		rooms[5].addNunToRoom();
		rooms[5].addBegarToRoom();
	}
	
	public Room returnRoom(int roomNumber) {
		if(roomNumber<numberOfRooms) {
			return rooms[roomNumber];
		} else {
			return rooms[roomNumber];
			//ADD CORRECT ELSE IMPLEMENTATION
		}
	}

}
