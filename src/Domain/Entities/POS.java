package Domain.Entities;

import java.util.ArrayList;

public class POS {
    private String name;
    private ArrayList<POSItem> items = new ArrayList<>();

    public POS(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<POSItem> getItems() {
        return items;
    }

    public void setItems(ArrayList<POSItem> items) {
        this.items = items;
    }

    public void addItem(POSItem item) {
        this.items.add(item);
    }

    public int numberItems(){
        return items.size();
    }

    public boolean removeItems(Cart cart) {
        ArrayList<BuyItem> buyItems = cart.getBuyItems();
        int numberBuyItems = buyItems.size();
        int numberItemsInPOS = items.size();
        for (int i = 0; i < numberBuyItems; i++) {
            BuyItem buyItem = buyItems.get(i);
            for (int j = 0; j < numberItemsInPOS; j++) {
                POSItem posItem = items.get(j);
                if (posItem.getProduct().getId() == buyItem.getProduct().getId()) {
                    double balanceItemsInPOS = posItem.getQuantity() - buyItem.getCount();
                    if (balanceItemsInPOS >= 0) {
                        items.get(j).setQuantity(balanceItemsInPOS);
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
