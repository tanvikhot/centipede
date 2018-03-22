import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int dx = -1;
    private int dy = -1;
    private final int step = 5;
    public void act() 
    {
        if (dx == -1) {
            dx = getX();
        }
        if (dy == -1) {
            dy = getY();
        }
        // Add your action code here.
        if(Greenfoot.isKeyDown("left")){
            if (dx > getImage().getWidth()/2){
                dx = dx - step;
                setLocation(dx, getY());
            }
        }
        if(Greenfoot.isKeyDown("right")){
            if(dx <= getWorld().getWidth() - getImage().getWidth()/2){
                dx = dx + step;
                setLocation(dx, getY());
            }
        }
        if(Greenfoot.isKeyDown("up")){
            if(dy >= 0.8*getWorld().getHeight()){
                dy = dy - step;
                setLocation(getX(), dy);
            }
        }
        if(Greenfoot.isKeyDown("down")){
            if (dy <= getWorld().getHeight() - getImage().getHeight()/2){
                dy = dy  + step;
                setLocation(getX(), dy);
            }

        }
        if(Greenfoot.isKeyDown("space")){
            List laserList = getWorld().getObjects(Laser.class);
            if(laserList.isEmpty()){
                Laser l = new Laser();
                l.getImage().scale(20,20);
                getWorld().addObject(l, getX(), getY()); 
            }
        }

    }    
}
