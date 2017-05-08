package introduction.Player;/* introduction.Player.Consumable class implements three alternative types: Heal (completely cure),
 * cure (increase health by points), make_swolle (increase player damage).
 * A consumable its effect and the points corresponding to its effect.
 * A createRandomConsumable method is made and returns a random consumable from a list
 * Interact is also implemented which lets the player experience the effect of the consumable
 */

import java.util.Random;

public class Consumable extends Item {

    private static Effect effect;

    private int points;

    public Consumable (String description, Effect setEffect, int setCost) {
        super(description, 1, setCost);
        this.effect = setEffect;
        switch(effect) {
            case HEAL:
                this.points = 20;
                break;
            case CURE:
                break;
            case BUFF:
                points = 10;
                break;
        }
    }
    
    public static Consumable createRandomConsumable() {
    	Random ran = new Random();
		int random = ran.nextInt(4);
		switch(random) {
		case 0: return new Consumable("Steroids", Effect.BUFF, 4);
		case 1: return new Consumable("Healing potion", Effect.HEAL, 1);
		case 2: return new Consumable("Multivitamin", Effect.CURE, 2);
		case 3: return new Consumable("Orange juice", Effect.CURE, 1);
		case 4: return new Consumable("Protein bar", Effect.CURE, 1);
		default: return new Consumable("Herbal leaves", Effect.CURE, 1);
		}
    }

    public void interact(Player player) {
        switch(effect){
            case HEAL:
            	player.healPlayer();
            	System.out.println("You are now healed.");
                break;
            case CURE:
                player.curePlayer(points);
                System.out.println("You have been cured.");
                break;
            case BUFF:
                player.increaseDamage(points);
                System.out.println("You notice your veins begin to pop. You feel ready to punch a wall!");
                break;
        }
    }

    @Override
    public TypeOfItem returnType() {
        return TypeOfItem.CONSUMABLE;
    }
}
