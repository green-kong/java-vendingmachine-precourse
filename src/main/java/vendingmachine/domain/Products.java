package vendingmachine.domain;

import java.util.List;

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

    private Product getProductByName(String productName) {
            return products.stream()
                    .filter(productInfo -> productInfo.getName().equals(productName))
                    .findFirst()
                    .orElse(null);
    }
}
