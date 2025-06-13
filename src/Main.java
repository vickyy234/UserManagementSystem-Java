
import java.util.Scanner;
import utility.choiceUtility;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        choiceUtility util = new choiceUtility();

        while (true) {
            System.out.println("======= User Management System =======");
            System.out.println("1. Add User\n2. View All Users\n3. Update User\n4. Delete User\n5. Exit");
            System.out.print("Enter your choice: ");
            int choice;
            if (sc.hasNextInt()) {
                choice = sc.nextInt();
                sc.nextLine(); // Consume the newline character left by nextInt
            } else {
                System.out.println("\nInvalid input! Please enter a number between 1 and 5.");
                sc.nextLine(); // Consume the newline character left by nextInt
                continue; // Restart the loop
            }

            switch (choice) {
                case 1 -> {
                    util.addUser();
                }
                case 2 -> {
                    util.getAllUsers();
                }
                case 3 -> {
                    util.updateUser();
                }
                case 4 -> {
                    util.deletUser();
                }
                case 5 -> {
                    util.exit();
                }
                default ->
                    System.out.println("\nInvalid choice!");
            }

            System.out.print("\nPress Enter to continue...");
            sc.nextLine();
        }
    }
}
