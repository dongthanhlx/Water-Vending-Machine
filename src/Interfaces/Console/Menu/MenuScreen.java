package Interfaces.Console.Menu;

import Domain.Entities.Account;
import Domain.Entities.POS;
import Domain.Entities.POSItem;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuScreen extends AbstractScreen {
    private POS pos;
    private ArrayList<Account> accounts;
    public MenuScreen(POS pos) {
        this.pos = pos;
    }

    public POS getPos() {
        return pos;
    }

    public void setPos(POS pos) {
        this.pos = pos;
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(ArrayList<Account> accounts) {
        this.accounts = accounts;
    }

    public void displayOnScreen(){
        displayItems();
    }

    public void displayItems(){
        ArrayList<POSItem> posItems = pos.getItems();
        int totalItems = posItems.size();
        for(int i=0; i<totalItems; i++){
            System.out.println("------------------------");
            POSItem posItem = posItems.get(i);
            System.out.println("\tID: "+posItem.getProduct().getId());
            System.out.println("\tName: "+posItem.getProduct().getName());
            System.out.println("\tPrice: "+posItem.getProduct().getPrice());
            System.out.println("\tAmount "+posItem.getQuantity());
            System.out.println("------------------------");
        }
    }

    public void displayAccounts(){
        accounts.forEach((account) -> {
            System.out.println("------------------------");
            System.out.println("\tID: "+account.getId());
            System.out.println("\tEmail: "+account.getEmail());
            System.out.println("\tPassword: "+account.getPassword());
            System.out.println("\tBalance: "+account.getBalance());
            System.out.println("------------------------");
        });
    }


}
