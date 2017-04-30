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
