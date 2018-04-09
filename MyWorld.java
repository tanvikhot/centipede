import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    private final int MENU = 0;     // State 0
    private final int PLAYING = 1;  // State 1
    private final int GAMEOVER = 2;
    private final int NEXTLEVEL = 3;
    private int state = MENU; // Begin in MENU state
    private boolean enterPressed = false;
    int time = 0;
    Text timer;
    int a = 0;
    int startLaser = 0;
    public MyWorld()
    {    
        super(400,600, 1,false); 
        timer = new Text(String.valueOf(time));
        addObject(timer, timer.getImage().getWidth(), getHeight() - timer.getImage().getHeight());
        Title t = new Title();
        addObject(t, getWidth()/2, getHeight()/2);
    }

    public void startGame() {
        Butterfly.laserButterfly = 10;
        for(int i = 0; i < 10; i++){
            Butterfly fly = new Butterfly();
            fly.getImage().scale(20, 20);
            addObject(fly, fly.getImage().getWidth()/2 + i*fly.getImage().getWidth(), fly.getImage().getHeight()/2);

        }
        for(int i = 0; i < 30; i++){
            if(i%4 != 0){
                Mushroom m = new Mushroom();
                m.getImage().scale(20,20);
                int imageHeight = m.getImage().getHeight();
                int imageWidth = m.getImage().getWidth();
                int x = 0;
                int y = 0;
                addObject(m, Greenfoot.getRandomNumber(getWidth()/imageWidth-1)*imageWidth+imageWidth*3/2,
                    Greenfoot.getRandomNumber(getHeight()/imageHeight-1)*imageHeight+imageHeight*3/2);

                if( getObjectsAt(m.getX(), m.getY(), Mushroom.class) == null){
                    x = Greenfoot.getRandomNumber((getWidth()/imageWidth-1)*imageWidth+imageWidth*3/2);
                    y = Greenfoot.getRandomNumber((getHeight()/imageHeight-1)*imageHeight+imageHeight*3/2);
                }
                addObject(m, x,y); 
            }else{
                Shamrock s = new Shamrock();
                s.getImage().scale(20,20);
                int imageHeight = s.getImage().getHeight();
                int imageWidth = s.getImage().getWidth();
                int x = 0;
                int y = 0;
                addObject(s, Greenfoot.getRandomNumber(getWidth()/imageWidth-1)*imageWidth+imageWidth*3/2,
                    Greenfoot.getRandomNumber(getHeight()/imageHeight-1)*imageHeight+imageHeight*3/2);

                if( getObjectsAt(s.getX(), s.getY(), Mushroom.class) == null){
                    x = Greenfoot.getRandomNumber((getWidth()/imageWidth-1)*imageWidth+imageWidth*3/2);
                    y = Greenfoot.getRandomNumber((getHeight()/imageHeight-1)*imageHeight+imageHeight*3/2);
                }
                addObject(s, x,y); 
            }
        }
        Player p = new Player();
        p.getImage().scale(20,20);
        addObject(p, getWidth()/2, getHeight() - p.getImage().getHeight()/2);

    }

    public void act() {
        a++;
        if(a%60 == 0){
            time++;
            timer.setContent(String.valueOf(time)); 
        }
        if(state == MENU){
            if(Greenfoot.isKeyDown("enter")){
                state = PLAYING;
                startGame();
            }
        }
        else if(state == PLAYING){
            List butterflyList = getObjects(Butterfly.class);
            if(butterflyList.size() < Butterfly.laserButterfly){
                cleanUp();
                displayGameOver();
            }else if(butterflyList.isEmpty() && Butterfly.laserButterfly == 0){
                state = NEXTLEVEL;
                moveLevel();
            }
            if (getObjects(Player.class).size() == 0) {
                cleanUp();
                displayGameOver();
            }
        }
        else if(state == NEXTLEVEL){
            state = PLAYING;
        }
        else if(state == GAMEOVER && Greenfoot.isKeyDown("enter")){
            enterPressed = true;
        }else if (enterPressed){
            enterPressed = false;
            state = MENU;
            Title t = new Title();
            addObject(t, getWidth()/2, getHeight()/2);
        }
    }

    private void displayGameOver() {
        GameOver g = new GameOver();
        state = GAMEOVER;
        addObject(g, getWidth()/2, getHeight()/2);
    }

    public int getState(){
        return state;
    }

    public void moveLevel(){
        for(int i = 0; i < 10; i++){
            Butterfly fly = new Butterfly();
            fly.getImage().scale(20, 20);
            addObject(fly, fly.getImage().getWidth()/2 + i*fly.getImage().getWidth(), fly.getImage().getHeight()/2);

        }
        Butterfly.laserButterfly = 10;
    }

    private void cleanUp(){
        removeObjects(getObjects(Mushroom.class));
        removeObjects(getObjects(Shamrock.class));
        removeObjects(getObjects(Player.class));
        removeObjects(getObjects(Laser.class));
        removeObjects(getObjects(Butterfly.class));
    }
}
