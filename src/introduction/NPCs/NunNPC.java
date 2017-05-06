/* The nun NPC provides a way for the user to be healed without gold.
 * A nun has a dialogue which corresponds to the amount of health points 
 * the player has left.
 */

package introduction.NPCs;

import introduction.NPCs.NPC;
import introduction.Player.Player;

public class NunNPC extends NPC {
	
    public NunNPC() {
    	super("nun");	
    }
	
	private String nunDialogue(int typeOfResponse) {
		String s = null;
		switch(typeOfResponse) {
		case 1:
			s= "You seem just fine. Why bother asking god for more?";
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
	
    public void interact(Player player) {
    	if(player.getHealth()==100) {
    		System.out.println(this.nunDialogue(1));
    	}
    	else if(player.getHealth()>70) {
    		System.out.println(this.nunDialogue(2));
    	}
    	else if(player.getHealth()>40) {
    		System.out.println(this.nunDialogue(3));
    	}
    	else if(player.getHealth()>0) {
    		System.out.println(this.nunDialogue(4));
    	}
    	player.healPlayer();
    }
    	  
}