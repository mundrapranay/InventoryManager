package com.company;

// toDo: Maybe autogenerate an item number using random

public class Item {

    private String name;
    private int quantity;
    private double price;
    private String paidBy;

    public Item(String name, int quantity, double price, String paidBy) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.paidBy = paidBy;
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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
        return this.getName() + " |  $" + this.getPrice() + " | " + this.getQuantity() + " | " + this.getPaidBy()+"\n";
    }

    public void update (String name, int quantity, double price, String paidBy) {
        this.setQuantity(quantity);
        this.setPrice(price);
        this.setPaidBy(paidBy);
    }
}
