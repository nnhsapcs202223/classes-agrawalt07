import java.util.*;  
class VendingMachine   
{  
private int tokens;
private ArrayList<String> cans = new ArrayList<String>();
    
public VendingMachine(int initialTokenAmount, ArrayList<String> initialCans){
    this.tokens = initialTokenAmount;
    this.cans = initialCans;
}
    

public VendingMachine(){
    this.tokens = 0;
    this.cans = fillUp();
}

public int getCanCount(){
    int amountOfCans = this.cans.size();
    return amountOfCans;
}

public int getTokenCount(){
    return this.tokens;
}

public void insertToken(){
    if (getCanCount() > 0){
        Scanner sc= new Scanner(System.in);    //System.in is a standard input stream  
        System.out.println("Which soda would you like ");  
        System.out.println(this.cans);
        String soda = sc.nextLine();
        this.tokens += 1;
        this.cans.remove(soda.toLowerCase());
    }
    else{
        fillUp();
        insertToken();
    }
}

public ArrayList fillUp(){
    cans.add("pepsi");
    cans.add("coke");
    cans.add("deit pepsi");
    cans.add("deit coke");
    return cans;
}
public static void main(String[] args){
    VendingMachine vendingMachine = new VendingMachine();
    vendingMachine.insertToken();
}
}  