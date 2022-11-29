package vendingmachine;

import vendingmachine.service.Service;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

import java.util.List;

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
        printHoldingCoin();
        setProducts();
    }

    private void purchaseProduct() {
        depositMoney();
        selectProduct();
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

    private void printHoldingCoin() {
        List<String> holdingCoinResult = service.getHoldingCoinResult();
        outputView.printHoldingCoin(holdingCoinResult);
    }

    private void setProducts() {
        try {
            String productsInput = inputView.getProductsInput();
            service.createProducts(productsInput);
        } catch (IllegalArgumentException exception) {
            outputView.printErrorMessage(exception.getMessage());
            setProducts();
        }
    }

    private void depositMoney() {
        try {
            String depositInput = inputView.getDepositInput();
            service.depositMoney(depositInput);
        } catch (IllegalArgumentException exception) {
            outputView.printErrorMessage(exception.getMessage());
            depositMoney();
        }
    }

    private void selectProduct() {
        printDeposit();
    }

    private void printDeposit() {
        String deposit = service.getDeposit();
        outputView.printDeposit(deposit);
    }
}
