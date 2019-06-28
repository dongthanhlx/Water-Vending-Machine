package Interfaces.Console.View;

import App.Exceptions.AuthenticationRequiredException;
import Domain.Entities.Account;
import Domain.Entities.BuyItem;

import java.util.ArrayList;

public class UserProfileView extends AbstractView{
    public Account account;

    public UserProfileView(Account account) {
        this.account = account;
    }

    @Override
    public void show() throws AuthenticationRequiredException {
        super.show();
    }

    @Override
    protected void renderView() {
        this.displayBalance();
        this.displayItemsBought();
    }

    public void displayBalance() {
        System.out.println(this.account.getEmail()+" has balance: "+this.account.getBalance());
    }

    public void displayItemsBought() {
        ArrayList<BuyItem> buyItems = this.account.getCart().getBuyItems();
        int numberOfItems = buyItems.size();
        System.out.println("Items bought");
        System.out.println("-------------");

        for (int i=0; i < numberOfItems; i++) {
            BuyItem buyItem = buyItems.get(i);
            System.out.println((i+1)+".     "+buyItem.getProduct().getName());
            System.out.println("Price: "+buyItem.getProduct().getPrice());
            System.out.println("Amount: "+buyItem.getCount());
            System.out.println("-------------");
        }

    }
}
