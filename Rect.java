import java.awt.Color;
import java.awt.Graphics;

import java.awt.geom.Rectangle2D;
import java.awt.Graphics2D;

/**
 * Write a description of class Rect here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Rect
{
    // instance variables - replace the example below with your own
    private int xPos;
    private int yPos;
    
    /**
     * Constructor for objects of class Rect
     */
    public Rect()
    {
        // initialise instance variables
        this.xPos = 740;
        this.yPos = 590;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */

    public void Draw(Graphics2D g2)
    {
        Rectangle2D.Double body = new Rectangle2D.Double(this.xPos, this.yPos, 60, 10);       
        g2.setColor(Color.red);
        g2.fill(body); 
    }
    
    public void moveLeft(){
        this.yPos+=3;
    }
}
