package Interfaces.Console.View;

import App.Exceptions.AuthenticationRequiredException;
import Domain.Entities.POS;
import Domain.Entities.POSItem;

import java.util.ArrayList;

public class POSView extends AbstractView {

    private POS pos;

    public POSView(POS pos) {
        this.pos = pos;
    }

    @Override
    public void show() throws AuthenticationRequiredException {
        super.show();
    }

    @Override
    public void renderView() {
        this.displayItems();
    }

    public void displayItems() {
        ArrayList<POSItem> items = this.pos.getItems();
        int totalItems = items.size();
        for(int i=0; i<totalItems; i++) {

            System.out.println("------------------------");
            POSItem posItem = items.get(i);
            System.out.println("\tID: "+posItem.getProduct().getId());
            System.out.println("\tName: "+posItem.getProduct().getName());
            System.out.println("\tPrice: "+posItem.getProduct().getPrice());
            System.out.println("\tAmount "+posItem.getQuantity());
            System.out.println("------------------------");

        }
    }
}
