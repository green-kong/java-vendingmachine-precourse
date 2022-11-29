package vendingmachine.domain;

import vendingmachine.utils.Converter;
import vendingmachine.utils.Validator;

import java.util.List;

public class Product {
    private final String name;
    private final int price;
    private final int count;

    public Product(List<String> productDescription) {
        String name = productDescription.get(0);
        int price = Converter.toIntFromString(productDescription.get(1));
        int count = Converter.toIntFromString(productDescription.get(2));
        validate(price);
        this.name = name;
        this.price = price;
        this.count = count;
    }

    private void validate(int price) {
        Validator.isAcceptableAmount(price);
    }
}