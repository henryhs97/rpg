public abstract class Inspectable {

    protected String color;

    public Inspectable (String s){
        this.color = s;
    }

    public String returnColor (){
        return this.color;
    }
}