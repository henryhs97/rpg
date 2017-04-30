
public class Weapon extends Item{

    private int damage;

    public Weapon(String description, int setDamage, int setUses){
        super(description, setUses);
        this.damage = setDamage;
    }

    @Override
    public void interact(Player player) {
        System.out.print("Equiped: " + inspect());
        player.equipWeapon(this);
    }

    public boolean use(){
        this.uses--;
        if(this.uses == 0){
            return false;
        }
        return true;
    }

    public void checkCondition(){
        System.out.println("Number of uses left: " + this.uses);
    }

    public int getDamage(){
        return damage;
    }

}
