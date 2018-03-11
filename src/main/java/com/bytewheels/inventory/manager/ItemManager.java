package com.bytewheels.inventory.manager;

import com.bytewheels.inventory.dao.Item;
import com.bytewheels.inventory.dao.ItemCategory;
import com.bytewheels.inventory.exceptions.InventoryServiceException;

import java.util.List;

public interface ItemManager {
    Item createItem(Item item, ItemCategory itemCategory) throws InventoryServiceException;

    List<Item> getAllItems();

    Item getItemById(String itemId) throws InventoryServiceException;

}
