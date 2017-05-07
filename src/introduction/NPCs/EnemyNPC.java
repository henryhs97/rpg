package introduction.NPCs;/* The implementation of an enemy NPC implements the introduction.Interfaces.CanFight and introduction.Interfaces.Interactable
 * interfaces. Several helper methods are made in order to appropiately implement
 * the interact method. The player has the ability to attack the enemy while they 
 * both lose health points. Once an enemy is dead, the player gets 10 gold.
 * The createRandomEnemy method simply returns a random enemy from a list.
 */

import introduction.Interfaces.CanFight;
import introduction.Interfaces.Interactable;
import introduction.OurInput;
import introduction.Player.Player;

import java.util.Random;
import java.util.Scanner;

public class EnemyNPC extends NPC implements CanFight, Interactable {

    private int health;

    private int damage;

    public EnemyNPC(String description, int setHealth, int setDamage) {
        super(description);
        this.health = setHealth;
        this.damage = setDamage;
    }

    public int dealDamage() {
        return damage;
    }

    public void receiveDamage(int atk) {
        this.health -= atk;
    }

    public int getHealth() {
        return health;
    }

    public int getDamage() {
        return damage;
    }

    @Override
    public void interact(Player player) {
        Scanner input = new Scanner(System.in);

        System.out.println("Stranger: Hasn't anyone taught you not to talk to strangers?");
        System.out.println("  (0) Attack the enemy!");
        System.out.println("  (1) Ignore the enemy ");
        int choice;

        choice = OurInput.makeValidChoice(input, 0, 2);

        if (choice == -1)
            choice = 1;


        while(this.health > 0 && player.getHealth() > 0 && choice == 0) {
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

                choice = OurInput.makeValidChoice(input,0, 2);
                if (choice == -1)
                     choice = 1;

             }
         } 
            
         if(player.getHealth()>0 && this.getHealth()<=0) {
            System.out.println("He's dead. You have found 10 gold in the enemy's pocket!");
            player.addGold(10);
         }
    }
    
    public static EnemyNPC createRandomEnemy() {
    	Random ran = new Random();
		int random = ran.nextInt(3);
		switch(random) {
		case 0: return new EnemyNPC("shady man", 50, 10);
		case 1: return new EnemyNPC("man in a black suit", 75, 20);
		case 2: return new EnemyNPC("man starring back at you", 50, 10);
		case 3: return new EnemyNPC("woman wearing a hood", 10, 1);
		default: return new EnemyNPC("shady man", 50, 10);
		}
    }

}
