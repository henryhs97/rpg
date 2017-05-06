package introduction.Environment.Doors;

import introduction.Environment.TypeOfDoor;

public class DamageDoor extends Door {

    private int damage;
    
    public DamageDoor(String description, int next, int setDamage) {
        super(description + " spiky", next, TypeOfDoor.SPIKY);
        this.damage = setDamage;
    }

    public int doorDamage() {
        System.out.println("The spikes tear your skin as you go through the door.");
        System.out.println("You start feeling ill..");

        return damage;
    }
}
