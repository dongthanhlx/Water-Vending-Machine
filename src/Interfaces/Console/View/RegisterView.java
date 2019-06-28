package Interfaces.Console.View;

import App.Application;
import App.Exceptions.AccountRegisteredException;
import App.Exceptions.AuthenticationRequiredException;
import Domain.Entities.Account;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RegisterView extends AbstractView {
    protected Account account = new Account();

    private void showRegistrationForm() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("---------Register Account----------");
        System.out.print("Enter email: ");
        account.setEmail(scanner.nextLine());

        System.out.print("Enter password: ");
        account.setPassword(scanner.nextLine());

        System.out.print("Enter balance: ");
        account.setBalance(scanner.nextInt());
    }

    @Override
    public void show() throws AuthenticationRequiredException {
        super.show();
    }

    @Override
    public void renderView() {
        this.showRegistrationForm();
        try {
            this.doRegister();
        } catch (AccountRegisteredException e){
            System.out.print("The Account registered");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void doRegister() throws AccountRegisteredException{
        List<Account> accounts = Application.entityManager().read(Account.class);

        if(account.existsAccount(accounts) >= 0) {
            throw new AccountRegisteredException();
        }

        int numberAccount;
        if (accounts == null) {
            numberAccount = 0;
            accounts = new ArrayList<>();
        } else {
            numberAccount = accounts.size();
        }

        account.setId(numberAccount);
        accounts.add(account);

        Application.entityManager().write(Account.class, accounts);
    }

}
