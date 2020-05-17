package com.ivo.rakar.foodapp.orderservice.web.models;

public class LineItem {
    private String menuItemId;
    private int quantity;

    private LineItem() {
    }

    public LineItem(String menuItemId, int quantity) {
        this.menuItemId = menuItemId;

        this.quantity = quantity;
    }

    public String getMenuItemId() {
        return menuItemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setMenuItemId(String menuItemId) {
        this.menuItemId = menuItemId;

    }
}
