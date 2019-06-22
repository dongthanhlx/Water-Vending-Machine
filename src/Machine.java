import App.EntityManager;
import Domain.Entities.*;
import Domain.Services.TransactionService;
import Infra.Data.FileDatabase;
import Interfaces.Console.Menu.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Machine {
    private static POS pos = new POS("may ban nuoc");
    private static ArrayList<Account> accounts;
    private static Account account = new Account() ;
    private static Cart cart = new Cart();
    private static String dataDirectoryPOS = "data/pos.json";
    private static String dataDirectoryAccount = "data/account.json";
    private static EntityManager entityManager = new EntityManager(new FileDatabase(dataDirectoryPOS, dataDirectoryAccount));
    private static int usingAccount ;
    public static void main(String []args){
        load();
        MainScreen();
    }

    public static void MainScreen(){
        int select;
        do {
            select = MenuScreen.screenSelection();

            switch (select){
                case 1:
                    Menu();
                    break;
                case 2:
                    Login();
                    break;
                case 3:
                    Register();
                    break;
                case 4:
                    ExitScreen exitScreen = new ExitScreen();
            }

        }while (select != 4);
    }


    public static void Register(){
        RegisterScreen registerScreen = new RegisterScreen();
        accounts = entityManager.readAccountCollections();

        Account tempAccount;
        do {
            tempAccount = registerScreen.register();
        }while (tempAccount.existsAccount(accounts) >= 0);

        int numberAccount;
        if (accounts == null)   {
            numberAccount = 0;
            accounts = new ArrayList<>();
        }
        else numberAccount = accounts.size();

        tempAccount.setId(numberAccount);
        accounts.add(tempAccount);
//        ArrayList<Account> tempAccounts = new ArrayList<>();
//        tempAccounts.add(tempAccount);
        entityManager.saveAccountCollections(accounts);
    }


    public static void Menu(){
        MenuScreen menuScreen = new MenuScreen(pos);
        menuScreen.displayOnScreen();
    }

    public static void Login(){
        LoginScreen loginScreen = new LoginScreen();
        do {
            account = loginScreen.AccountInfo();
            usingAccount = account.existsAccount(accounts);
        } while(usingAccount < 0);
        int select;
        do {
            select = loginScreen.screenLogined();
            switch (select) {
                case 1:
                    Menu();
                    break;
                case 2:
                    accounts.get(usingAccount).seeBalances();
                    break;
                case 3:
                    cart.seeItems();
                    break;
                case 4:
                    executeBuy();
                    break;
                case 5:
                    return;
            }
        }while (true);
    }

    public static void executeBuy(){
        boolean checkTransaction;
        do {
            BuyScreen buyScreen = new BuyScreen(pos, cart);
            buyScreen.displayOnScreen();

            TransactionService transactionService = new TransactionService();
            checkTransaction = transactionService.transactionItems(accounts.get(usingAccount), pos, cart);
        }while(!checkTransaction);
        cart = new Cart();
    }

    public static void load(){
        // Initialize entity manager
        loadPOS();
        loadAccount();
    }

    public static void loadPOS(){
        pos = entityManager.readPOSCollections();
        if (pos == null){
            pos = initPOS();
        }
    }

    public static void loadAccount(){
        accounts = entityManager.readAccountCollections();
    }

    public static POS initPOS() {
        POS initPOS = new POS();
        Scanner scanner = new Scanner(System.in);
        System.out.println("\t---------SET POS---------");
        System.out.print("Name POS: ");
        initPOS.setName(scanner.nextLine());
        System.out.println("Add Item");
        String nameProduct = "";
        for (int i=0; i<4; i++){
            switch (i){
                case 0: nameProduct = ConstantProduct.COCA;
                    break;
                case 1: nameProduct = ConstantProduct.MILK;
                    break;
                case 2: nameProduct = ConstantProduct.PEPSI;
                    break;
                case 3: nameProduct = ConstantProduct.WATER;
            }
            System.out.print(nameProduct+" price : ");
            Product product = new Product();
            product.setId(i);
            product.setName(nameProduct);
            product.setPrice(scanner.nextInt());
            POSItem posItem = new POSItem(product);
            System.out.print("Amount: ");
            posItem.setQuantity(scanner.nextInt());
            initPOS.addItem(posItem);
        }
        return initPOS;
    }
}
