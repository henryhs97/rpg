/* A weapon is an item which interacts with the player by equipping it.
 * A method is also added in order to simply create a random weapon with random
 * variables. As a weapon is an item, there are limited number of uses, and each time
 * a weapon is used, its lifespan decreases. 
 */

import java.util.Random;

public class Weapon extends Item{

    private int damage;

    public Weapon(String description, int setDamage, int setUses, int setCost) {
        super(description, setUses, setCost);
        this.damage = setDamage;
    }

    @Override
    public void interact(Player player) {
        System.out.println("Equipped: " + inspect());
        player.equipWeapon(this);
    }
    
    public static Weapon createRandomWeapon() {
    	Random ran = new Random();
		int random = ran.nextInt(4);
		switch(random) {
		case 0: return new Weapon("Rusty pickaxe", 10, 5, 2);
		case 1: return new Weapon("Rusty hammer", 25, 5, 5);
		case 2: return new Weapon("Swiss army knife", 5, 10, 3);
		case 3: return new Weapon("Shovel", 8, 15, 3);
		case 4: return new Weapon("Butcher's knife", 40, 2, 4);
		default: return new Weapon("Toothpick", 1, 1, 1);
		}
    }

    public boolean use() {
        this.uses--;
        if(this.uses == 0){
            return false;
        }
        return true;
    }

    public int checkCondition() {
        return uses;
    }

    public int getDamage() {
        return damage;
    }

}
