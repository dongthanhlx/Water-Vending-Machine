package Interfaces.Console.View;

import App.Application;
import App.Exceptions.AuthenticationRequiredException;
import App.Exceptions.Trading.MoneyNotEnoughException;
import Domain.Entities.*;
import App.Services.POSService;
import Interfaces.Console.Requests.Input;

import java.util.ArrayList;
import java.util.Scanner;


public class BuyView extends AbstractView {
    private POS pos;
    protected Account account;
    private Product product;
    private int amount;

    public BuyView(POS pos, Account account) {
        this.pos = pos;
        this.account = account;
    }

    @Override
    public void show() throws AuthenticationRequiredException {
        super.show();
    }

    @Override
    public void renderView() {
        do {
            this.showForm();
            this.setBuyItem();
        } while (!isPayScreen());
        this.executeBuy(this.product, this.amount);
    }

    public void showForm() {

        Input input = new Input();
        int itemIDMax = pos.numberItems() - 1;
        int productID = input.scan(
                "Product ID",
                new ArrayList<>() {
                    {
                        add("required");
                        add("numeric");
                        add(String.format("range:0,%s", itemIDMax));
                    }
                }
        ).toInt();

        int itemPOSMax = pos.getItems().get(productID).getQuantity();
        this.amount = input.scan(
                "Amount",
                 new ArrayList<>() {
                     {
                         add("required");
                         add("numeric");
                         add(String.format("range:0,%s", itemPOSMax));
                     }
                 }
        ).toInt();

        this.product = pos.getItems().get(productID).getProduct();
    }

    public void setBuyItem() {
        BuyItem buyItem = new BuyItem();
        buyItem.setProduct(product);
        buyItem.setCount(amount);
        account.addItem(buyItem);
        Application.session().setCurrentAccount(account);
    }

    public void executeBuy(Product product, int amount) {
        try {
            POSService posService = new POSService();
            posService.sell(pos, this.account, product, amount);
            posService.save();
        } catch (MoneyNotEnoughException e) {
            System.out.println("You don't enough money");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isPayScreen() {
        String isPay;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Do you want pay?(y/n): ");
        isPay = scanner.nextLine();

        return isPay.equals("y");
    }

}
