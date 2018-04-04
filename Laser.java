import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Laser here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Laser extends Actor
{
    public Laser(int rotation) {
        setRotation(rotation);
    }
    
    public Laser() {
        setRotation(270);
    }
        
    /**
     * Act - do whatever the Laser wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int dy = 30;

    public void act() 
    {
        // Add your action code here.

        // setLocation(getX(), getY() - dy);
        move(dy);
        if(isAtEdge()){
           getWorld().removeObject(this);
        }
    }
}
