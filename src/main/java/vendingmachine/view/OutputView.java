package vendingmachine.view;

public class OutputView {
    private final static String ERROR_HEADER = "[ERROR]";

    public void printErrorMessage(String message) {
        System.out.println(ERROR_HEADER + message + "\n");
    }
}
