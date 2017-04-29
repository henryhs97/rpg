import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner input= new Scanner(System.in);
		
		Environment environment= new Environment();  //makes envirnment
		
		System.out.println("What do you want to do?");
		System.out.println("  (0) Look Around");
		System.out.println("  (1) Look for a way out");
		
		int choice = input.nextInt();
		System.out.print("You see: ");
		switch(choice) {
		
			case 0:
				environment.returnRoom(1).roomDescription();
				break;
			case 1:
				environment.returnRoom(1).doorDescription();
				break;
		}

	}

}
