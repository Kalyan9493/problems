package org.example.streamproblems.complexproblems;

import java.util.List;

public class Order {
    private String orderId;
    private String customerId;
    private List<Item> items;

    public Order(String orderId, String customerId, List<Item> items) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.items = items;
    }

    public String getCustomerId() {
        return customerId;
    }

    public List<Item> getItems() {
        return items;
    }

    // Getters and toString()
    public String getOrderId() {
        return orderId;
    }

    @Override
    public String toString() {
        return "Order{orderId='" + orderId + "', customerId='" + customerId + "', items=" + items + "}";
    }
}

