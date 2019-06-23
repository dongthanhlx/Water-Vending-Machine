package Domain.Entities;

import java.io.Serializable;
import java.util.Scanner;

public class Product implements Serializable {
    private int id;
    private String name;
    private double price;
    public Product(){}

    public Product(int id, String name, double price) {
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

    public void setPrice(double _price) {
        this.price = _price;
    }

    public double getPrice() {
        return price;
    }
}
