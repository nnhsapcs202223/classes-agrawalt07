/**
 * This class models a mileage tracker for a car.
 *
 * @author 
 * @version 
 */
public class MileageTracker
{
    /*
     * 2. Define the instance variables (store the object's attributes):
     * specify the visibility (e.g. private)
     *      public visibility means it is accessible by any code in any class
     *      private: only accessible by methods in this class
     *  specify the type (e.g. int, double, String)
     *  specify the name(e.g. distanceDriven)
     *  
     * Instance variables differ from local variables in the following ways:
     *      scoped to the class (accessible to all methods of the class;
     *          lifetime is the same as the object)
     *      automatically initialised to a default value (0, false, null)
     *      best practice is to not immediately initialis instance variables
     *      
     */
     private int distanceDriven; //in units of miles
     private int fuelConsumed; //in units of gallons
     private String vin; //vehicle identification
     

    
    
    
    


    
    /*
     * 3. Define the constructor(s):
     *      a contructor is responsible for initialising newly created objects 
     *      contructors are invoked automatically via the new operator 
     *      has no return type (not even void)
     *      name of the constructor must match the name of the class
     *      multiple constructors may be defined for a class
     *      one contructor may call another constructor (with restrictions)
     */
    
    
    
    
    
    
    
    
    /*
     * 1. Define methods by specifying:
     * The visibility (i.e., public, private)
     * the return type (i.e., void, int, bool, double)
     * the method name (i.e., incrementDistanceDriven, getDistanceDriven) 
     * the parameters and their types (e.g., miles or type int) 
     * 
     */
    /**
     * Default constructor for the MileageTracker class. 
     *      Initialises the objects miles driven and feul consumed to 0 
     *          and the VIN to null.
     */
    public MileageTracker()
    {
        /*
         * The "this" reserved word references the currtent object
         *      (like "self" in Python)
         *  It's usage its encouraged but not always required
         */
        this.distanceDriven = 0;
        this.fuelConsumed = 0;
        this.vin = null;
    }
    
    /**
     * Contructs a new Mileage tracker object with the specified 
     *      miles driven and feul consumed.
     * @param initialDistanceDriven the number of miles already driven 
     * @param initalFeulConsumed the number of gallons of feul already consumed 
     */
    public MileageTracker(int initialDistanceDriven,int initalFeulConsumed)
    {
        this.distanceDriven = initialDistanceDriven;
        this.fuelConsumed = initalFeulConsumed;
        this.vin = null;
        
    }
    
    
    /**
     * Increments the number of miles that the car has driven.
     * 
     * @param miles the additional distance, in miles, this car has driven
     */
    public void incrementDistanceDriven(int miles){
        this.distanceDriven += miles; 
        
        
    }
    
    
    /**
     * Returns the total number of miles driven.
     * 
     * @return the total numberj of miles driven.
     */
    
    public int getDistanceDriven(){
        
        return this.distanceDriven;
    }
    
    
    /**
     * Increment the number of gallons of fuel that this car has consumed
     * 
     * @param gallons    the additional fuel, in gallons, this car has consumed
     */
    public void incrementFuelConsumed(int gallons)
    {
        this.fuelConsumed += gallons;
    }
    
    /**
     * Returns the total number of gallons of fuel consumed
     * 
     * @return the total number of gallons of fuel consumed
     */
    public int getFuelConsumed()
    {
        return this.fuelConsumed;
    
    }
    
    
    /**
     * Returns the current mileage, in miles per gallon
     * 
     * @return the current mileage, in miles per gallon
     */
    public int getMileage()
    {
        int mileage =  this.distanceDriven / this.fuelConsumed ;
        return mileage;
    }
    
    /**
     * Returns the vehicle identification (VIN) of this car.
     * 
     * @return the vehicle identification (VIN) of this car
     */
    public String getVIN()
    {
        return this.vin;
    }
    
    /**
     * Sets the vehicle identification (VIN) of this car.
     * 
     * @param vin    the vehicle identification (VIN) of this car
     */
    public void setVIN(String vin)
    {
        /*
         * When the parameter is named vin, it "shadows" the instance variable vin.
         * 
         * Local and parameter variavles "shadow" instance" variables of the same name. In this code, vin would refer to the paraneter and not the instance variable.
         * 
         */
        vin = vin;
    }
    
    public String toString(){
         /**
          * The toString method is called  automatically when Java needs to convert the object a string. The toString method returns a string that contains, in general, all of the
          * instance varibles and their values.
          * 
          * @return a string that contains, in general, all of the instance variables and their values.
          */
        String str = new String("[VIN]" + this.getVIN() + "; distance driven: " + this.getDistanceDriven() + " miles" + "; fuel consumed" + this.getFuelConsumed() + "  gallons"
        + "; mileage: " + this.getMileage() + " mpgl");
        return str;  
    }
    
    
    
    public static void main(String[] args)
    {
        
        MileageTracker tracker = new MileageTracker(100,4);
        System.out.println(tracker);
    }
}






