import java.util.Random;

public class randomNPC extends NPC{
	
    public randomNPC() {
    	super(chooseRandomNPC() );	
    }

	private static String chooseRandomNPC() {
		String s = null;
		Random ran = new Random();
		int choice = ran.nextInt(3) + 1;
		
		switch(choice) {
		case 1:
			s= "I see you're new here. I reckon you won't stay too long?";
			break;
		case 2:
			s= "Am I supposed to be scared now?";
			break;
		case 3:
			s= "Am I under arrest, or not?";
			break;
		}
		return s;
	}



}
