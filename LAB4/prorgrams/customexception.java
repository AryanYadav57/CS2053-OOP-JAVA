package lab05;

import java.util.Scanner;

class InvalidMarksException extends Exception{
	public InvalidMarksException(String message) {
		super(message);
	}
}
public class customexception {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter marks (0-100)");
		int marks = sc.nextInt();
		
		
		try {
			if ( marks<0 || marks>100) {
				throw new InvalidMarksException("Marks should be between 0 and 100");
			}else {
				System.out.println("Marks entered:"+ marks);
			}
		}catch(InvalidMarksException e) {
			System.out.println("Error:"+ e.getMessage());
		}
		
		System.out.println("Program Continues...");
		sc.close();
	}
}
