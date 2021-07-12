package cn.xpbootcamp.refactoring;

public class LineItem {
    private static final char SEPARATOR = '\t';
    private final String description;
    private final double price;
    private final int quantity;

    public LineItem(String description, double price, int quantity) {
        super();
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    private String getDescription() {
        return description;
    }

    private double getPrice() {
        return price;
    }

    private int getQuantity() {
        return quantity;
    }

    private double totalAmount() {
        return price * quantity;
    }

    public double getSalesTax() {
        return totalAmount() * .10;
    }

    public double getTotalAmountWithTax() {
        return totalAmount() + getSalesTax();
    }

    public String state() {
        return getDescription() +
                SEPARATOR +
                getPrice() +
                SEPARATOR +
                getQuantity() +
                SEPARATOR +
                totalAmount() +
                '\n';
    }
}
