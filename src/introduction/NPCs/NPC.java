/* NPC implements an interactable interface and inherits from inspectable. Each
 * NPC also has its own inventory.
 */
package introduction.NPCs;


public abstract class NPC extends Inspectable implements Interactable{
	
    public NPC(String description) {
        super(description);
    }

    abstract public void interact(Player player);

}
