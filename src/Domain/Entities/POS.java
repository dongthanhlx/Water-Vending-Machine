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


    public void removeItems(Product product, int amount){
        int numberItemsInPOS = items.size();

        for (int i=0; i<numberItemsInPOS; i++){
            POSItem posItem = items.get(i);

            if(posItem.getProduct().getId() == product.getId()){
                int balanceItemInPOS = posItem.getQuantity() - amount;
                items.get(i).setQuantity(balanceItemInPOS);
            }

        }

    }
}
