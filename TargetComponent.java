
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import java.awt.geom.Ellipse2D;

public class TargetComponent extends JComponent
{  
    int x, y, radius;
    public TargetComponent(int inpX, int inpY, int inpRadius)
    {
        this.x = inpX;
        this.y = inpY;
        this.radius = inpRadius;
    }

    @Override
    public void paintComponent(Graphics g)
    {  
        Graphics2D g2 = (Graphics2D) g;  // cast to Graphics2D object
        
        // Step 1: compile and run the main method in TargetViewer;
        //          verify that a window appears
        
        // Step 2: add code to create a new Ellipse2D.Double object
        //          and draw it using the g2 variable;
        //          verify that an ellipse appears
        
        
        // Step 3: remove code from step 2; implement the Target class;
        //          uncomment the following code;
        //          verify that your target appears

        // create targets
        //Target target1 = new Target(100, 150, 10);
        //Target target2 = new Target(200, 300, 20);
        
        // draw targets
        //target1.draw(g2);
        //target2.draw(g2);      
    }
}
