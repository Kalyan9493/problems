package org.example.streamproblems.complexproblems;

public class Item {
    private String itemName;
    private double price;

    public Item(String itemName, double price) {
        this.itemName = itemName;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    // Getters and toString()
    public String getItemName() {
        return itemName;
    }

    @Override
    public String toString() {
        return "Item{name='" + itemName + "', price=" + price + "}";
    }
}

