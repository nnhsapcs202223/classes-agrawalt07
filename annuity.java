
/**
 * Write a description of class annuity here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class annuity
{
    public static double calcPresentValue(double pmt, double i, int n){
        double x = (Math.pow(i+1, n-1));
        System.out.println(pmt*((((x-1)/(i))/x)+1));
        return pmt*((((x-1)/(i))/x)+1);
    }
}
