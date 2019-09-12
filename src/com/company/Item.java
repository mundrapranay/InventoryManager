package com.company;
import java.util.*;
public class Item {

    private String name;
    private int quatity;
    private double price;
    private String paidBy;

    public Item(String name, int quantity, double price, String paidBy) {
        this.name = name;
        this.quatity = quantity;
        this.price = price;
        this.paidBy = paidBy;
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public int getQuatity() {
        return quatity;
    }

    public void setQuatity(int quatity) {
        this.quatity = quatity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPaidBy() {
        return paidBy;
    }

    public void setPaidBy(String paidBy) {
        this.paidBy = paidBy;
    }

    private String sameLength (String itemName, int length) {
        for (int i = 0; i < length; i++) {
            itemName += " ";
        }
        return itemName;
    }

    public String toString () {
        return this.getName() + " |  $" + this.getPrice() + " | " + this.getQuatity() + " | " + this.getPaidBy()+"\n";
    }
}
