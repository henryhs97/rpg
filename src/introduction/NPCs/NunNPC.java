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
	
    public void interact(Player player) {
    	if(player.getHealth()==100) {
    		System.out.println("You seem just fine. Why bother asking god for more?");
    	}
    	else if(player.getHealth()>70) {
    		System.out.println("Here sweety, have a band aid.");
    	}
    	else if(player.getHealth()>40) {
    		System.out.println("My goodness, you're going to need a lot of stitches for this! That should do it...");
    	}
    	else if(player.getHealth()>0) {
    		System.out.println("How are you still alive with that wound on your chest? Here, this should make it better.");
    	}
    	player.healPlayer();
    }
    	  
}