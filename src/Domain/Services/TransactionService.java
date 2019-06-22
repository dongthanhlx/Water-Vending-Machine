package Domain.Services;

import Domain.Entities.*;


public class TransactionService {

    public boolean transactionItems(Account account, POS pos, Cart cart) {
        double balanceAccount = account.getBalance() - cart.calculateTotalValueCart();

        if (balanceAccount >= 0) {
            account.setBalance(balanceAccount);
            pos.removeItems(cart);
            return true;
        }
        return false;
    }
}
