package vendingmachine.utils;

public class Validator {
    public static void isAcceptableAmount(int money) {
        if (money % 10 != 0) {
            throw new IllegalArgumentException("10원 단위로 입력가능합니다.");
        }
    }
}
