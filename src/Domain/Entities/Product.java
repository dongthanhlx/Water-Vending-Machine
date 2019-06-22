package Domain.Entities;

import java.util.Scanner;

public class Product {
    private int id;
    private String name;
    private int price;
    public Product(){}

    public Product(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int _id) {
        this.id = _id;
    }

    public void setName(String _name) {
        this.name = _name;
    }

    public String getName() {
        return name;
    }

    public void setPrice(int _price) {
        this.price = _price;
    }

    public int getPrice() {
        return price;
    }
}
