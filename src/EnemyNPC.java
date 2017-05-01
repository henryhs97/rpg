import java.util.Scanner;

public class EnemyNPC extends NPC implements CanFight, Interactable {

    private int health;

    private int damage;

    public EnemyNPC(String description, int setHealth, int setDamage){
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

        System.out.println("Stranger: Hasn't anyone taught not to talk to strangers? Now you must die!");
        System.out.println("  (0) Attack the enemy!");
        System.out.println("  (1) Ignore the enemy ");
        int choice = input.nextInt();
        int nextChoice = 0;

        while(this.health > 0 && player.getHealth() > 0 && nextChoice == 0) {
             player.receiveDamage(this.dealDamage());
             this.receiveDamage(player.dealDamage());
             if(this.getHealth() <= 0) {
                break;
             }
             System.out.println("Your health: "+ player.getHealth());
             System.out.println("Enemy's health: "+ this.getHealth());
             if(player.getHealth() > 0) {
                System.out.println("What will you do next?");
                System.out.println("  (0) Keep fighting!");
                System.out.println("  (1) Run away!");
                nextChoice = input.nextInt();
             }
         } 
            
         if(player.getHealth()>0 && this.getHealth()<=0) {
            System.out.println("He's dead. You have found 10 gold in the enemy's pocket!");
            player.addGold(10);
         }
        }
}
