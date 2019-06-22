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
}
