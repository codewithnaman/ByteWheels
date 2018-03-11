package com.bytewheels.inventory.manager;

import com.bytewheels.inventory.dao.ItemCategory;
import com.bytewheels.inventory.exceptions.InventoryServiceException;
import com.bytewheels.inventory.exceptions.ItemCategoryNotFoundException;

import java.util.List;

public interface ItemCategoryManager {

    List<ItemCategory> getAllCategories();

    ItemCategory createItemCategory(ItemCategory itemCategory) throws InventoryServiceException;

    void updateItemCategory(ItemCategory itemCategory) throws InventoryServiceException;

    ItemCategory getItemCategory(String itemCategoryId) throws ItemCategoryNotFoundException;

    void removeItemCategory(String itemCategoryId);
}
