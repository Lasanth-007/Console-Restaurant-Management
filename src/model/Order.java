package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private static int idCounter = 1;
    private final int id;
    private final Staff waiter;
    private final int tableNumber;
    private List<OrderItem> items = new ArrayList<>();
    private String status = "PENDING";
    private LocalDateTime orderTime;

    public Order(Staff waiter, int tableNumber) {
        this.id = idCounter++;
        this.waiter = waiter;
        this.tableNumber = tableNumber;
        this.orderTime = LocalDateTime.now();
    }

    public void addItem(MenuItem menuItem, int quantity) {
        items.add(new OrderItem(menuItem, quantity));
    }

    public double getTotalAmount() {
        return items.stream().mapToDouble(OrderItem::getSubtotal).sum();
    }

    // Getters
    public int getId() { return id; }
    public List<OrderItem> getItems() { return items; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public int getTableNumber() {return tableNumber;}
    public Staff getWaiter() {return waiter;}
}