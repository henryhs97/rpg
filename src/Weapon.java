import java.util.Random;

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
    
    public static Weapon createRandomWeapon() {
    	Random ran = new Random();
		int random = ran.nextInt(4);
		switch(random) {
		case 0: return new Weapon("Rusty pickaxe", 10, 5);
		case 1: return new Weapon("Rusty hammer", 15, 5);
		case 2: return new Weapon("Swiss army knife", 5, 10);
		case 3: return new Weapon("Shovel", 8, 15);
		case 4: return new Weapon("Butcher's knife", 40, 2);
		default: return new Weapon("Toothpick", 1,1);
		}
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
