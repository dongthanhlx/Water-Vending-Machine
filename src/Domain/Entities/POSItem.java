package Domain.Entities;

import java.io.Serializable;

public class POSItem implements Serializable {
    protected Product product;
    protected int quantity;

    public POSItem(){}

    public POSItem(Product product){
        this.product = product;
        product = new Product();
    }

    public POSItem(Product _product, int _quantity) {
        this.product = _product;
        this.quantity = _quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product _product) {
        this.product = _product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int _quantity) {
        this.quantity = _quantity;
    }
}
