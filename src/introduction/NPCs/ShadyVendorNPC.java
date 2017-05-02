/* A shady vendor is an NPC who is able to interact with the player.
 * The interaction is implemented by printing the vendor's inventory
 * and giving the player the ability to purchase these objects. 
 */
package introduction.NPCs;
import java.util.*;

public class ShadyVendorNPC extends NPC {

	List<Item> inventory = new ArrayList<>();
	
    public ShadyVendorNPC() {   	
    	super("shady vendor");
    	for(int i=0; i<3; i++) {
    		this.inventory.add(Consumable.createRandomConsumable());
    		this.inventory.add(Weapon.createRandomWeapon());
    	}
    }

	private String vendorDialogue() {
		String s = null;
		Random ran = new Random();
		int choice = ran.nextInt(3) + 1;
		
		switch(choice) {
		case 1:
			s= "Vendor: I don't have all day. What do you want?";
			break;
		case 2:
			s= "Vendor: Business is tough nowadays. This is all I've got for sale.";
			break;
		case 3:
			s= "Vendor: Perhaps we can negotiate a deal, what do you want to buy?";
			break;
		}
		return s;
	}
	

	
    public void interact(Player player) {
    	System.out.println(this.vendorDialogue() + "(-1 to buy nothing)");
    	this.showShopItems();
    	Scanner input = new Scanner(System.in);
        int choice;

		choice = Main.makeValidChoice(input, -1, this.inventory.size());

        if( choice == -1)
        	return;

		if( player.removeGold(this.inventory.get(choice).cost) ) {
			player.addItemToPlayerInventory(this.inventory.get(choice));
        	this.inventory.remove(choice);
        	System.out.println("  Vendor: Pleasure doing business with you.");
        } else {
        	System.out.println("  Vendor: Not enough money? No can do..");
        }
    }

	private void showShopItems() {	
		for(int i=0; i<inventory.size(); i++) {
			 System.out.println("  (" + i + ") " + this.inventory.get(i).description + "\t (gold: " + this.inventory.get(i).cost + ")");
		}
	}

	private static void invalidVendorChoice(int choice, int size) throws IllegalArgumentException{
		if(choice < -1 || choice >= size){
			throw new IllegalArgumentException("Invalid choice, exitting vendor.");
		}
	}
}