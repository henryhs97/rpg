import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner input= new Scanner(System.in);
		
		Room room= new Room(Color.returnRandomColor());
		System.out.println("What do you want to do?");
		System.out.println("    (0) Look Around");
		
		int choice = input.nextInt();
		
		if (choice==0) {
			
			System.out.print("You see: ");
			room.roomDescription();
		}

	}

}
