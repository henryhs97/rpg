import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner input= new Scanner(System.in);
		
		Environment environment= new Environment();  //makes environment
		Player player= new Player(100,5, 5);

        int number=0;
		while(true) { //game ends in the last room
			if(player.getHealth() <= 0){
				System.out.println("You died.. GG");
				break;
			}
			System.out.println("What do you want to do?");
			System.out.println("  (0) Look Around");
			System.out.println("  (1) Look for a way out");
			System.out.println("  (2) Check your inventory");
			System.out.println("  (3) Check your stats");
			System.out.println("  (4) Look for people");
			int choice = input.nextInt();
			System.out.print("You see: ");
			
			switch(choice) {
                case 0:
                    environment.returnRoom(number).roomDescription();
                    break;
                case 1:
                    environment.returnRoom(number).doorDescription();
                    System.out.println("Which door do you take? (-1: stay here)");
                    choice = input.nextInt();
                    if(choice!=-1) {
	                    if (player.getStatus() == Player.POISONED) {
	                        player.poisonDamage();
	                    }
	                    if (environment.returnRoom(number).returnDoor(choice) instanceof DamageDoor) {
	                        player.receiveDamage(((DamageDoor) environment.returnRoom(number).returnDoor(choice)).doorDamage());
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
                    choice = input.nextInt();
                    if(choice!=-1) {
	                    environment.returnRoom(number).NPCList.get(choice).interact(player);
	                    if(environment.returnRoom(number).NPCList.get(choice) instanceof Enemy){
	                        int health = ((Enemy) environment.returnRoom(number).NPCList.get(choice)).getHealth();
	                        if(health <= 0){
	                            System.out.println("Nigga be dead now.");
	                            environment.returnRoom(number).NPCList.remove(choice);
	                        }
	                    }
                    }
	                    break;
			}
		}

	}

}
