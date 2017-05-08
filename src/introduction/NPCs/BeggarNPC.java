/* Implementation of beggar NPC. Constructor to describe beggar, method for his dialogue,
 * and interaction implementation.
 */

package introduction.NPCs;
import introduction.OurInput;
import introduction.Player.Player;

import java.util.Random;
import java.util.Scanner;

public class BeggarNPC extends NPC {
	
    public BeggarNPC() {
    	super("poor beggar sleeping on a cardboard");
    }

	private String randomResponse() {
		String s = null;
		Random ran = new Random();
		int choice = ran.nextInt(3) + 1;
		
		switch(choice) {
		case 1:
			s= "Beggar: Thank you! Divines bless your heart";
			break;
		case 2:
			s= "Beggar: All you give me is this? Fine, I'll take it.";
			break;
		case 3:
			s= "Beggar: I will not forget this.";
			break;
		}
		return s;
	}

	@Override
	public void interact(Player player) {
		System.out.println("Beggar: Could you spare a few coins for a poor blind man?");
    	System.out.println("  How much gold to donate?:");
    	Scanner input = new Scanner(System.in);
        int howMuch;

		howMuch = OurInput.makeValidChoice(input,-1, Integer.MAX_VALUE);

		if(howMuch > player.getGold()){
			System.out.println("  You can't give money you don't have!");
			return;
		}
        player.removeGold(howMuch);
		System.out.println(this.randomResponse());
	}

}