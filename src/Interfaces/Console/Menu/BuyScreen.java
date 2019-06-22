package Interfaces.Console.Menu;

import Domain.Entities.BuyItem;
import Domain.Entities.Cart;
import Domain.Entities.POS;
import java.util.Scanner;

public class BuyScreen extends AbstractScreen {
    POS pos;
    Cart cart;

    public BuyScreen(POS pos,Cart cart) {
        this.pos = pos;
        this.cart = cart;
    }

    public void displayOnScreen(){
        do {
            buyItemScreen();
        }while (!isPayScreen());
    }

    public void buyItemScreen(){
        Scanner scanner = new Scanner(System.in);
        int idItem;
        int amount;

        do {
            System.out.print("Enter id of item: ");
            idItem = scanner.nextInt();
        }while (idItem < 0 || idItem > (pos.numberItems() - 1));

        do {
            System.out.print("Enter amount : ");
            amount = scanner.nextInt();
        } while (amount < 0 || amount > pos.getItems().get(idItem).getQuantity());
        System.out.println("        Amount : "+pos.getItems().get(idItem).getQuantity());
        BuyItem buyItem = new BuyItem();
        buyItem.setProduct(this.pos.getItems().get(idItem).getProduct());
        buyItem.setCount(amount);
        cart.addItem(buyItem);
    }

    public boolean isPayScreen(){
        String isPay;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Do you want pay???(y/n): ");
            isPay = scanner.nextLine();
            if(isPay.equals("y"))   return true;
            else if(isPay.equals("n"))  return false;
        } while (true);
    }
}
