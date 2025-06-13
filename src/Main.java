
import java.util.List;
import java.util.Scanner;
import model.User;
import service.UserService;
import service.UserServiceImpl;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UserService userService = new UserServiceImpl();

        //Sammple data starts
        userService.addUser("Arunagiri", "arunagiri1234@example.com", 1);
        userService.addUser("Boomika", "boomika@example.com", 2);
        userService.addUser("Rohit", "rohit984@example.com", 3);
        //Sample data ends

        while (true) {
            System.out.println("======= User Management System =======");
            System.out.println("1. Add User\n2. View All Users\n3. Update User\n4. Delete User\n5. Exit");
            System.out.print("Enter your choice: ");
            int choice;
            if(sc.hasNextInt()){
                choice = sc.nextInt();
                sc.nextLine(); // Consume the newline character left by nextInt
            }else{
                System.out.println("\nInvalid input! Please enter a number between 1 and 5.");
                sc.nextLine(); // Consume the newline character left by nextInt
                continue; // Restart the loop
            }

            switch (choice) {
                case 1 -> {
                    System.out.println("\nAdding a new user...");

                    System.out.print("Enter user name: ");
                    String userName = sc.nextLine();

                    System.out.print("Enter user email: ");
                    String userEmail = sc.nextLine();

                    System.out.print("Enter user RollNo: ");
                    int userRollNo = sc.nextInt();
                    sc.nextLine(); // Consume the newline character left by nextInt

                    User user = userService.addUser(userName, userEmail, userRollNo);
                    if (user != null) {
                        System.out.println("\nUser added successfully: " + user);
                    } else {
                        System.out.println("\nFailed to add user. Please try again.");
                    }
                }
                case 2 -> {
                    System.out.println("\nViewing all users...");
                    List<User> users = userService.getAllUsers();
                    if (users.isEmpty()) {
                        System.out.println("\nNo users found.");
                    } else {
                        System.out.println();
                        for (User user : users) {
                            System.out.println(user);
                        }
                    }
                }
                case 3 -> {
                    System.out.print("\nEnter user RollNo to update: ");
                    int userRollNo = sc.nextInt();
                    sc.nextLine(); // Consume the newline character left by nextInt

                    System.out.print("Enter new name: ");
                    String newName = sc.nextLine();

                    System.out.print("Enter new email: ");
                    String newEmail = sc.nextLine();

                    if (userService.updateUser(userRollNo, newName, newEmail)) {
                        System.out.println("\nUser updated successfully.");
                    } else {
                        System.out.println("\nUser not found or update failed.");
                    }

                }
                case 4 -> {
                    System.out.print("\nEnter user RollNo to delete: ");
                    int userRollNo = sc.nextInt();
                    sc.nextLine(); // Consume the newline character left by nextInt
                    
                    if (userService.deleteUser(userRollNo)) {
                        System.out.println("\nUser deleted successfully.");
                    } else {
                        System.out.println("\nUser not found or deletion failed.");
                    }
                }
                case 5 -> {
                    System.out.println("\n-----Exiting-----------\nThank you for using our service!");
                    sc.close();
                    return;
                }
                default ->
                    System.out.println("\nInvalid choice!");
            }

            System.out.print("\nPress Enter to continue...");
            sc.nextLine();
        }
    }
}
