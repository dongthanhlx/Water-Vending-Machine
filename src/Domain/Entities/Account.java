package Domain.Entities;

import java.util.ArrayList;

public class Account extends AbstractEntity {
    protected int id;
    protected String email;
    protected String password;
    protected double balance;



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int existsAccount(ArrayList<Account> accounts){
        int numberAccount = accounts.size();
        for(int i=0; i<numberAccount; i++){
            Account tempAccount = accounts.get(i);
            if(tempAccount.getEmail().equals(email)
                    && tempAccount.getPassword().equals(password))
                return i;
        }
        return -1;
    }

    public void seeBalances(){
        System.out.println("------Email "+email+" has balance "+balance);
    }
}
