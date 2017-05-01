/* NPC implements an interactable interface and inherits from inspectable. Each
 * NPC also has its own inventory.
 */

import java.util.ArrayList;
import java.util.List;

public abstract class NPC extends Inspectable implements Interactable{

    List<Item> inventory = new ArrayList<>();
	
    public NPC(String description) {
        super(description);
    }


}
