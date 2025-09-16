package lab05;

import java.util.Scanner;

// Custom exception for underage users
class UnderAgeException extends Exception {
    public UnderAgeException(String message) {
        super(message);
    }
}

public class Exercise01  {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your age: ");
        int age = sc.nextInt();
        
        try {
            if (age < 18) {
                throw new UnderAgeException("You must be at least 18 years old!");
            }
            System.out.println("Your age is valid: " + age);
        } catch (UnderAgeException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        System.out.println("Program continues...");
        sc.close();
    }
}

