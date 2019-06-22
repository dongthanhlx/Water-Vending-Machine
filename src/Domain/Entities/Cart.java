package Domain.Entities;

import java.util.ArrayList;

public class Cart {
    ArrayList<BuyItem> buyItems = new ArrayList<>();

    public Cart(){}

    public Cart(ArrayList<BuyItem> buyItems) {
        this.buyItems = buyItems;
    }

    public ArrayList<BuyItem> getBuyItems() {
        return buyItems;
    }

    public void setBuyItems(ArrayList<BuyItem> buyItems) {
        this.buyItems = buyItems;
    }

    public void addItem(BuyItem buyItem){
        this.buyItems.add(buyItem);
    }

    public void removeItem(BuyItem buyItem){
        this.buyItems.remove(buyItem);
    }

    public void seeItems(){
        int numberOfItems = buyItems.size();
        System.out.println("Items bought");
        System.out.println("-------------");
        for (int i=0; i < numberOfItems; i++){
            BuyItem buyItem = buyItems.get(i);
            System.out.println((i+1)+".     "+buyItem.getProduct().getName());
            System.out.println("Price: "+buyItem.getProduct().getPrice());
            System.out.println("Amount: "+buyItem.getCount());
            System.out.println("-------------");
        }
    }

    public double calculateTotalValueCart() {
        double totalValueCart = 0;
        int numberItems = buyItems.size();
        for (int i = 0; i < numberItems; i++) {
            BuyItem buyItem = buyItems.get(i);
            totalValueCart += buyItem.getProduct().getPrice() * buyItem.getCount();
        }
        return totalValueCart;
    }
}
