public abstract class Item extends Inspectable implements Interactable{

    protected int uses;

    public Item(String description, int setUses){
        super(description);
        this.uses = setUses;
    }

}
