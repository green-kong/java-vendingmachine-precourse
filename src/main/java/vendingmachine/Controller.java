package vendingmachine;

import vendingmachine.service.Service;
import vendingmachine.view.InputView;

public class Controller {
    private final Service service = new Service();
    private final InputView inputView = new InputView();

    public void run() {
        setVendingMachine();
        purchaseProduct();
        getChanges();
    }

    private void setVendingMachine() {
        setHoldingMoney();
    }

    private void purchaseProduct() {

    }

    private void getChanges() {

    }

    private void setHoldingMoney() {
        String holdingMoneyInput = inputView.getHoldingMoneyInput();
        service.createHoldingCoin(holdingMoneyInput);
    }
}
