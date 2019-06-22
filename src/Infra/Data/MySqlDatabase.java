package Infra.Data;

import Domain.Entities.Account;
import Domain.Entities.POS;

import java.util.ArrayList;

public class MySqlDatabase extends ObjectPersistence {
    @Override
    public void savePOS(POS pos) {

    }

    @Override
    public POS readObjectPOS() {
        return null;
    }

    @Override
    public void saveAccount(ArrayList<Account> account) {

    }

    @Override
    public ArrayList<Account> readObjectAccount() {
        return null;
    }
}
