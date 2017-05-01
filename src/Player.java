/* The player class implements CanFight, and has several traits such as
 * health points, status (healthy, poisoned), damage points, and gold.
 * A player may also equip a weapon and has an inventory implemented as a list.
 * This class involves methods that allow the player to check inventory, add
 * items to the inventory, check stats, and a bunch of helper functions.
 */

import java.util.*;

public class Player implements CanFight{

    public static final int HEALTHY = 0;
    public static final int POISONED = 1;
    private int health;
    private int status;
    private int damage;
    private int gold;
    private int itemChoice;
    private Weapon equippedWeapon = null;

    List<Item> inventory = new ArrayList<>();

    public Player(int setHealth, int setDamage, int setGold){
        this.health = setHealth;
        this.damage = setDamage;
        this.gold = setGold;
        this.status = HEALTHY;
        this.itemChoice = -1;
    }

	public int enterDoor(Door door) {
		System.out.println("You enter the room.");
		return door.nextRoom;
	}
	
	public void checkInventory(Scanner input){
	    System.out.println("Your inventory: (-1 to use nothing)");
	    for(int i = 0; i < inventory.size(); i++) {
            System.out.println("  (" + i + ") " + inventory.get(i).inspect());
        }
        this.itemChoice = input.nextInt();
        if(itemChoice == -1){
        	return;
        }
        if(inventory.get(itemChoice) instanceof Weapon) {
            if (this.itemChoice != -1) {
                if (equippedWeapon == null) {
                    inventory.get(this.itemChoice).interact(this);
                    inventory.remove(this.itemChoice);
                } else {
                    decreaseDamage(equippedWeapon.getDamage());
                    inventory.add(equippedWeapon);
                    inventory.get(this.itemChoice).interact(this);
                    inventory.remove(itemChoice);
                }
            }
        }else{
	        inventory.get(itemChoice).interact(this);
	        inventory.remove(itemChoice);
        }

    }
	
	public void addItemToPlayerInventory(Item item) {
		this.inventory.add(item);
		System.out.println(item.description + " has been put in your inventory.");
	}

    public void checkStats(){
    	System.out.println("Your stats:");
	    System.out.println("Health: " + health);
	    System.out.print("Status: ");
	    if(this.status==0) {
	    	System.out.println("Healthy");
	    } else if (this.status==1){
	    	System.out.println("Poisoned");
	    }
	    System.out.println("Gold: " + gold);
	    System.out.println("Attack points: " + damage);
	    if(equippedWeapon != null) {
            System.out.println("Weapon: " + equippedWeapon.inspect());
            System.out.println("Number of uses left: " + equippedWeapon.checkCondition());
        }else{
	        System.out.println("No weapon");
        }
    }
    
    public int getHealth(){
	    return health;
    }
    
    public int getGold(){
	    return gold;
    }
    
    public void addGold(int howMuch) {
    		this.gold += howMuch;
    }
    
    public boolean removeGold(int howMuch) {
    	if(this.gold>=howMuch) {
    		this.gold -= howMuch;
    		return true;
    	} else {
    		return false;
    	}
    }

    public int getDamage(){
        return damage;
    }

    public int getStatus(){
	    return this.status;
    }

    public void poisonDamage(){
	    this.health -= 5;
    }
    
    public void curePlayer(int points) {
    	this.health += points;
    	if(this.health>100) {
    		this.health=100;
        	this.changeStatus(HEALTHY);
    	}
    }
    
    public void healPlayer(){
	    this.health = 100;
	    this.changeStatus(HEALTHY);
    }

    public void receiveDamage(int atk){
        this.health -= atk;
        if(this.health < 0){
            this.health = 0;
        }
    }

    public int dealDamage(){
        if(equippedWeapon != null && !this.equippedWeapon.use()){
            decreaseDamage(equippedWeapon.getDamage());
            this.inventory.remove(this.equippedWeapon);
            this.equippedWeapon = null;
        }
        return this.damage;
    }

    public void equipWeapon(Weapon choosenWeapon){
        this.equippedWeapon = choosenWeapon;
        increaseDamage(equippedWeapon.getDamage());
    }

    public void increaseDamage(int moreDamage){
        this.damage += moreDamage;
    }

    public void decreaseDamage(int lessDamage){
        this.damage -= lessDamage;
    }

    public void changeStatus(int newStatus){
        this.status = newStatus;
    }
}
