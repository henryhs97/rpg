public abstract class Inspectable {   //every inspectable object has a color accessed through .color

    protected String description;

    public Inspectable (String s){
        this.description = s;
    }

    public String inspect (){
        return this.description;
    }
}