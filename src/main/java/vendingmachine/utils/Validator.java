package vendingmachine.utils;

public class Validator {
    public static void isAcceptableAmount(int money) {
        if (money % 10 != 0) {
            throw new IllegalArgumentException("10원 단위로 입력가능합니다.");
        }
    }

    public static void checkProductInputFormat(String productInput) {
        String[] inputs = productInput.split("");
        if (!inputs[0].equals("[") || !inputs[inputs.length - 1].equals("]")) {
            throw new IllegalArgumentException("제품의 상세내용을 [] 안에 입력해주세요.");
        }
    }

    public static void checkProductInputLength(String productInput) {
        String[] inputs = productInput.split(",");
        if(inputs.length != 3) {
            throw new IllegalArgumentException("제품명, 가격, 수량을 입력해주세요.");
        }

    }
}
