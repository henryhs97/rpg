package introduction.Environment.Doors;

public class DamageDoor extends Door {

    private int damage;
    
    public DamageDoor(String description, int next, int previous, int setDamage) {
        super(description + " spiky", next, previous);
        this.damage = setDamage;
    }

    public int doorDamage() {
        System.out.println("The spikes tear your skin as you go through the door.");
        System.out.println("You start feeling ill..");

        return damage;
    }
}
