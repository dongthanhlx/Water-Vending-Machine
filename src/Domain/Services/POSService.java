package Domain.Services;

import App.Application;
import App.Exceptions.Trading.MoneyNotEnoughException;
import Domain.Entities.Account;
import Domain.Entities.POS;
import Domain.Entities.POSItem;
import Domain.Entities.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class POSService {
    protected List<POS> poss;
    protected List<Account> accounts;

    public void sell(POS machine, Account customerAccount, Product product, int amount) throws MoneyNotEnoughException {
        double totalValueItems = amount * product.getPrice();
        boolean enoughMoney = customerAccount.getBalance() >= totalValueItems;

        if (!enoughMoney) {
            throw new MoneyNotEnoughException();
        }

        double restBalance = customerAccount.getBalance() - totalValueItems;
        customerAccount.setBalance(restBalance);
        machine.removeItems(product, amount);

        poss = new ArrayList<>();
        poss.add(machine);
        accounts = Application.entityManager().read(Account.class);
        accounts.get(customerAccount.getId()).setBalance(customerAccount.getBalance());

    }

    public void save() {
        Application.entityManager().write(POS.class, poss);
        Application.entityManager().write(Account.class, accounts);
    }

    public void load() {
        this.poss = Application.entityManager().read(POS.class);
        if(this.poss == null) {
            poss = new ArrayList<>();
            initPOS();
            this.save();
        }
        Application.posList().add(this.poss.get(0));
    }

    public void refresh(){

    }

    public void initPOS() {
        POS pos = new POS();

        Scanner scanner = new Scanner(System.in);
        System.out.println("\t---------SET POS---------");
        System.out.print("Name POS: ");
        pos.setName(scanner.nextLine());
        pos.setId(0);
        System.out.println("Add Item");
        String nameProduct ;
        int i=-1;
        do {
            i++;
            System.out.print("Name product: ");
            nameProduct = scanner.nextLine();
            System.out.print(nameProduct+" price : ");

            Product product = new Product();
            product.setId(i);
            product.setName(nameProduct);
            product.setPrice(scanner.nextInt());

            POSItem posItem = new POSItem(product);
            System.out.print("Amount: ");
            posItem.setQuantity(scanner.nextInt());
            scanner.nextLine();
            pos.addItem(posItem);
        } while (isAddItem());
        this.poss.add(pos);
    }

    public boolean isAddItem() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Do you want add a item?(y/n) ");
        String select = scanner.nextLine();
        return select.equals("y");
    }

    public List<POS> getPOS() {
        return poss;
    }

}
