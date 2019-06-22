package App;


import Domain.Entities.Account;
import Domain.Entities.POS;
import Infra.Data.ObjectPersistence;

import java.io.*;
import java.util.ArrayList;

public class EntityManager {
    protected ObjectPersistence objectPersistene;

    public EntityManager(ObjectPersistence objectPersistene) {
        this.objectPersistene = objectPersistene;
    }

    public void savePOSCollections(POS pos)
    {
        this.objectPersistene.savePOS(pos);
    }

    public void saveAccountCollections(Account account){
        this.objectPersistene.saveAccount(account);
    }

    public POS readPOSCollections(){
        return this.objectPersistene.readObjectPOS();
    }

    public ArrayList<Account> readAccountCollections(){
            return this.objectPersistene.readObjectAccount();
    }
}