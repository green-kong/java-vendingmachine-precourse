package vendingmachine.utils;

public class Converter {
    public static int toIntFromString(String input) {
        try {
            return Integer.parseInt(input);
        } catch (IllegalArgumentException exception) {
            throw new IllegalArgumentException("숫자만 입력가능합니다.");
        }
    }
}
