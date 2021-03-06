package introduction.Environment;/* introduction.Environment.Color is a class which simply generates a random color.
 * */

import java.util.Random;


public class Color {
	public static String returnRandomColor() {
		Random ran = new Random();
		int whichColor = ran.nextInt(7) + 1;
		
		switch(whichColor) {
			case 1: return "red";
			case 2: return "blue";
			case 3: return "yellow";
			case 4: return "purple";
			case 5: return "brown";
			case 6: return "dark";
			case 7: return "bright";
			default: return "grey";
		}
	}
}
