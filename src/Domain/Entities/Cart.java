package Domain.Entities;

import java.io.Serializable;
import java.util.ArrayList;

public class Cart implements Serializable {
    ArrayList<BuyItem> buyItems = new ArrayList<>();

    public Cart() {
    }

    public Cart(ArrayList<BuyItem> buyItems) {
        this.buyItems = buyItems;
    }

    public ArrayList<BuyItem> getBuyItems() {
        return buyItems;
    }

    public void setBuyItems(ArrayList<BuyItem> buyItems) {
        this.buyItems = buyItems;
    }

    public void addItem(BuyItem buyItem) {
        this.buyItems.add(buyItem);
    }

    public void removeItem(BuyItem buyItem) {
        this.buyItems.remove(buyItem);
    }

}
