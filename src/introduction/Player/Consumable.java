/* Consumable class implements three alternative types: Heal (completely cure),
 * cure (increase health by points), make_swolle (increase player damage).
 * A consumable its effect and the points corresponding to its effect.
 * A createRandomConsumable method is made and returns a random consumable from a list
 * Interact is also implemented which lets the player experience the effect of the consumable
 */

import java.util.Random;

public class Consumable extends Item {

    public static final int HEAL = 0;
    public static final int CURE = 1;
    public static final int MAKE_SWOLLE = 2;

    int effect;
    int points;

    public Consumable (String description, int setEffect, int setCost) {
        super(description, 1, setCost);
        this.effect = setEffect;
        switch(effect) {
            case 0:
                this.points = 20;
                break;
            case 1:
                break;
            case 2:
                points = 10;
                break;
        }
    }
    
    public static Consumable createRandomConsumable() {
    	Random ran = new Random();
		int random = ran.nextInt(4);
		switch(random) {
		case 0: return new Consumable("Steroids", Consumable.MAKE_SWOLLE, 4);
		case 1: return new Consumable("Healing potion", Consumable.HEAL, 1);
		case 2: return new Consumable("Multivitamin", Consumable.CURE, 2);
		case 3: return new Consumable("Orange juice", Consumable.CURE, 1);
		case 4: return new Consumable("Protein bar", Consumable.CURE, 1);
		default: return new Consumable("Spoiled chips", Consumable.CURE, 1);
		}
    }

    public void interact(Player player) {
        switch(effect){
            case 0:
            	player.healPlayer();
            	System.out.println("You are now healed.");
                break;
            case 1:       	
                player.curePlayer(points);
                System.out.println("Your health has been increased.");
                break;
            case 2:
                player.increaseDamage(points);
                System.out.println("You notice your veins begin to pop. You feel ready to punch a wall!");
                break;
        }
    }
    
}
