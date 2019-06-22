package Interfaces.Console.Menu;

import Domain.Entities.Account;

import java.util.ArrayList;
import java.util.Scanner;

public class RegisterScreen {
    Account account = new Account();

    public Account register(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("---------Register Account----------");
        System.out.print("Enter email: ");
        account.setEmail(scanner.nextLine());
        System.out.print("Enter password: ");
        account.setPassword(scanner.nextLine());
        System.out.print("Enter balance: ");
        account.setBalance(scanner.nextInt());
        return account;
    }

}
