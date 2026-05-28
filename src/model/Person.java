package model;

public abstract class Person {
    protected String name;
    protected String phone;

    public Person(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public abstract String getRole();

    // Getters & Setters
    public String getName() { return name; }
    public String getPhone() { return phone; }
}
