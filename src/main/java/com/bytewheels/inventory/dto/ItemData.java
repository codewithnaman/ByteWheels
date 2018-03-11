package com.bytewheels.inventory.dto;

public class ItemData {
    private String id;
    private String name;
    private String description;
    private ItemCategoryData itemCategoryData;
    private Float price;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ItemCategoryData getItemCategoryData() {
        return itemCategoryData;
    }

    public void setItemCategoryData(ItemCategoryData itemCategoryData) {
        this.itemCategoryData = itemCategoryData;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
