/* Implementation of beggar NPC. Constructor to describe beggar, method for his dialogue,
 * and interaction implementation.
 */

import java.util.Random;
import java.util.Scanner;

public class BeggarNPC extends NPC {
	
    public BeggarNPC() {
    	super("poor beggar sleeping on a cartboard");	
    }

	private String begarDialogue() {
		String s = null;
		Random ran = new Random();
		int choice = ran.nextInt(3) + 1;
		
		switch(choice) {
		case 1:
			s= "Begar: Thank you! Divines bless your heart";
			break;
		case 2:
			s= "Begar: All you give me is this? Fine, I'll take it.";
			break;
		case 3:
			s= "Begar: I will not forget this.";
			break;
		}
		return s;
	}

	@Override
	public void interact(Player player) {
		System.out.println("Begar: Could you spare a few coins for a poor blind man?");
    	System.out.println("  How much gold to donate?:");
    	Scanner input = new Scanner(System.in);
        int howMuch = input.nextInt();
        if(player.removeGold(howMuch)) {
        	System.out.println(this.begarDialogue());
        } else{
        	System.out.println("  You can't give money you don't have!");	
        }
	}



}