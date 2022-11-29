package vendingmachine.domain;

public class VendingMachine {
    private final Changes changes;
    private final Products products;
    private int deposit;

    public VendingMachine(Changes changes, Products products) {
        this.changes = changes;
        this.products = products;
    }
}
