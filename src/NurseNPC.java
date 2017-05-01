public class NurseNPC extends NPC{
	
    public NurseNPC() {
    	super("nurse");	
    }
	
	private String nurseDialogue(int typeOfResponse) {
		String s = null;
		switch(typeOfResponse) {
		case 1:
			s= "I can't do anymore for you without plastic surgery.";
			break;
		case 2:
			s= "Here sweety, have a band aid.";
			break;
		case 3:
			s= "My goodness, you're going to need a lot of stitches for this! That should do it...";
			break;
		case 4:
			s= "How are you still alive with that wound on your chest? Here, this should make it better.";
		}
		return s;
	}
	
    public void interact(Player player) {
    	if(player.getHealth()==100) {
    		System.out.println(this.nurseDialogue(1));
    	}
    	else if(player.getHealth()>70) {
    		System.out.println(this.nurseDialogue(2));
    	}
    	else if(player.getHealth()>40) {
    		System.out.println(this.nurseDialogue(3));
    	}
    	else if(player.getHealth()>0) {
    		System.out.println(this.nurseDialogue(4));
    	}
    	player.healPlayer();
    }
    	  
}