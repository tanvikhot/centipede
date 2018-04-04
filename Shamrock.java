import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Shamrock here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Shamrock extends Mushroom
{
    /**
     * Act - do whatever the Shamrock wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        super.act();
        // Add your action code here.
    }

    protected void removeSelfIfTooSmall() {
        if(getImage().getHeight() == 8){
            for (int i=0; i < 12; i++) {
                Laser l = new Laser(30*i);
                l.getImage().scale(20, 20);
                getWorld().addObject(l, getX(), getY());
            }
            getWorld().removeObject(this);
        }
    }
}
