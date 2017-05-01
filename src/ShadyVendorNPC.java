import java.util.Random;
import java.util.Scanner;

public class ShadyVendorNPC extends NPC {
	
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
    	System.out.println(this.vendorDialogue());
    	this.showShopItems();
    	Scanner input = new Scanner(System.in);
        int choice = input.nextInt();
        player.addItemToPlayerInventory(this.inventory.get(choice));
        this.inventory.remove(choice);    
    }

	private void showShopItems() {	
		for(int i=0; i<inventory.size(); i++) {
			 System.out.println("  (" + i + ") " + this.inventory.get(i).description);
		}
	}




}