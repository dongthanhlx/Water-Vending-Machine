package Interfaces.Console.Menu;

import Domain.Entities.POS;

import java.util.Scanner;

public class MenuScreen extends AbstractScreen {
    private POS pos;
    public MenuScreen(POS pos) {
        this.pos = pos;
    }

    public void displayOnScreen(){
        pos.displayItems();
    }

    public static int screenSelection(){
        Scanner scanner = new Scanner(System.in);
        int select ;

        System.out.println("1.  Menu");
        System.out.println("2.  Login");
        System.out.println("3.  Exit");
        System.out.print("Enter select(1-3) : ");
        select = scanner.nextInt();

        while (select < 1 || select > 3){
            System.out.print("Enter select(1-3) : ");
            select = scanner.nextInt();
        }
        return select;
    }

}
