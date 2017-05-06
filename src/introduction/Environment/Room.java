package introduction.Environment;/* A room inherits from inspectable. Each room has a list of NPCs and doors.
 * Helper methods were also implemented to add NPCs to the room. The method
 * the description methods provides descriptions of the chosen objects.
 * 
 */

import introduction.Environment.Doors.DamageDoor;
import introduction.Environment.Doors.Door;
import introduction.Environment.Doors.NormalDoor;
import introduction.Environment.Doors.RiddleDoor;
import introduction.Inspectable;
import introduction.NPCs.*;

import java.util.*;

public class Room extends Inspectable {

    public List<Door> doorList = new ArrayList<>();
    public List<NPC> NPCList = new ArrayList<>();

    public Room(String s) {
        super(s);
    }

    public void addDoorToRoom(String color, int next, TypeOfDoor typeOfDoor) {
        switch(typeOfDoor) {
            case NORMAL:
                this.doorList.add(new NormalDoor(Color.returnRandomColor(), next));
                break;
            case SPIKY:
                this.doorList.add(new DamageDoor(Color.returnRandomColor(), next, 5));
                break;
            case RIDDLE:
                this.doorList.add(new RiddleDoor(Color.returnRandomColor(), next));
                break;
        }
    }

    public void addEnemyToRoom() {
        this.NPCList.add(EnemyNPC.createRandomEnemy());
    }

    public void addVendorToRoom() {
        this.NPCList.add(new ShadyVendorNPC());
    }

    public void addNunToRoom() {
        this.NPCList.add(new NunNPC());
    }

    public void addBegarToRoom() {
        this.NPCList.add(new BeggarNPC());
    }

    public Door returnDoor(int number) {
        return doorList.get(number);
    }

    public void roomDescription() {
        System.out.print("A " + description +" room with a ");
        for(int i = 0; i < doorList.size() - 1; i++) {
            System.out.print(doorList.get(i).inspect() + " door and a ");
        }
        System.out.println(doorList.get(doorList.size() - 1).inspect() + " door.");
        System.out.print("There's also a ");
        for(int i = 0; i < NPCList.size() - 1; i++) {
            System.out.print(NPCList.get(i).inspect() + " and a ");
        }
        System.out.println(NPCList.get(NPCList.size()-1).inspect());
    }

    public void doorDescription() {
        System.out.println("You look around for doors. You see:");
        for(int i = 0; i < doorList.size(); i++) {
            System.out.println("  (" + i + ") A " + doorList.get(i).inspect() + " door");
        }
    }

    public void NPCDescription() {
        System.out.println("You look around for people. You see:");
        for(int i = 0; i < NPCList.size(); i++) {
            System.out.println("  (" + i + ") A " + NPCList.get(i).inspect());
        }
    }


}