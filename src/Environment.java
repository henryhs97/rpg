import java.util.Random;

public class Environment{
	
	Random ran = new Random();
	int numberOfRooms = ran.nextInt(5) + 1;
	
	private Room[] rooms=new Room[numberOfRooms]; 
	
	public Environment() {
		for(int i=0; i<numberOfRooms ;i++) {
			rooms[i]=new Room(Color.returnRandomColor());
		}
	}
	
	public Room returnRoom(int roomNumber) {
		if(roomNumber<=numberOfRooms) {
			return rooms[roomNumber-1];
		} else {
			return rooms[roomNumber-1];
			//ADD CORRECT ELSE IMPLEMENTATION
		}
	}

}
