package cn.xpbootcamp.refactoring;

public class LineItem {
    public static final char SPERATOR = '\t';
    private String description;
    private double price;
    private int quantity;

    public LineItem(String description, double price, int quantity) {
        super();
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    double totalAmount() {
        return price * quantity;
    }

    double getSalesTax() {
        return totalAmount() * .10;
    }

    double getTotalAmountWithTax() {
        return totalAmount() + getSalesTax();
    }

    String state() {
        return getDescription() +
                SPERATOR +
                getPrice() +
                SPERATOR +
                getQuantity() +
                SPERATOR +
                totalAmount() +
                '\n';
    }
}
