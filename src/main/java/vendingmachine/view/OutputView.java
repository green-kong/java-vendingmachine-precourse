package vendingmachine.view;

import java.util.List;

public class OutputView {
    private final static String ERROR_HEADER = "[ERROR]";

    public void printErrorMessage(String message) {
        System.out.println(ERROR_HEADER + message + "\n");
    }

    public void printHoldingCoin(List<String> holdingCoins) {
        System.out.println("\n자판기가 보유한 동전");
        holdingCoins.forEach(System.out::println);
    }

    public void printDeposit(String depositResult) {
        System.out.println(depositResult);
    }

    public void printChangeResult(List<String> changeResults){
        System.out.println("잔돈");
        changeResults.forEach(System.out::println);
    }
}
