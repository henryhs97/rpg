public abstract class Inspectable {   //every inspectable object has a color accessed through .color

    protected String color;

    public Inspectable (String s){
        this.color = s;
    }

    public String returnColor (){
        return this.color;
    }
}