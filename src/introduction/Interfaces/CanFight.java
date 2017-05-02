/* CanFight interface */

public interface CanFight {

    int health = 0;
    int damage = 0;  
    
    public int dealDamage();
    public void receiveDamage(int atk);
    public int getHealth();
    public int getDamage();
}
