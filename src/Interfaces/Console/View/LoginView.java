package Interfaces.Console.View;

import App.Application;
import App.Exceptions.AccountHasNotRegister;
import App.Exceptions.AuthenticationRequiredException;
import Domain.Entities.Account;


import java.util.List;
import java.util.Scanner;

public class LoginView extends AbstractView {
    private Account account = new Account();

    private void showForm() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Email: ");
        account.setEmail(scanner.nextLine());

        System.out.print("Password: ");
        account.setPassword(scanner.nextLine());
    }

    @Override
    public void show() throws AuthenticationRequiredException {
        super.show();
    }

    @Override
    public void renderView() {
        this.showForm();
        try {
            this.login();
            AfterLoginView afterLoginView = new AfterLoginView(Application.session().getCurrentAccount());
            afterLoginView.show();
        } catch (AccountHasNotRegister e) {
            System.out.println("The Account has not been registered");
        } catch (AuthenticationRequiredException e) {
            System.out.println("Authentication Required");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void login() throws AccountHasNotRegister {
        List<Account> accounts = Application.entityManager().read(Account.class);
        int idAccount = account.existsAccount(accounts);

        if (idAccount < 0) {
            throw new AccountHasNotRegister();
        } else {
            account = accounts.get(idAccount);
            Application.session().setCurrentAccount(account);
        }
    }
}
