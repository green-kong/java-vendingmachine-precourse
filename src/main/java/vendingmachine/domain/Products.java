package vendingmachine.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Products {
    List<Product> products;

    public Products(List<Product> products) {
        this.products = products;
    }

    public int getProductPrice(String productName) {
        try {
            Product product = getProductByName(productName);
            return product.getPrice();
        } catch (NullPointerException exception) {
            throw new IllegalArgumentException("존재하지 않는 제품명입니다.");
        }
    }

    public void sell(String productName) {
        Product product = getProductByName(productName);
        product.sell();
    }

    public boolean checkAffordability(int deposit) {
        List<Product> purchasableProducts = products.stream()
                .filter(product -> product.getPrice() <= deposit)
                .collect(Collectors.toList());
        return purchasableProducts.size() > 0;
    }

    private Product getProductByName(String productName) {
        return products.stream()
                .filter(productInfo -> productInfo.getName().equals(productName))
                .findFirst()
                .orElse(null);
    }
}
