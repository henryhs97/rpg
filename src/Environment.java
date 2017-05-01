public class Environment{
	int numberOfRooms = 6;
	
	private Room[] rooms=new Room[numberOfRooms];

	public Environment() {
		rooms[0]=new Room(Color.returnRandomColor(), 2);  //a random 
		rooms[0].addDoorToRoom( Color.returnRandomColor(), 1, 0);
		rooms[0].addDoorToRoom( Color.returnRandomColor(), 3, 0);
		rooms[0].addEnemyToRoom("shady man",40, 15);
		rooms[0].addVendorToRoom();
		rooms[0].addNurseToRoom();
		rooms[0].addBegarToRoom();
		
		rooms[1]=new Room(Color.returnRandomColor(), 3);  //a random 
		rooms[1].addDoorToRoom( Color.returnRandomColor(), 2, 1);
		rooms[1].addDoorToRoom( rooms[1].returnDoor(0).inspect(), 0, 1);
		rooms[1].addDoorToRoom( Color.returnRandomColor(), 3, 1);
			
		rooms[2]=new Room(Color.returnRandomColor(), 2);  //a random 
		rooms[2].addDoorToRoom( Color.returnRandomColor(), 4, 2);
		rooms[2].addDoorToRoom( rooms[1].returnDoor(0).inspect(), 1, 2);
		
		rooms[3]=new Room(Color.returnRandomColor(), 2);  //a random 
		rooms[3].addDoorToRoom( rooms[1].returnDoor(2).inspect(), 1, 3);
		rooms[3].addDoorToRoom( Color.returnRandomColor(), 4, 3);
		
		rooms[4]=new Room(Color.returnRandomColor(), 3);  //a random 
		rooms[4].addDoorToRoom( Color.returnRandomColor(), 5, 4);
		rooms[4].addDoorToRoom( rooms[2].returnDoor(0).inspect(), 2, 4);
		rooms[4].addDoorToRoom( rooms[3].returnDoor(1).inspect(), 3, 4);
		
		rooms[5]=new Room(Color.returnRandomColor(), 1);  //a random 
		rooms[5].addDoorToRoom( rooms[4].returnDoor(0).inspect(), 4, 5);			
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
