public abstract class Item extends Inspectable implements Interactable{

    protected int uses;
    protected int cost;

    public Item(String description, int setUses, int setCost){
        super(description);
        this.uses = setUses;
        this.cost= setCost;
    }
    

}
