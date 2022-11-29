package vendingmachine.domain;

import vendingmachine.utils.Validator;

public class VendingMachine {
    private final Changes changes;
    private final Products products;
    private int deposit;

    public VendingMachine(Changes changes, Products products) {
        this.changes = changes;
        this.products = products;
    }

    public void depositMoney(int depositAmount) {
        validateDepositAmount(depositAmount);
        this.deposit = depositAmount;
    }

    public String getDeposit() {
        return String.format("\n투입금액: %d원", this.deposit);
    }

    public void purchase(String productName) {
        int productPrice = products.getProductPrice(productName);
        checkDeposit(productPrice);
        products.sell(productName);
        deposit -= productPrice;
    }

    public boolean checkAffordability() {
        return products.checkAffordability(deposit);
    }

    private void validateDepositAmount(int depositAmount) {
        Validator.isAcceptableAmount(depositAmount);
    }

    private void checkDeposit(int productPrice) {
        if (productPrice > deposit) {
            throw new IllegalArgumentException("투입금액이 모자랍니다.");
        }
    }
}
