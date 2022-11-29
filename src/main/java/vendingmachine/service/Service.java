package vendingmachine.service;

import vendingmachine.Coin;
import vendingmachine.domain.Changes;
import vendingmachine.domain.Product;
import vendingmachine.domain.Products;
import vendingmachine.utils.Converter;
import vendingmachine.utils.Validator;

import java.util.EnumMap;
import java.util.List;
import java.util.stream.Collectors;

public class Service {
    Changes changes = new Changes(new EnumMap<>(Coin.class));
    Products products;

    public void createHoldingCoin(String holdingMoneyInput) {
        int holdingMoney = Converter.toIntFromString(holdingMoneyInput);
        changes.createRandomCoin(holdingMoney);
    }

    public List<String> getHoldingCoinResult() {
        return changes.getHoldingCoin();
    }

    public void createProducts(String productInput) {
        List<String> productInputs = Converter.parseProductInput(productInput);
        validateProductInputs(productInputs);
        List<List<String>> productDescriptions = Converter.parseProductDescriptions(productInputs);
        List<Product> products = productDescriptions.stream().
                map(Product::new)
                .collect(Collectors.toList());
        this.products = new Products(products);
    }

    private void validateProductInputs(List<String> productInputs) {
        productInputs.forEach(input -> {
            Validator.checkProductInputFormat(input);
            Validator.checkProductInputLength(input);
        });
    }
}
