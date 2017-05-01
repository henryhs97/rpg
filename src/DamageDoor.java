public class DamageDoor extends Door {

    int damage;
    
    public DamageDoor(String description, int next, int previous, int setDamage) {
        super(description + "and spiky", next, previous);
        this.damage = setDamage;
    }

    public int doorDamage() {
        return damage;
    }
}
