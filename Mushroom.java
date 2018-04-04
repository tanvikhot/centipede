import java.util.List;
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class mushroom here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mushroom extends Actor
{
    private final int MENU = 0;     // State 0
    private final int PLAYING = 1;  // State 1
    private final int GAMEOVER = 2;
    private final int NEXTLEVEL = 3;
    /**
     * Act - do whatever the mushroom wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public int i = 1;
    public void act() 
    {
        // Add your action code here.
        if(((MyWorld)getWorld()).getState() == NEXTLEVEL){
            setImage(getImage());
            getImage().scale(20, 20);
        }else if(((MyWorld)getWorld()).getState() == PLAYING){
            if(isTouching(Laser.class)){
                getImage().scale(20, getImage().getHeight()- 4);
                removeTouching(Laser.class);
                removeSelfIfTooSmall();

            }
        }
    }

    protected void removeSelfIfTooSmall() {
        if(getImage().getHeight() == 4){
            getWorld().removeObject(this);   
        }
    }
}
