import java.util.Random;

public class NurseNPC extends NPC{
	
    public NurseNPC() {
    	super(chooseTypeOfNurse() );	
    }
	
	private static String chooseTypeOfNurse() {
		String s = null;
		Random ran = new Random();
		int choice = ran.nextInt(4) + 1;
		
		switch(choice) {
		case 1:
			s= "I can't do anymore for you without plastic surgery.";
			break;
		case 2:
			s= "Here sweety, have a band aid.";
			break;
		case 3:
			s= "My goodness, you're going to need a lot of stitches for this! That should do it...";
			break;
		case 4:
			s= "How are you still alive with that wound on your chest? Here, this should make it better.";
		}
		return s;
	}



}