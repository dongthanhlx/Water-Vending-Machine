package Domain.Entities;

import java.io.Serializable;
import java.util.ArrayList;

public class POS implements Serializable {
    private String name;
    private ArrayList<POSItem> items = new ArrayList<>();

    public POS(){}

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


    public void displayItems(){
        int totalItems = items.size();
        for(int i=0; i<totalItems; i++){
            System.out.println("------------------------");
            POSItem posItem = items.get(i);
            System.out.println("\tID: "+posItem.getProduct().getId());
            System.out.println("\tName: "+posItem.getProduct().getName());
            System.out.println("\tPrice: "+posItem.getProduct().getPrice());
            System.out.println("\tAmount "+posItem.getQuantity());
            System.out.println("------------------------");
        }
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
                    int balanceItemsInPOS = posItem.getQuantity() - buyItem.getCount();
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
