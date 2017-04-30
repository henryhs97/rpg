import java.util.Random;

public class ShadyVendorNPC extends NPC implements Shop{
	
    public ShadyVendorNPC() {
    	super(chooseTypeOfVendor() );	
    }

	private static String chooseTypeOfVendor() {
		String s = null;
		Random ran = new Random();
		int choice = ran.nextInt(3) + 1;
		
		switch(choice) {
		case 1:
			s= "I don't have all day. What do you want?";
			break;
		case 2:
			s= "Business is tough nowadays. This is all I've got for sale.";
			break;
		case 3:
			s= "Perhaps we can negotiate a deal, what do you want to buy?";
			break;
		}
		return s;
	}

	public void showShopItems() {
		System.out.println("  (0) Health Potion");
		System.out.println("  (1) Kitchen knife (1 use)");
		System.out.println("  (2) Knight Sword (4 uses)");
		System.out.println("  (3) Refined Knight Sword (5 uses)");
		System.out.println("  (4) Refined Knight Sword (6 uses)");
	}

	public static void putInInventory(int itemChoice) {
		String s = null;
		Random ran = new Random();
		int choice = ran.nextInt(3) + 1;
		
		switch(itemChoice) {
		case 1:
			s= "I don't have all day. What do you want?";
			break;
		case 2:
			s= "Business is tough nowadays. This is all I've got for sale.";
			break;
		case 3:
			s= "Perhaps we can negotiate a deal, what do you want to buy?";
			break;
		}
		return s;
	}
	


}