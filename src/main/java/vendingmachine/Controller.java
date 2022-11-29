package vendingmachine;

import vendingmachine.view.InputView;

public class Controller {
    private final InputView inputView = new InputView();
    public void run() {
        setVendingMachine();
        purchaseProduct();
        getChanges();
    }

    private void setVendingMachine() {

    }

    private void purchaseProduct() {

    }

    private void getChanges() {

    }

    private void setHoldingMoney() {
        String holdingMoneyInput = inputView.getHoldingMoneyInput();
    }
}
