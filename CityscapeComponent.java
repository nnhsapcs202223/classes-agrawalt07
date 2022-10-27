import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
/**
 * Class that creates instances of the classes that comprise the cityscape and delegates drawing the
 *  cityscape to these object.
 *
 * @author Tejas Agrawal
 * @version 23 October 2022
 */
public class CityscapeComponent extends JComponent
{
    // define the objects in your Cityscape as instance variables
    // ...
    Image image;
    Graphics graphics;
    Rect bar;
    Rect greenPoint;
    boolean hit;
    boolean pointGained;
    int points;

    // define the CityscapeComponent contructor and intiailize all instance variables
    // ...
    public CityscapeComponent(){
        bar = new Rect(500, 500, 20, 100, Color.blue);
        greenPoint = new Rect(50,20,Color.green);
        hit = false;
        this.addKeyListener(new AL());
        this.setFocusable(true);
        //this.addKeyListener(this);

    }

    /**
     * This method is invoked by the Java Run-Time whenever the component needs to be redrawn.
     * It does not need to be invoked explicitly.
     *
     * @param g a reference to the Graphics object used for all drawing operations
     *
     */
    public void paintComponent(Graphics g)
    {
        image = createImage(this.getWidth(), this.getHeight());
        graphics = image.getGraphics();
        g.drawImage(image, 0, 0, this);

        bar.draw(g);
        greenPoint.draw(g);
        greenPoint.moveDown(greenPoint); 
         g.setColor(Color.red);
            g.setFont(new Font("MV Boli", Font.PLAIN,25));
            g.drawString("Points: "+this.points, 25, 40);        
        if(pointGained){
            g.setColor(Color.red);
            g.setFont(new Font("MV Boli", Font.PLAIN,25));
            g.drawString("Points: "+this.points, 25, 40);
            this.pointGained=false;
        }
        // invoke the draw method on each object in your Cityscape
        // ...

    }

    
    /**
     * A method that checks if 2 Rect objects intersect or touch each other
     * 
     * @param pointOrHit The Rect class that you want to compare with player(bar)
     */
    public void checkCollision(Rect pointOrHit){
            if (pointOrHit.getXPos()>=bar.getXPos()) {{
                    if ((pointOrHit.getXPos()+pointOrHit.getWidthSize())>=(bar.getXPos()) && (pointOrHit.getYPos()+pointOrHit.getHeightSize())>=(bar.getYPos()) && pointOrHit.getGone()==false)
                    {  
                        pointOrHit.setGone(true); 
                        pointOrHit.setColor(Color.blue);
                        pointOrHit.setWidthSize(0);
                        pointOrHit.setHeightSize(0);
                        this.points+=1;
                        System.out.println(points); 
                        this.pointGained = true; 
                    }            
                }
            }
            else if((pointOrHit.getXPos())<=bar.getXPos()+bar.getWidthSize() && (pointOrHit.getYPos())>=bar.getYPos()+bar.getHeightSize() && pointOrHit.getGone()==false){
                pointOrHit.setGone(true); 
                pointOrHit.setColor(Color.blue);
                pointOrHit.setWidthSize(0);
                pointOrHit.setHeightSize(0);  
                this.points+=1;
                this.pointGained=true;
                System.out.println(points);
            }
        }

    public class AL extends KeyAdapter{
        @Override
        /**
         * A method that gets what key is pressed and checks if there is a collision when you pressed a key. 
         * 
         * @param e gets what key is pressed
         */
        public void keyPressed(KeyEvent e){
            if (hit!=true){
                bar.keyPressed(e);
                checkCollision(greenPoint); 
                repaint();
            }
        }
    }

    /**
     * Animate the cityscape by updating the objects such that they appear to be animated when
     *      they are next drawn.
     *
     */
    public void nextFrame()
    {

        // update the objects in the cityscape so they are animated
        checkCollision(greenPoint); 
        // request that the Java Runtime repaints this component by invoking its paintComponent method
        //  do not explicitly invoke the paintComponent method
        repaint();
    }

}
