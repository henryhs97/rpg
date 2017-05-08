package introduction.Environment.Doors;

import introduction.Environment.TypeOfDoor;
import introduction.Interfaces.Interactable;
import introduction.Player.Player;

import java.util.Scanner;


public class RiddleDoor extends Door implements Interactable {

    private boolean isSolved;

    public RiddleDoor(String description, int nextRoom) {
        super(description + " guarded",nextRoom, TypeOfDoor.RIDDLE);
        this.isSolved = false;
    }

    public void interact(Player player){
        if(isSolved == true){
            System.out.println("Old man: Stop! Who approaches the door of.. Oh it's you, go ahead.");
            return;
        }
        Scanner input = new Scanner(System.in);
        System.out.println("You see an old bearded man in front of the door.");
        System.out.println("Old man: Stop! Who approaches the Door of Death must answer me these questions three!");
        System.out.println("There on the other side, he see..");
        System.out.println("You: Ask me the questions door keeper, I'm not afraid!");
        System.out.println("What is your name?");
        input.nextLine();
        System.out.println("What is your quest?");
        input.nextLine();
        System.out.println("What.. is the capital of Assyria?");
        String answer = input.nextLine();

        if(answer.equals("Assur") || answer.equals("Nineveh")){
            System.out.println("Alright, off you go!");
            isSolved = true;
            return;
        }else{
            System.out.println("You scream, as you magically fly through the ceiling and into The Gorge of Eternal Peril.");
            player.receiveDamage(9001);
        }
    }
}
