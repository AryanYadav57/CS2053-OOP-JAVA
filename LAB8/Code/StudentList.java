package Lab008;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentList {
    public static void main(String[] args) {
        ArrayList<String> students = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Student List Menu ---");
            System.out.println("1. Add Student");
            System.out.println("2. Insert Student at Specific Index");
            System.out.println("3. Update Student Name");
            System.out.println("4. Remove Student (by Name or Index)");
            System.out.println("5. Display All Students");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter student name to add: ");
                    String name = sc.nextLine();
                    students.add(name);
                    System.out.println("Student added successfully.");
                    break;

                case 2:
                    System.out.print("Enter index position: ");
                    int index = sc.nextInt();
                    sc.nextLine();
                    if (index >= 0 && index <= students.size()) {
                        System.out.print("Enter student name to insert: ");
                        String newName = sc.nextLine();
                        students.add(index, newName);
                        System.out.println("Student inserted successfully.");
                    } else {
                        System.out.println("Invalid index!");
                    }
                    break;
 
                case 3:
                    System.out.print("Enter the name to update: ");
                    String oldName = sc.nextLine();
                    if (students.contains(oldName)) {
                        System.out.print("Enter new name: ");
                        String updatedName = sc.nextLine();
                        int i = students.indexOf(oldName);
                        students.set(i, updatedName);
                        System.out.println("Student name updated successfully.");
                    } else {
                        System.out.println("Student not found!");
                    }
                    break;

                case 4:
                    System.out.println("Remove by: 1. Name  2. Index");
                    int removeChoice = sc.nextInt();
                    sc.nextLine();
                    if (removeChoice == 1) {
                        System.out.print("Enter name to remove: ");
                        String removeName = sc.nextLine();
                        if (students.remove(removeName))
                            System.out.println("Student removed successfully.");
                        else
                            System.out.println("Student not found!");
                    } else if (removeChoice == 2) {
                        System.out.print("Enter index to remove: ");
                        int removeIndex = sc.nextInt();
                        if (removeIndex >= 0 && removeIndex < students.size()) {
                            students.remove(removeIndex);
                            System.out.println("Student removed successfully.");
                        } else {
                            System.out.println("Invalid index!");
                        }
                    }
                    break;

                case 5:
                    System.out.println("\nCurrent Student List:");
                    if (students.isEmpty())
                        System.out.println("(No students in the list)");
                    else
                        for (int j = 0; j < students.size(); j++)
                            System.out.println((j + 1) + ". " + students.get(j));
                    break;

                case 6:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 6);

        sc.close();
    }
} 