public abstract class NPC extends Inspectable implements Interactable{

	protected int health;
	
    public NPC(String description){
        super(description);
    }
    
    private void giveDialogue() {
    	System.out.println( this.description );
    }

    public void interact(Player player){
    	giveDialogue();
    	//add ability
    }

}
