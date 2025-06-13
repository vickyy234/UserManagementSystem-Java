
import java.util.List;
import java.util.Scanner;
import model.User;
import service.UserService;
import service.UserServiceImpl;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UserService userService = new UserServiceImpl();

        while (true) {
            System.out.println("======= User Management System =======");
            System.out.println("1. Add User\n2. View All Users\n3. Update User\n4. Delete User\n5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // Consume the newline character left by nextInt

            switch (choice) {
                case 1 -> {
                    System.out.println("Adding a new user...");

                    System.out.print("Enter user name: ");
                    String userName = sc.nextLine();

                    System.out.print("Enter user email: ");
                    String userEmail = sc.nextLine();

                    System.out.print("Enter user RollNo: ");
                    int userRollNo = sc.nextInt();

                    User user = userService.addUser(userName, userEmail, userRollNo);
                    if (user != null) {
                        System.out.println("User added successfully: " + user);
                    } else {
                        System.out.println("Failed to add user. Please try again.");
                    }
                }
                case 2 -> {
                    System.out.println("Viewing all users...");
                    List<User> users = userService.getAllUsers();
                    if (users.isEmpty()) {
                        System.out.println("No users found.");
                    } else {
                        for (User user : users) {
                            System.out.println(user);
                        }
                    }
                }
                case 3 -> {
                    System.out.print("Enter user RollNo to update: ");
                    int userRollNo = sc.nextInt();
                    sc.nextLine(); // Consume the newline character left by nextInt

                    System.out.print("Enter new name: ");
                    String newName = sc.nextLine();

                    System.out.print("Enter new email: ");
                    String newEmail = sc.nextLine();

                    if (userService.updateUser(userRollNo, newName, newEmail)) {
                        System.out.println("User updated successfully.");
                    } else {
                        System.out.println("User not found or update failed.");
                    }

                }
                case 4 -> {
                    System.out.print("Enter user RollNo to delete: ");
                    int userRollNo = sc.nextInt();
                    if (userService.deleteUser(userRollNo)) {
                        System.out.println("User deleted successfully.");
                    } else {
                        System.out.println("User not found or deletion failed.");
                    }
                }
                case 5 -> {
                    System.out.println("-----Exiting-----------\nThank you for using our service");
                    sc.close();
                    return;
                }
                default ->
                    System.out.println("Invalid choice!");
            }
        }
    }
}
