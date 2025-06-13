package utility;

import java.util.Scanner;

public class menu_Utility {

    Scanner sc = new Scanner(System.in);

    public int display() {
        System.out.println("\n======= User Management System =======");
        System.out.println("1. Add User\n2. View All Users\n3. Update User\n4. Delete User\n5. Exit");
        System.out.print("Enter your choice: ");
        int choice;
        if (sc.hasNextInt()) {
            choice = sc.nextInt();
            sc.nextLine(); // Consume the newline character left by nextInt
        } else {
            System.out.println("\nInvalid input! Please enter a number between 1 and 5.");
            sc.nextLine(); // Consume the newline character left by nextInt
            choice = 0;
        }
        return choice;
    }
}
