package introduction;

import java.util.InputMismatchException;
import java.util.Scanner;

public class OurInput {
    private static void invalidChoice(int min, int choice, int size) throws InputMismatchException {
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
