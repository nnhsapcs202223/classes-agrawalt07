import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame; 
/**
 * Class that creates instances of the classes that comprise the cityscape and delegates drawing the
 *  cityscape to these object.
 * 
 * @author gcschmit
 * @version 18 July 2014
 */
public class CityscapeComponent extends JComponent implements KeyListener
{
    // define the objects in your Cityscape as instance variables
    // ...
    Rect rectangle = new Rect();


    // define the CityscapeComponent contructor and intiailize all instance variables
    // ...
    public CityscapeComponent(){
        this.addKeyListener(this);
    }

    /**
     * This method is invoked by the Java Run-Time whenever the component needs to be redrawn.
     * It does not need to be invoked explicitly.
     * 
     * @param g a reference to the Graphics object used for all drawing operations
     *
     */
    @Override
    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        this.rectangle.Draw(g2); 
        // invoke the draw method on each object in your Cityscape
        // ...

    }

    @Override
    public void keyTyped(KeyEvent e){

    }

    @Override
    public void keyPressed(KeyEvent e){
        switch(e.getKeyCode()){
            case 37: rectangle.moveLeft();
                break;
        } 
    }

    @Override
    public void keyReleased(KeyEvent e){

    }
    
    
    /**
     * Animate the cityscape by updating the objects such that they appear to be animated when
     *      they are next drawn.
     *
     */
    public void nextFrame()
    {
        // update the objects in the cityscape so they are animated
        // ...
        
        // request that the Java Runtime repaints this component by invoking its paintComponent method
        //  do not explicitly invoke the paintComponent method
        repaint();
    }

}
