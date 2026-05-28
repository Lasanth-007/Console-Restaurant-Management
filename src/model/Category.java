package model;

public class Category {
    private static int idCounter = 1;
    private final int id;
    private String name;

    public Category(String name) {
        this.id = idCounter++;
        this.name = name;
    }

    public int getId() { return id; }
    public String getName() { return name; }

    @Override
    public String toString() {
        return id + ". " + name;
    }
}