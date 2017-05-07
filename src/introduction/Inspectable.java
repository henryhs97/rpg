package introduction;/* The abstract class introduction.Inspectable is used for objects to inherit the
 * following properties and methods.
 */

public abstract class Inspectable implements java.io.Serializable{   //every inspectable object has a color accessed through .color

	private static final long serialVersionUID = 42L ;

	
    protected String description;

    public Inspectable (String s) {
        this.description = s;
    }

    public String inspect () {
        return this.description;
    }
}