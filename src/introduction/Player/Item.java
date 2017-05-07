package introduction.Player;/* Each item has the number of times it may be used, as well as its cost.
 */

import com.sun.deploy.security.ValidationState;
import introduction.Inspectable;
import introduction.Interfaces.Interactable;

public abstract class Item extends Inspectable implements Interactable {

    int uses;
    int cost;
    TypeOfItem type;

    public Item(String description, int setUses, int setCost) {
        super(description);
        this.uses = setUses;
        this.cost= setCost;
    }

    public int returnCost(){
        return this.cost;
    }

    abstract public TypeOfItem returnType();

}
