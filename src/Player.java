import java.util.*;

public class Player {

    public static final int HEALTHY = 0;
    public static final int POISONED = 1;
    private int health;
    private int status;
    private int damage;
    private int itemChoice;
    private Weapon equipedWeapon = null;

    List<Item> inventory = new ArrayList<>();

    public Player(int setHealth, int setDamage){
        this.health = setHealth;
        this.damage = setDamage;
        this.status = HEALTHY;
        this.itemChoice = -1;
    }

	public int enterDoor(Door door) {
		return door.nextRoom;
	}
	
	public void checkInventory(Scanner input){
	    System.out.println("Your inventory: (-1 to use nothing)");
	    for(int i = 0; i < inventory.size(); i++) {
            System.out.println("  (" + i + ") " + inventory.get(i).inspect());
        }
        this.itemChoice = input.nextInt();
        if(this.itemChoice != -1){
            inventory.get(this.itemChoice).interact(this);
        }

    }

    public int getHealth(){
	    return health;
    }

    public int getStatus(){
	    return this.status;
    }

    public void poisonDamage(){
	    this.health -= 5;
    }

    public void receiveDamage(int atk){
        this.health -= atk;
    }

    public int dealDamage(){
        if(equipedWeapon != null && !this.equipedWeapon.use()){
            weaponBroke(equipedWeapon.getDamage());
            this.inventory.remove(this.equipedWeapon);
            this.equipedWeapon = null;
        }
        return this.damage;
    }

    public void equipWeapon(Weapon choosenWeapon){
        this.equipedWeapon = choosenWeapon;
        this.damage += choosenWeapon.getDamage();
    }

    public void weaponBroke(int weaponDamage){
        this.damage -= weaponDamage;

    }
}
