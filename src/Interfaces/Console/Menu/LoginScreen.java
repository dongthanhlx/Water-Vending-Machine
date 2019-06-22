package Interfaces.Console.Menu;

import Domain.Entities.Account;

import java.util.Scanner;

public class LoginScreen extends AbstractScreen{
    private Account account = new Account();


    public void displayOnScreen() {

    }

    public Account AccountInfo(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.println(email);
        account.setEmail(email);
        System.out.print("Password: ");
        account.setPassword(scanner.nextLine());
        return account;
    }

    public int screenLogined() {
        Scanner scanner = new Scanner(System.in);
        int select;

        System.out.println("1.  Menu");
        System.out.println("2.  See account balances");
        System.out.println("3.  See cart");
        System.out.println("4.  Buy");
        System.out.println("5.  Exit");
        System.out.print("Enter select(1-5) : ");
        select = scanner.nextInt();

        while (select < 1 && select > 5) {
            System.out.print("Enter select(1-5) : ");
            select = scanner.nextInt();
            continue;
        }
        return select;
    }


}
