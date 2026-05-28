import model.*;
import service.RestaurantService;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RestaurantService service = new RestaurantService();

        // === Sample Data ===
        service.addStaff(new Staff("Kasun Perera", "0771234567", "WAITER"));
        service.addStaff(new Staff("Nimal Fernando", "0712345678", "MANAGER"));
        service.addStaff(new Staff("Sunil Silva", "0759876543", "CHEF"));

        service.addCategory(new Category("Main Course"));
        service.addCategory(new Category("Pizza"));
        service.addCategory(new Category("Beverages"));

        service.addMenuItem("Chicken Biryani", "Spicy basmati rice", 650.0, 1);
        service.addMenuItem("Butter Chicken", "Creamy tomato curry", 780.0, 1);
        service.addMenuItem("Margherita Pizza", "Classic cheese pizza", 1250.0, 2);
        service.addMenuItem("Mango Lassi", "Fresh mango yogurt", 280.0, 3);
        service.addMenuItem("Coca Cola", "Cold beverage", 180.0, 3);

        System.out.println("=== Welcome to Restaurant Management System ===\n");

        while (true) {
            System.out.println("1. Show Menu");
            System.out.println("2. Create New Order");
            System.out.println("3. Show All Orders");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> service.showMenu();
                case 2 -> service.createOrder(scanner);
                case 3 -> service.showAllOrders();
                case 4 -> {
                    System.out.println("Thank you for using the system!");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }
}