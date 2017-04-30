import java.util.Random;
import java.util.Scanner;

public class BegarNPC extends NPC{
	
    public BegarNPC() {
    	super("A poor begar sleeping on a cartboard");	
    }

	private String begarDialogue() {
		String s = null;
		Random ran = new Random();
		int choice = ran.nextInt(3) + 1;
		
		switch(choice) {
		case 1:
			s= "Thank you! Divines bless your heart";
			break;
		case 2:
			s= "All you give me is this? Fine, I'll take it.";
			break;
		case 3:
			s= "I will not forget this.";
			break;
		}
		return s;
	}

	@Override
	public void interact(Player player) {
    	System.out.println("How much gold to donate?:");
    	Scanner input = new Scanner(System.in);
        int howMuch = input.nextInt();
        if(player.getGold()<howMuch) {
        	System.out.println("You can't give me more than you have.");
        } else{
        	player.removeGold(howMuch);	
        }
	}



}