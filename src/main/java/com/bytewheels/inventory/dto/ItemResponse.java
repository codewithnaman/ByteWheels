package com.bytewheels.inventory.dto;

import com.bytewheels.inventory.dao.Item;

import java.util.List;

public class ItemResponse {
    List<Item> items;

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
