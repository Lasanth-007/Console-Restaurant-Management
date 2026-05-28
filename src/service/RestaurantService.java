package service;

import model.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RestaurantService {

    private List<Staff> staffList = new ArrayList<>();
    private List<Category> categories = new ArrayList<>();
    private List<MenuItem> menuItems = new ArrayList<>();
    private List<Order> orders = new ArrayList<>();

    // Add Staff
    public void addStaff(Staff staff) {
        staffList.add(staff);
    }

    // Add Category
    public void addCategory(Category category) {
        categories.add(category);
    }

    // Add Menu Item
    public void addMenuItem(String name, String description, double price, int categoryId) {
        Category category = categories.stream()
                .filter(c -> c.getId() == categoryId)
                .findFirst()
                .orElse(null);

        if (category != null) {
            menuItems.add(new MenuItem(name, description, price, category));
        }
    }

    // Show Menu
    public void showMenu() {
        System.out.println("\n=== Restaurant Menu ===");
        for (MenuItem item : menuItems) {
            if (item.isAvailable()) {
                System.out.printf("%d. %s - Rs. %.2f [%s]%n",
                        item.getId(), item.getName(), item.getPrice(),
                        item.getCategory().getName());
            }
        }
    }

    // Create Order
    public void createOrder(Scanner scanner) {
        System.out.print("Enter Table Number: ");
        int tableNumber = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Available Waiters:");
        for (int i = 0; i < staffList.size(); i++) {
            Staff s = staffList.get(i);
            if (s.canTakeOrder()) {
                System.out.println((i + 1) + ". " + s.getName() + " (" + s.getRole() + ")");
            }
        }

        System.out.print("Choose Waiter (number): ");
        int waiterIndex = scanner.nextInt() - 1;
        scanner.nextLine();

        Staff selectedWaiter = staffList.get(waiterIndex);

        Order order = new Order(selectedWaiter, tableNumber);

        while (true) {
            showMenu();
            System.out.print("Enter Menu Item ID (0 to finish): ");
            int itemId = scanner.nextInt();
            if (itemId == 0) break;

            System.out.print("Enter Quantity: ");
            int qty = scanner.nextInt();
            scanner.nextLine();

            MenuItem item = menuItems.stream()
                    .filter(m -> m.getId() == itemId)
                    .findFirst()
                    .orElse(null);

            if (item != null && item.isAvailable()) {
                order.addItem(item, qty);
                System.out.println("Item added!");
            } else {
                System.out.println("Invalid or unavailable item!");
            }
        }

        orders.add(order);
        System.out.println("\nOrder Created Successfully! Order ID: " + order.getId());
        System.out.println("Total Amount: Rs. " + order.getTotalAmount());
    }

    // Show All Orders
    public void showAllOrders() {
        System.out.println("\n=== All Orders ===");
        for (Order order : orders) {
            System.out.println("Order ID: " + order.getId() +
                    " | Table: " + order.getTableNumber() +
                    " | Waiter: " + order.getWaiter().getName() +
                    " | Status: " + order.getStatus() +
                    " | Total: Rs. " + order.getTotalAmount());
        }
    }
}