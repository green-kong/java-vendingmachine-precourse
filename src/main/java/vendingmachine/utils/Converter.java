package vendingmachine.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Converter {
    public static int toIntFromString(String input) {
        try {
            return Integer.parseInt(input);
        } catch (IllegalArgumentException exception) {
            throw new IllegalArgumentException("숫자만 입력가능합니다.");
        }
    }

    public static List<String> parseProductInput(String productInput) {
        return Arrays.asList(productInput.split(";"));
    }

    public static List<List<String>> parseProductDescriptions(List<String> productInputs) {
        return productInputs.stream()
                .map(input -> {
                    input = input.replace("[", "");
                    input = input.replace("]", "");
                    return Arrays.asList(input.split(","));
                })
                .collect(Collectors.toList());
    }
}
