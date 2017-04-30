import java.util.Random;

public class Environment{
	
	Random ran = new Random();
	int numberOfRooms = ran.nextInt(10) + 3;
	
	private Room[] rooms=new Room[numberOfRooms]; 
	
	public Environment() {
		for(int i=0; i<numberOfRooms ;i++) {
			rooms[i]=new Room(Color.returnRandomColor(), i, numberOfRooms);  //a random 
		}
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
