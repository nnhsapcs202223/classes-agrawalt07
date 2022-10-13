import java.util.Scanner;
/**
 * Write a description of class Rectange here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Rectangle
{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("What would you like your Length and Height to be(Use spaces): ");
        int length = sc.nextInt();
        int height = sc.nextInt();
        Rectangle userRectangle = new Rectangle(height, length);
        System.out.print(userRectangle);
    }
    
    
    private double height;
    private double length;
    public Rectangle(double initialHeight, double initialLength){
        this.height = initialHeight;
        this.length = initialLength; 
    }
    
    public double getArea(){
        return this.height*this.length;
    }
    
    public double getPerimeter(){
        return (2*this.height)+(2*this.length);
    }
    
    public double getDiagonalLength(){
        return Math.sqrt(Math.pow(this.length, 2)+Math.pow(this.height, 2));
    }
    
    public String toString(){
        return "Height: "+this.height + " Length: "+this.length+ " Area: " + getArea() + " Perimeter: " + getPerimeter() + " Diagonal length: " + getDiagonalLength();
    }
}
