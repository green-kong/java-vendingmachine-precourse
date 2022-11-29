package vendingmachine;

import vendingmachine.service.Service;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class Controller {
    private final Service service = new Service();
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

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
        try {
            String holdingMoneyInput = inputView.getHoldingMoneyInput();
            service.createHoldingCoin(holdingMoneyInput);
        } catch (IllegalArgumentException exception) {
            outputView.printErrorMessage(exception.getMessage());
            setHoldingMoney();
        }
    }
}
