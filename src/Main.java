
import java.util.Scanner;
import utility.choiceUtility;
import utility.menu_Utility;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        choiceUtility util = new choiceUtility();
        menu_Utility menu = new menu_Utility();

        while (true) {

            int choice = menu.display();
            if (choice == 0) { // Invalid choice input
                continue; //Restart loop 
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
