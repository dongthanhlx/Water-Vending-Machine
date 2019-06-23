package Interfaces.Console.Menu;

import Domain.Entities.*;

import java.util.Scanner;

public class BuyScreen extends AbstractScreen {
    protected POS pos;
    protected Account account;
    protected BuyItem buyItem = new BuyItem();

    public BuyScreen(POS pos, Account account) {
        this.pos = pos;
        this.account = account;
    }

    public POS getPos() {
        return pos;
    }

    public void setPos(POS pos) {
        this.pos = pos;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public BuyItem getBuyItem() {
        return buyItem;
    }

    public void setBuyItem(BuyItem buyItem) {
        this.buyItem = buyItem;
    }

    public void displayOnScreen(){
        do {
            buyItemScreen();
        }while (!isPayScreen());
    }

    public void buyItemScreen(){
        Scanner scanner = new Scanner(System.in);
        Product product ;
        int idItem;
        int amount;
        do {
            System.out.print("Enter id of item: ");
            idItem = scanner.nextInt();
            product = pos.getItems().get(idItem).getProduct();
        }while (idItem < 0 || idItem > (pos.numberItems() - 1));

        do {
            System.out.print("Enter amount : ");
            amount = scanner.nextInt();
            buyItem.setCount(amount);
        } while (amount < 0 || amount > pos.getItems().get(idItem).getQuantity());
        buyItem.setProduct(product);
        account.addItem(buyItem);
    }

    public void seeItemsBought(){
        int numberOfItems = account.getCart().getBuyItems().size();

        for (int i=0; i<numberOfItems; i++){
            BuyItem buyItem = account.getCart().getBuyItems().get(i);
            System.out.println((i+1)+"\t"+buyItem.getProduct().getName());
            System.out.println("Count: "+buyItem.getCount());
        }

    }

    public boolean isPayScreen(){
        String isPay;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Do you want pay???(y/n): ");
        isPay = scanner.nextLine();

        return isPay.equals("y");
    }
}
