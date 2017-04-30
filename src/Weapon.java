
public class Weapon extends Item{

    private int damage;

    public Weapon(String description, int setDamage, int setUses){
        super(description, setUses);
        this.damage = setDamage;
    }

    @Override
    public void interact(Player player) {
        System.out.println("Equiped: " + inspect());
        player.equipWeapon(this);
    }

    public boolean use(){
        this.uses--;
        if(this.uses == 0){
            return false;
        }
        return true;
    }

    public int checkCondition(){
        return uses;
    }

    public int getDamage(){
        return damage;
    }

}
