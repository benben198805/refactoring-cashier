package cn.xpbootcamp.refactoring;

import java.util.List;

public class Order {
    private static final String ORDER_HEADER = "======Printing Orders======\n";
    private static final char SEPARATOR = '\t';
    private final String customerName;
    private final String customerAddress;
    private final List<LineItem> lineItems;

    public Order(String customerName, String customerAddress, List<LineItem> lineItems) {
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.lineItems = lineItems;
    }

    private String getCustomerName() {
        return customerName;
    }

    private String getCustomerAddress() {
        return customerAddress;
    }

    private List<LineItem> getLineItems() {
        return lineItems;
    }

    private String stateHeader() {
        return ORDER_HEADER +
                getCustomerName() +
                getCustomerAddress();
    }

    public String state() {
        StringBuilder output = new StringBuilder(this.stateHeader());
        double totalSalesTax = 0d;
        double totalAmountWithTax = 0d;
        for (LineItem lineItem : getLineItems()) {
            output.append(lineItem.state());

            totalSalesTax += lineItem.getSalesTax();
            totalAmountWithTax += lineItem.getTotalAmountWithTax();
        }

        output.append(stateFooter(totalSalesTax, totalAmountWithTax));
        return output.toString();
    }

    private String stateFooter(double totalSalesTax, double totalAmountWithTax) {
        return "Sales Tax" + SEPARATOR + totalSalesTax +
                "Total Amount" + SEPARATOR + totalAmountWithTax;
    }

}
