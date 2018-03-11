package com.bytewheels.inventory.dto;

import com.bytewheels.inventory.dao.ItemCategory;

import java.util.List;

public class ItemCategoryResponse {
    List<ItemCategoryData> itemCategories;

    public List<ItemCategoryData> getItemCategories() {
        return itemCategories;
    }

    public void setItemCategories(List<ItemCategoryData> itemCategories) {
        this.itemCategories = itemCategories;
    }
}
