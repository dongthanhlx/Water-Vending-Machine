package Domain.Entities;

public class POSItem {
    protected Product product;
    protected double quantity;

    public POSItem(){}

    public POSItem(Product product){
        this.product = product;
        product = new Product();
    }

    public POSItem(Product _product, double _quantity) {
        this.product = _product;
        this.quantity = _quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product _product) {
        this.product = _product;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double _quantity) {
        this.quantity = _quantity;
    }
}
