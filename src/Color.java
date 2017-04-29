import java.util.Random;

public class Color {

    

	
	public static String returnRandomColor() {
		Random ran = new Random();
		int whichColor = ran.nextInt(5) + 1;
		
		switch(whichColor) {
			case 1: return "red";
			case 2: return "black";
			case 3: return "yellow";
			case 4: return "purple";
			case 5: return "brown";
			default: return "brown";
		}
	}
}
