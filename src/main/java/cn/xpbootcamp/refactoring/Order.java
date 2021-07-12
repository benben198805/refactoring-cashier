package cn.xpbootcamp.refactoring;

import java.util.List;

public class Order {
    String customerName;
    String customerAddress;
    List<LineItem> lineItems;

    public Order(String customerName, String customerAddress, List<LineItem> lineItems) {
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.lineItems = lineItems;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public List<LineItem> getLineItems() {
        return lineItems;
    }

    private String stateHeader() {
        return "======Printing Orders======\n" +
                getCustomerName() +
                getCustomerAddress();
    }

    String state() {
        StringBuilder output = new StringBuilder(this.stateHeader());
        double totalSalesTax = 0d;
        double totalAmountWithTax = 0d;
        for (LineItem lineItem : getLineItems()) {
            output.append(lineItem.state());

            totalSalesTax += lineItem.getSalesTax();
            totalAmountWithTax += lineItem.getTotalAmountWithTax();
        }

        stateFooter(output, totalSalesTax, totalAmountWithTax);
        return output.toString();
    }

    private void stateFooter(StringBuilder output, double totalSalesTax, double totalAmountWithTax) {
        output.append("Sales Tax").append('\t').append(totalSalesTax);
        output.append("Total Amount").append('\t').append(totalAmountWithTax);
    }

}
