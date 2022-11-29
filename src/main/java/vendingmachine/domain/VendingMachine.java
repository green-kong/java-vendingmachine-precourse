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

    public void validateDepositAmount(int depositAmount) {
        Validator.isAcceptableAmount(depositAmount);
    }

    public String getDeposit() {
        return String.format("\n투입금액: %d원", this.deposit);
    }
}
