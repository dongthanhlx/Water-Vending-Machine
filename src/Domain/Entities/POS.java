package Domain.Entities;

import java.io.Serializable;
import java.util.ArrayList;

public class POS implements Serializable {
    private int id;
    private String name;
    private ArrayList<POSItem> items = new ArrayList<>();

    public POS(){}

    public POS(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int numberItems() {
        return items.size();
    }

    public void removeItems(Product product, int amount) {
        int numberItemsInPOS = items.size();

        for (int i=0; i<numberItemsInPOS; i++) {
            POSItem posItem = items.get(i);

            if(posItem.getProduct().getId() == product.getId()) {
                int balanceItemInPOS = posItem.getQuantity() - amount;
                items.get(i).setQuantity(balanceItemInPOS);
            }
        }
    }

}
