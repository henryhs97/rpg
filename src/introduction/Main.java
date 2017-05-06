package introduction;/* The main function creates the main dialogue with the user, each providing the
 * player with 5 options. The game ends when (if) the player dies.
 */

import introduction.Environment.*;
import introduction.Environment.Doors.*;
import introduction.NPCs.EnemyNPC;
import introduction.Player.*;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		Scanner input= new Scanner(System.in);
		
		Environment environment = new Environment();  //makes environment
		Player player = new Player(100,5, 5);

		int number = 0;
		int choice;

		while(true) {
			if(player.getHealth() <= 0) {
				System.out.println("You died.. GG");
				break;
			}
			System.out.println("What do you want to do?");
			System.out.println("  (0) Look Around");
			System.out.println("  (1) Look for a way out");
			System.out.println("  (2) Check your inventory");
			System.out.println("  (3) Check your stats");
			System.out.println("  (4) Look for people");

			choice = makeValidChoice(input,-1, 5);

			System.out.print("You see: ");			
			switch(choice) {
                case 0:
                    environment.returnRoom(number).roomDescription();
                    break;
                case 1:
                    environment.returnRoom(number).doorDescription();
                    System.out.println("Which door do you take? (-1: stay here)");

                    choice = makeValidChoice(input,-1, environment.returnRoom(number).doorList.size());

                    if(choice != -1) {
	                    if (player.getStatus() == Player.POISONED) {
	                    	System.out.println("The poison is slowly killing you..");
	                        player.poisonDamage();
	                    }
	                    if (environment.returnRoom(number).returnDoor(choice) instanceof DamageDoor) {
	                        player.receiveDamage(((DamageDoor) environment.returnRoom(number).returnDoor(choice)).doorDamage());
	                        player.changeStatus(Player.POISONED);
	                    }else if(environment.returnRoom(number).returnDoor(choice) instanceof RiddleDoor){
	                    	RiddleDoor tempDoorPointer = (RiddleDoor) environment.returnRoom(number).returnDoor(choice);
	                    	if(!tempDoorPointer.isRiddleSolved()) {
								tempDoorPointer.interact(player);
								tempDoorPointer.weSolvedIt();
							}
							if(player.getHealth() <= 0) {
								break;
							}
						}
	                    number = player.enterDoor(environment.returnRoom(number).returnDoor(choice));
                    }
	                    break;
                case 2:
                    player.checkInventory(input);
                    break;
                case 3:
                    player.checkStats();
                    break;
                case 4:
                    environment.returnRoom(number).NPCDescription();
                    System.out.println("Who do you talk to? (-1: do nothing)");

					choice = makeValidChoice(input,-1, environment.returnRoom(number).NPCList.size());

                    if(choice!=-1) {
	                    environment.returnRoom(number).NPCList.get(choice).interact(player);
	                    if(environment.returnRoom(number).NPCList.get(choice) instanceof EnemyNPC){
	                        int health = ((EnemyNPC) environment.returnRoom(number).NPCList.get(choice)).getHealth();
	                        if(health <= 0){
	                            environment.returnRoom(number).NPCList.remove(choice);
	                        }
	                    }
                    }
					break;
			}
		}
	}

	public static void invalidChoice(int min, int choice, int size) throws InputMismatchException{
		if(choice < min || choice >= size) {
			throw new InputMismatchException("Please input a valid number: ");
		}
	}

	public static int makeValidChoice(Scanner input, int min, int size){
		int choice;
		try{
			if(input.hasNextInt()) {
				choice = input.nextInt();
				invalidChoice(min,choice,size);
			}else{
				input.nextLine();
				throw new InputMismatchException();
			}
		}catch(InputMismatchException e){
			System.out.println("Invalid input, returning to room menu.");
			choice = -1;
		}
		return choice;
	}
}
