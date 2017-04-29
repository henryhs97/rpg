
public class Room{
	private String color;
	
	public Room(String s){
		this.color=s;
	}
	
	private Doors door1= new Doors(Color.returnRandomColor());
	private Doors door2= new Doors(Color.returnRandomColor());
	
	public void roomDescription() {
		System.out.print("a " + color +" room with a " + door1.returnColor() + " door and a " +door2.returnColor() + " door." );
		
	}
	
	
	
}
