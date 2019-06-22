package Infra.Data;

import Domain.Entities.*;


import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

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
            oos.close();
            fos.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

//    @Override
//    public POS readObjectPOS() {
//        POS pos = new POS("may ban nuoc");
//        try {
//            FileReader reader = new FileReader(dataDirectoryPOS);
//            JSONParser jsonParser = new JSONParser();
//            Object object = jsonParser.parse(reader);
//            String string = object.toString();
//            JSONObject jsonObject = new JSONObject(string);
//            JSONArray jsonItems = (JSONArray) jsonObject.get("items");
//            int numberItems = jsonItems.length();
//            for (int i=0; i<numberItems; i++){
//                JSONObject jsonItemType = jsonItems.getJSONObject(i);
//                Product product = new Product();
//                product.setId((int)jsonItemType.get("id"));
//                product.setName((String)jsonItemType.get("type"));
//                product.setPrice((int)jsonItemType.get("price"));
//
//                POSItem posItem = new POSItem(product);
//                posItem.setQuantity((int)jsonItemType.get("amount"));
//                System.out.println(posItem.getProduct().getName());
//                System.out.println(posItem.getQuantity());
//                pos.addItem(posItem);
//            }
//        }   catch (IOException e){
//            e.printStackTrace();
//        }   catch (ParseException e){
//            e.printStackTrace();
//        }
//        return pos;
//    }

    @Override
    public POS readObjectPOS(){
        POS pos = null;
        try {
            FileInputStream fis = new FileInputStream(dataDirectoryPOS);
            if(fis.available() <= 0) return null;
            ObjectInputStream ois = new ObjectInputStream(fis);
            pos = (POS) ois.readObject();
        } catch (Exception e){
            e.printStackTrace();
        }
        return pos;
    }

    @Override
    public void saveAccount(ArrayList<Account> account) {
        try {
            FileOutputStream fos = new FileOutputStream(dataDirectoryAccount);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(account);
            oos.close();
            fos.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

//    @Override
//    public ArrayList<Account> readObjectAccount() {
//        ArrayList<Account> accounts = new ArrayList<Account>();
//        try {
//            FileReader reader = new FileReader(dataDirectoryAccount);
//            JSONParser jsonParser = new JSONParser();
//            Object object = jsonParser.parse(reader);
//
//            String string = object.toString();
//            JSONObject jsonObject = new JSONObject(string);
//            JSONArray jsonAccounts = (JSONArray) jsonObject.get("accounts");
//            int numberAccount = jsonAccounts.length();
//
//            for (int i=0; i<numberAccount; i++){
//                JSONObject jsonAccount = jsonAccounts.getJSONObject(i);
//                Account account = new Account();
//                account.setId((int)jsonAccount.get("id"));
//                account.setEmail((String) jsonAccount.get("email"));
//                account.setPassword((String) jsonAccount.get("password"));
//                account.setBalance((double) jsonAccount.get("balance"));
//                accounts.add(account);
//            }
//        } catch (IOException e){
//            e.printStackTrace();
//        } catch (ParseException e){
//            e.printStackTrace();
//        }
//        return accounts;
//    }


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
