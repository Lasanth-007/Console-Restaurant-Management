package model;

public class MenuItem {
    private static int idCounter = 1;
    private final int id;
    private String name;
    private String description;
    private double price;
    private Category category;
    private boolean available = true;

    public MenuItem(String name, String description, double price, Category category) {
        this.id = idCounter++;
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
    }

    public double calculateTotal(int quantity) {
        return price * quantity;
    }

    // Getters & Setters
    public int getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }
    public Category getCategory() {return category;}
}