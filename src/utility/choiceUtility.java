package utility;

import java.util.List;
import java.util.Scanner;
import model.User;
import service.UserService;
import service.UserServiceImpl;

public class choiceUtility {

    public choiceUtility(){
        //Sammple data starts
        service.addUser("Arunagiri", "arunagiri1234@example.com", 1);
        service.addUser("Boomika", "boomika@example.com", 2);
        service.addUser("Rohit", "rohit984@example.com", 3);
        //Sample data ends
    }

    UserService service = new UserServiceImpl();
    Scanner sc = new Scanner(System.in);

    public void addUser() {
        System.out.println("\nAdding a new user...");

        System.out.print("Enter user name: ");
        String userName = sc.nextLine();

        System.out.print("Enter user email: ");
        String userEmail = sc.nextLine();

        System.out.print("Enter user RollNo: ");
        int userRollNo = sc.nextInt();
        sc.nextLine(); // Consume the newline character left by nextInt

        User user = service.addUser(userName, userEmail, userRollNo);
        if (user != null) {
            System.out.println("\nUser added successfully: " + user);
        } else {
            System.out.println("\nFailed to add user. Please try again.");
        }
    }

    public void getAllUsers() {
        System.out.println("\nViewing all users...");
        List<User> users = service.getAllUsers();

        if (users.isEmpty()) {
            System.out.println("\nNo users found.");
        } else {
            System.out.println();
            for (User user : users) {
                System.out.println(user);
            }
        }
    }

    public void updateUser() {
        System.out.print("\nEnter user RollNo to update: ");
        int userRollNo = sc.nextInt();
        sc.nextLine(); // Consume the newline character left by nextInt

        System.out.print("Enter new name: ");
        String newName = sc.nextLine();

        System.out.print("Enter new email: ");
        String newEmail = sc.nextLine();

        if (service.updateUser(userRollNo, newName, newEmail)) {
            System.out.println("\nUser updated successfully.");
        } else {
            System.out.println("\nUser not found or update failed.");
        }
    }

    public void deletUser() {
        System.out.print("\nEnter user RollNo to delete: ");
        int userRollNo = sc.nextInt();
        sc.nextLine(); // Consume the newline character left by nextInt

        if (service.deleteUser(userRollNo)) {
            System.out.println("\nUser deleted successfully.");
        } else {
            System.out.println("\nUser not found or deletion failed.");
        }
    }

    public void exit() {
        System.out.println("\n-----Exiting-----------\nThank you for using our service!");
        sc.close();
        System.exit(0);
    }
}
