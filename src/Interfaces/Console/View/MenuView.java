package Interfaces.Console.View;

import App.Application;
import Interfaces.Console.Requests.Input;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuView {

    private int select;

    public void screenSelection() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("1.  View products");
        System.out.println("2.  Login");
        System.out.println("3.  Register");
        System.out.println("4.  Exit");
//        select = scanner.nextInt();
//
//        while (select < 1 || select > 4) {
//            System.out.print("Enter select(1-4) : ");
//            select = scanner.nextInt();
//        }

        Input input = new Input();
        select = input.scan(
                "select(1-4) ",
                new ArrayList<>() {
                    {
                        add("required");
                        add("numeric");
                    }
                }
        ).toInt();

    }

    public int getSelect() {
        return select;
    }

}
