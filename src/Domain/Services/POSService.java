package Domain.Services;

import Domain.Entities.Account;
import Domain.Entities.POS;
import Domain.Entities.Product;

import javax.security.auth.login.LoginException;

public class POSService {

    public void sell(POS machine, Account customerAccount, Product product, int amount) throws Exception{
        double totalValueItems       = amount * product.getPrice();
        boolean enoughMoney          = customerAccount.getBalance() >= totalValueItems;

        if(!enoughMoney){
            throw new Exception("The account is not enough money for order");
        }

        double restBalance = customerAccount.getBalance() - totalValueItems;
        customerAccount.setBalance(restBalance);

        machine.removeItems(product, amount);
    }

}
