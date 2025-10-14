package lab07;

public class wrapper_demo {
    public static void main(String[] args) {
      
        int num = 10;
        Integer obj1 = Integer.valueOf(num); 
        System.out.println("Wrapper Class (Manual Boxing): " + obj1);

        Integer obj2 = num;
        System.out.println("Autoboxing Example: " + obj2);

        int newNum = obj2;  
        System.out.println("Auto-unboxing Example: " + newNum);

        
        Double d = 12.34;    
        double val = d;    
        System.out.println("Double Wrapper Autoboxing: " + d);
        System.out.println("Double Wrapper Auto-unboxing: " + val);
    }

}

