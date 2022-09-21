
/**
 * Write a description of class Door here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Door
{
    private boolean isOpened;
    private String name; 
    
    public Door(){
        this.name = null;
        this.isOpened = false;
    }
    
    public Door(String initialName, boolean initialIsOpened){
        this.name = initialName;
        this.isOpened = initialIsOpened;
    }
    
    
}
