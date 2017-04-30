/**
 * Created by sibdoo on 30/04/2017.
 */
public class DamageDoor extends Door {

    int damage;
    public DamageDoor(String description, int next, int current, int setDamage){
        super(description, next, current);
        this.damage = setDamage;
    }

    public int doorDamage(){
        return damage;
    }
}
