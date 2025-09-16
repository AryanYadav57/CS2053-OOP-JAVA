package lab05;

import java.util.Scanner;

class InvalidMarksException extends Exception {
    public InvalidMarksException(String message) {
        super(message);
    }
}

public class Exercise03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter marks for the subject (0-100): ");
        int marks = sc.nextInt();
        
        try {
            if (marks < 0 || marks > 100) {
                throw new InvalidMarksException("Marks should be between 0 and 100.");
            }
            System.out.println("Marks entered: " + marks);
        } catch (InvalidMarksException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        System.out.println("Program continues...");
        sc.close();
    }
}

