package introduction;/* The main function creates the main dialogue with the user, each providing the
 * player with 5 options. The game ends when (if) the player dies.
 */

import introduction.Environment.*;

import java.io.*;
import java.util.*;
import introduction.Environment.Doors.*;
import introduction.NPCs.EnemyNPC;
import introduction.Player.*;

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
			System.out.println("  (5) Quicksave");
			System.out.println("  (6) Quickload");
			System.out.println("  (7) Save");
			System.out.println("  (8) Load");
			
			choice = OurInput.makeValidChoice(input,-1, 9);
			if(choice!=6 && choice!= 5 && choice!=3 && choice!=2 && choice!=7 && choice!=8) {
				System.out.print("You see: ");			
			}
			switch(choice) {
                case 0:
                    environment.returnRoom(number).roomDescription();
                    break;
                case 1:
                    environment.returnRoom(number).doorDescription();
                    System.out.println("Which door do you take? (-1: stay here)");

                    choice = OurInput.makeValidChoice(input,-1, environment.returnRoom(number).doorList.size());

                    if(choice != -1) {
	                    if (player.getStatus() == Status.POISONED) {
	                    	System.out.println("The poison is slowly killing you..");
	                        player.poisonDamage();
	                    }
	                    if (environment.returnRoom(number).returnDoor(choice) instanceof DamageDoor) {
	                        player.receiveDamage(((DamageDoor) environment.returnRoom(number).returnDoor(choice)).doorDamage());
	                        player.changeStatus(Status.POISONED);
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

					choice = OurInput.makeValidChoice(input,-1, environment.returnRoom(number).NPCList.size());

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
                case 5:
                	saveGame("quicksave", environment, player);
                	break;
                case 7: 
                	System.out.println("File name?");
                	input.nextLine();
                	String saveName = input.nextLine(); 
                	saveGame(saveName, environment, player);              	
                	break;
                case 6:
                	try{
                    	FileInputStream fileIn = new FileInputStream("./Savegames/quicksave.ser");
                        ObjectInputStream in = new ObjectInputStream(fileIn);
                        environment = (Environment) in.readObject();
                        player = (Player) in.readObject();
                     	in.close();
                     	fileIn.close();
                     	System.out.println("Loaded quicksave.");
                	}catch(IOException i) {
                		i.printStackTrace();
                		return;
                	}catch(ClassNotFoundException c) {
                		System.out.println("Employee class not found");
                		c.printStackTrace();
                		return;
                	}
                	break;
                case 8:
                	//try{
                	//	File folder = new File("./Savegames");
                		//List<File> listOfSaves = new ArrayList<>(folder.listFiles());
                		
                 	//}
			}
		}
	}

	
	static void saveGame(String gameName, Environment environment, Player player) {
		try {
			File saveFile = new File("./Savegames/" + gameName + ".ser");  
            FileOutputStream fileOut = new FileOutputStream(saveFile);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(environment);
            out.writeObject(player);
            out.close();
            fileOut.close();
            System.out.println("Quicksaved.");
    	} catch(NotSerializableException classException){
    		System.out.println("ERROR: Class is not serializable: ");
    		System.out.println(classException.getLocalizedMessage());
    		System.exit(0);
        } catch(IOException ioException) {
        	System.out.println("ERROR: Unknown IO error.");
        	System.out.println("Possible problem with savefile");
        	ioException.printStackTrace();
        	System.exit(0);
        }
	}
	

}
