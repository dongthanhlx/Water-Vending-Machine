package App;

import Domain.Entities.Account;

public class UserSession {

    protected boolean loggedIn;
    protected int accountID;
    protected Account currentAccount;

    public UserSession(){}

    public UserSession(boolean loggedIn, int accountID, Account currentAccount) {
        this.loggedIn = loggedIn;
        this.accountID = accountID;
        this.currentAccount = currentAccount;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setCurrentAccount(Account currentAccount) {
        this.accountID = currentAccount.getId();
        this.currentAccount = currentAccount;
        this.loggedIn = true;
    }

    public void unsetLoginData()
    {
        this.accountID = -1;
        this.loggedIn = false;
        this.currentAccount = null;
    }

    public Account getCurrentAccount() {
        return this.currentAccount;
    }

}
