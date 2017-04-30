import java.util.Scanner;

public class Enemy extends NPC implements CanFight, Interactable {

    private int health;

    private int damage;

    public Enemy(String description, int setHealth, int setDamage){
        super(description);
        this.health = setHealth;
        this.damage = setDamage;
    }

    public int dealDamage(){
        return damage;
    }

    public void receiveDamage(int atk){
        this.health -= atk;
    }

    public int getHealth(){
        return health;
    }

    public int getDamage(){
        return damage;
    }

    @Override
    public void interact(Player player){
        Scanner input = new Scanner(System.in);

        System.out.println("You see a random enemy. What will you do?");
        System.out.println("  (0) Attack the enemy!");
        System.out.println("  (1) Ignore the enemy ");
        int choice = input.nextInt();
        int nextChoice = 0;

        if (choice == 0) {
            while(this.health > 0 && player.getHealth() > 0){
                player.receiveDamage(this.dealDamage());
                this.receiveDamage(player.dealDamage());
                player.checkStats();
                if(player.getHealth() > 0) {
                    System.out.println("What will you do next?");
                    System.out.println("  (0) Keep fighting!");
                    System.out.println("  (1) Run away!");
                    nextChoice = input.nextInt();
                }
                if(nextChoice == 1){
                    break;
                }
            }
        }

    }
}
