package Infra.Data;

import Domain.Entities.*;


import java.io.*;
import java.util.ArrayList;

public class FileDatabase extends ObjectPersistence {

    private String dataDirectoryPOS;
    private String dataDirectoryAccount;

    public FileDatabase(String dataPOS, String dataAccount)
    {
        this.dataDirectoryPOS = dataPOS;
        this.dataDirectoryAccount = dataAccount;
    }

    public String getDataDirectoryPOS() {
        return dataDirectoryPOS;
    }

    public void setDataDirectoryPOS(String dataDirectoryPOS) {
        this.dataDirectoryPOS = dataDirectoryPOS;
    }

    public String getDataDirectoryAccount() {
        return dataDirectoryAccount;
    }

    public void setDataDirectoryAccount(String dataDirectoryAccount) {
        this.dataDirectoryAccount = dataDirectoryAccount;
    }

    @Override
    public void savePOS(POS pos) {
        try (FileOutputStream fos = new FileOutputStream(dataDirectoryPOS);
             ObjectOutputStream oos = new ObjectOutputStream(fos)){
            oos.writeObject(pos);
        } catch (IOException e){
            e.printStackTrace();
        }
    }


    @Override
    public POS readObjectPOS(){
        POS pos = new POS();
        try {
            FileInputStream fis = new FileInputStream(dataDirectoryPOS);
            if(fis.available() <= 0) return null;
            ObjectInputStream ois = new ObjectInputStream(fis);
            pos = (POS) ois.readObject();
            ois.close();
            fis.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        return pos;
    }

    @Override
    public void saveAccount(ArrayList<Account> accounts) {
        try {
            FileOutputStream fos = new FileOutputStream(dataDirectoryAccount);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(accounts);
            oos.close();
            fos.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }



    @Override
    public ArrayList<Account> readObjectAccount() {
        ArrayList<Account> accounts = new ArrayList<Account>();
        try {
            FileInputStream fis = new FileInputStream(dataDirectoryAccount);
            if(fis.available() <= 0)    return null;
            ObjectInputStream ois = new ObjectInputStream(fis);
            accounts = (ArrayList) ois.readObject();
            ois.close();
            fis.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        return accounts;
    }
}
