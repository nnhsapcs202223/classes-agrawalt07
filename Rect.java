import java.awt.*;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.*;
import java.util.Random;
/**
 * This class creates a rectangle with ability to configure the xPos, yPos, height, width, and color. 
 *
 * @author Tejas Agrawal
 * @version 26 Oct. 2022
 */
public class Rect extends Rectangle
{
    private Color color;
    private int x;
    private int y;
    private int height;
    private int width;
    private boolean gone;
    Rect(int initialX, int initialY, int initialHeight, int initialWidth, Color initialColor){
        this.x = initialX;
        this.y = initialY;
        this.height = initialHeight;
        this.width = initialWidth;
        this.color = initialColor;
        this.gone = false;
    }

    Rect(int initialHeight, int initialWidth, Color initialColor)
{
    Random number = new Random();
    this.x = number.nextInt(600);
    this.y = 0;
    this.height = initialHeight;
    this.width = initialWidth;
    this.color = initialColor;
}
    /**
     * Uses the keyEvent or the key that is presssed that move the Rect object left or right.
     * 
     * @param e evaluates what key is pressed
     */

    public void keyPressed(KeyEvent e){
        if (e.getKeyCode() == KeyEvent.VK_LEFT & this.x<800 & this.x>0){
            this.x = x-10;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT & this.x<600 & this.x>0){
            this.x = x+10;
        }
    }
    
    /**
     * returns the integer value of the xPos of the Rect object
     * 
     * @return The x position of the Rect object
     */
    public int getXPos(){
        return this.x; 
    }

    /**
     * returns the integer value of the width size of the Rect object
     * 
     * @return The width size of the Rect object
     */
    public int getWidthSize(){
        return this.width;
    }

    /**
     * returns the integer value of the heigth size of the Rect object
     * 
     * @return The height size of the Rect object
     */
    public int getHeightSize(){
        return this.height;
    }

    /**
     * returns the integer value of the yPos of the Rect object
     * 
     * @return The y position of the Rect object
     */
        public int getYPos(){
        return this.y; 
    }

/**
 * returns whether the Rect object is gone from the screen or not
 * 
 * @return The boolean state of the gone variable of the Rect object
 */
    public boolean getGone(){
        return this.gone; 
    }

    /**
     * sets the integer value of the xPos of the Rect object
     * 
     * @param newX the new x position of the Rect object
     */
        public void setXPos(int newX){
         this.x = newX; 
    }

    /**
     * sets the integer value of the width size of the Rect object
     * 
     * @param newWidth the new width size of the Rect object
     */
    public void setWidthSize(int newWidth){
         this.width = newWidth;
    }

    /**
     * sets the integer value of the height of the Rect object
     * 
     * @param newHeight the new height size of the Rect object
     */
    public void setHeightSize(int newHeight){
         this.height = newHeight;
        }

    /**
     * sets the integer value of the yPos of the Rect object
     * 
     * @param newY the new y position of the Rect object
     */
        public void setYPos(int newYPos){
         this.y = newYPos; 
    }

    /**
     * sets the new Colour of the Rect object
     * 
     * @param newColor the new Colour of the Rect object
     */
    public void setColor(Color newColor){
        this.color = newColor;
    }

    /**
     * sets the boolean value of the gone variable of the Rect object
     * 
     * @param newGone the new gone state of the Rect object
     */
    public void setGone(boolean newGone){
         this.gone = newGone; 
    }

    /**
     * Draws a rectangle from the Rect class with the color, x, y, width, height that is given 
     * 
     * @param g The graphics object that is used to draw the rectangle
     */
    public void draw(Graphics g){
        g.setColor(this.color);
        g.fillRect(this.x, this.y, this.width, this.height);
    }

    /**
     * Allows a Rect object to fall from the top of the screen to the bottom 
     * 
     * @param rectangle The instance of the Rect class that you want to move down the screen
     */
    public void moveDown(Rect rectangle){

        try {
            if (rectangle.y>=600){
                rectangle.y+=10;
                gone = true;
                
            }
            else{
                rectangle.y+=10;
                Thread.sleep( 100 );
            }

        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
