package Interfaces.Console.View;

import App.Application;
import App.Exceptions.AuthenticationRequiredException;
import Domain.Entities.Account;
import Domain.Entities.POS;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AfterLoginView extends AbstractView {
    private POS pos;
    public int select;

    public AfterLoginView(Account account) {
        this.pos = (POS) (Application.entityManager().read(POS.class)).get(0);
        Application.session().setCurrentAccount(account);
    }

    @Override
    public void show() throws AuthenticationRequiredException {
        super.show();
        this.execute();
    }

    @Override
    public void renderView() {
        this.menu();
    }

    public void menu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("1.  View products");
        System.out.println("2.  See account balances");
        System.out.println("3.  See cart");
        System.out.println("4.  Buy");
        System.out.println("5.  Exit");
        System.out.print("Enter select(1-5) : ");

        this.select = scanner.nextInt();

        while (this.select < 1 && this.select > 5) {
            System.out.print("Enter select(1-5) : ");
            this.select = scanner.nextInt();
        }

    }

    public void execute() {
        Account currentAccount = Application.session().getCurrentAccount();
        Map<Integer, AbstractView> menuViews = new HashMap<>();
        menuViews.put(1, new POSView(pos));
        menuViews.put(2, new UserProfileView(currentAccount));
        menuViews.put(3, new UserProfileView(currentAccount));
        menuViews.put(4, new BuyView(pos, currentAccount));
        menuViews.put(5, new ExitView());
        if(select == menuViews.size()) return;
        while(select < menuViews.size()) {
            try {
                menuViews.get(select).show();
            } catch (AuthenticationRequiredException e) {
                System.out.println("Authentication required");
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.menu();
        }
    }

}
