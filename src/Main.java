import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner input= new Scanner(System.in);
		
		Environment environment= new Environment();  //makes envirnment
		Player player= new Player();
		
		
		int number=1;
		while(number != environment.numberOfRooms) { //game ends in the last room
			System.out.println("What do you want to do?");
			System.out.println("  (0) Look Around");
			System.out.println("  (1) Look for a way out");
			
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
			        number = player.enterDoor( environment.returnRoom(number).returnDoor(choice) );
					break;
			}
		}

	}

}
