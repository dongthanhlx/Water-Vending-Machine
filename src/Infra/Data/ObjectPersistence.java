package Infra.Data;

import Domain.Entities.Account;
import Domain.Entities.POS;

import java.util.ArrayList;

abstract public class ObjectPersistence {
    public abstract void savePOS(POS pos);
    public abstract POS readObjectPOS();
    public abstract void saveAccount(Account account);
    public abstract ArrayList<Account> readObjectAccount();
}
