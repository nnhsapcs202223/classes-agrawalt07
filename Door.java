
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

    public String getName(){
        return this.name; 
    }

    public void setName(String newName){
        this.name = newName;
    }

    public boolean isOpen(){
        return this.isOpened;
    }

    public void close(){
        this.isOpened = false;
    }

    public void open(){
        this.isOpened = true;
    }

    public void setStateOfDoor(String state){
        if (state.toLowerCase() == "close"){
            this.isOpened = false;
        } else if (state.toLowerCase() == "open"){
            this.isOpened = true;
        }
    }
    
    public String getStateOfDoor(){
        if (this.isOpened == false){
            return "Door is closed";
        }
        else {
            return "Door is open";
        }
        
    }
}

