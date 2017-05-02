import java.util.Scanner;

public class RiddleDoor extends Door implements Interactable{


    private boolean isSolved;

    public RiddleDoor(String description, int nextRoom, int currentRoom) {
        super(description + " guarded",nextRoom,currentRoom);
        this.isSolved = false;
    }

    public void interact(Player player){
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

    public boolean isRiddleSolved(){
        return isSolved;
    }

    public void weSolvedIt(){
        this.isSolved = true;
    }
}
