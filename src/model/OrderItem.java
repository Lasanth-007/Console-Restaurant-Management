package model;

public class OrderItem {
    private final MenuItem menuItem;
    private final int quantity;
    private final double subtotal;

    public OrderItem(MenuItem menuItem, int quantity) {
        this.menuItem = menuItem;
        this.quantity = quantity;
        this.subtotal = menuItem.calculateTotal(quantity);
    }

    public double getSubtotal() {
        return subtotal;
    }

    @Override
    public String toString() {
        return menuItem.getName() + " x " + quantity + " = Rs. " + subtotal;
    }
}