package project1;

public class add {
	    public static void main(String[] args) {
	        // Check if exactly two arguments are passed
	        if (args.length != 2) {
	            System.out.println("Please provide two numbers.");
	            return;
	        }

	        // Convert the command line arguments to integers
	        int num1 = Integer.parseInt(args[0]);
	        int num2 = Integer.parseInt(args[1]);

	        // Add the two numbers
	        int sum = num1 + num2;

	        // Print the result
	        System.out.println("The sum of " + num1  + " and " + num2  + " is " + sum);
	    }
	}


