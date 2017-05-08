/* A shady vendor is an NPC who is able to interact with the player.
 * The interaction is implemented by printing the vendor's inventory
 * and giving the player the ability to purchase these objects. 
 */
package introduction.NPCs;

import introduction.Interfaces.Shop;
import introduction.OurInput;
import introduction.Player.Consumable;
import introduction.Player.Item;
import introduction.Player.Weapon;
import introduction.Player.Player;

import java.util.*;

public class ShadyVendorNPC extends NPC implements Shop {

	private List<Item> inventory = new ArrayList<>();
	
    public ShadyVendorNPC() {
		super("shady vendor");
		for (int i = 0; i < 3; i++) {
			this.inventory.add(Consumable.createRandomConsumable());
			this.inventory.add(Weapon.createRandomWeapon());
		}
	}

	
    public void interact(Player player) {
		String s = null;
		Random ran = new Random();
		int choice = ran.nextInt(3) + 1;

		switch(choice) {
			case 1:
				s = "Vendor: I don't have all day. What do you want?";
				break;
			case 2:
				s = "Vendor: Business is tough nowadays. This is all I've got for sale.";
				break;
			case 3:
				s = "Vendor: Perhaps we can negotiate a deal, what do you want to buy?";
				break;
		}
    	System.out.println(s + "(-1 to buy nothing)");

    	player.shopAtVendor(this);
    }

	public int showShopItems() {
		for(int i=0; i<inventory.size(); i++) {
			 System.out.println("  (" + i + ") " + this.inventory.get(i).inspect() + "\t (gold: " + this.inventory.get(i).returnCost() + ")");
		}
		return this.inventory.size();
	}

	public Item buyItem(int itemChoice){
    	return this.inventory.remove(itemChoice);
	}

	public String inspectItem(int itemChoice){
		return this.inventory.get(itemChoice).inspect();
	}

	public int itemCost(int itemChoice){
		return this.inventory.get(itemChoice).returnCost();
	}
}