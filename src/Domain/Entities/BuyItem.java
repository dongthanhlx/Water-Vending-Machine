package Domain.Entities;

import java.util.ArrayList;

public class BuyItem {
    private Product product;
    private int count;

    public BuyItem(){}

    public BuyItem(Product product, int count) {
        this.product = product;
        this.count = count;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
