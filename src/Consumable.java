import java.util.Random;

public class Consumable extends Item {

    public static final int HEAL = 0;
    public static final int CURE = 1;
    public static final int MAKE_SWOLLE = 2;

    int effect;
    int points;

    public Consumable (String description, int setEffect){
        super(description, 1);
        this.effect = setEffect;
        switch(effect){
            case 0:
                this.points = -20;
                break;
            case 1:
                break;
            case 2:
                points = 5;
                break;
        }
    }
    
    public static Consumable createRandomConsumable() {
    	Random ran = new Random();
		int random = ran.nextInt(4);
		switch(random) {
		case 0: return new Consumable("Steroids", Consumable.MAKE_SWOLLE);
		case 1: return new Consumable("Healing potion", Consumable.HEAL);
		case 2: return new Consumable("Cure", Consumable.CURE);
		case 3: return new Consumable("Orange juice", Consumable.CURE);
		case 4: return new Consumable("Protein bar", Consumable.CURE);
		default: return new Consumable("Spoiled chips", Consumable.CURE);
		}
    }

    public void interact(Player player){
        switch(effect){
            case 0:
                player.receiveDamage(points);
                break;
            case 1:
                player.changeStatus(player.HEALTHY);
                break;
            case 2:
                player.increaseDamage(points);
                break;
        }
    }
}
