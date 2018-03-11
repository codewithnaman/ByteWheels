package com.bytewheels.inventory.constant;

public enum InventoryErrorCodes {
    INVENTORY_NOT_FOUND("Inventory not found"),
    ITEM_NOT_FOUND("Item not found for given id"),
    INVENTORY_ALREADY_AVAILABLE("Inventory already present"),
    UNABLE_TO_UPDATE_INVENTORY("Unable to update inventory"),
    PROVIDED_ITEM_CATEGORY_NOT_AVAILABLE("Item category not found"),
    UNABLE_TO_CREATE_ITEM("Unable to create item");

    private String message;

    InventoryErrorCodes(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
