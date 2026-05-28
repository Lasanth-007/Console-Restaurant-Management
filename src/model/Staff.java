package model;

public class Staff extends Person {
    private String role; // WAITER, CHEF, MANAGER

    public Staff(String name, String phone, String role) {
        super(name, phone);
        this.role = role.toUpperCase();
    }

    @Override
    public String getRole() {
        return role;
    }

    public boolean canTakeOrder() {
        return "WAITER".equals(role) || "MANAGER".equals(role);
    }
}
