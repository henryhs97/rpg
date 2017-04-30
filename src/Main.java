import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner input= new Scanner(System.in);
		
		Environment environment= new Environment();  //makes environment
		Player player= new Player(100,5);
        player.inventory.add(new Weapon("Rusty hammer", 15, 10));
        player.inventory.add(new Weapon("Rusty pickaxe", 10, 10));
        player.inventory.add(new Consumable("Cure", Consumable.CURE));
        player.inventory.add(new Consumable("Healing potion", Consumable.HEAL));
        player.inventory.add(new Consumable("Steroids", Consumable.MAKE_SWOLLE));


        int number=1;
		while(number != environment.numberOfRooms) { //game ends in the last room
			if(player.getHealth() <= 0){
				System.out.println("You died.. GG");
				break;
			}
			System.out.println("What do you want to do?");
			System.out.println("  (0) Look Around");
			System.out.println("  (1) Look for a way out");
			System.out.println("  (2) Check your inventory");
			System.out.println("  (3) Check your stats");
			System.out.println("  there are "+ environment.numberOfRooms + " and in this room there are "+ environment.returnRoom(number).numOfDoors+"doors");
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
			        System.out.println("you picked: " + choice);
			        if(player.getStatus() == Player.POISONED){
			        	player.poisonDamage();
					}
			        number = player.enterDoor( environment.returnRoom(number).returnDoor(choice) );

					break;
                case 2:
                    player.checkInventory(input);
                case 3:
                    player.checkStats();
			}
		}

	}

}
