import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class Hawk here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Butterfly extends Actor
{
    /**
     * Act - do whatever the Hawk wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public static int laserButterfly = 10;
    public void act(){
        int dx = getImage().getWidth()/4;
        // Add your action code here.
        if(Greenfoot.isKeyDown("p")){
            dx = 0;
        }else{
            if(getX() + getImage().getWidth()/2 >= getWorld().getWidth() && getRotation() == 0) {
                turn(90);
                move(getImage().getHeight());
                turn(90);
            } else if(getX() - getImage().getWidth()/2 <= 0 && getRotation() == 180) {
                turn(-90);
                move(getImage().getHeight());
                turn(-90);
            } else if(isTouching(Mushroom.class)){
                move(-dx);
                if (getRotation() == 0) {
                    turn(90);
                    move(getImage().getHeight());
                    turn(90);
                } else {
                    turn(-90);
                    move(getImage().getHeight());
                    turn(-90);
                }
            } else {
                move(dx);
            }
            if(isTouching(Laser.class)){
                Mushroom m = new Mushroom();
                m.getImage().scale(20,20);
                getWorld().addObject(m, getX(), getY());
                removeTouching(Laser.class);
                getWorld().removeObject(this);
                laserButterfly--;
            }else if(getY() > getWorld().getHeight()){
                getWorld().removeObject(this);
            }else if (isTouching(Player.class)) {
                getWorld().removeObjects(getWorld().getObjects(Player.class));
            }
        }
    }
}
