package lab05;

import java.util.Scanner;

class WeakPasswordException extends Exception {
    public WeakPasswordException(String message) {
        super(message);
    }
}

public class Exercise02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your password: ");
        String password = sc.nextLine();
        
        try {
            if (password.length() < 6) {
                throw new WeakPasswordException("Password too short! Must be at least 6 characters.");
            }
            System.out.println("Password is valid.");
        } catch (WeakPasswordException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        System.out.println("Program continues...");
        sc.close();
    }
}

