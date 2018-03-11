package com.bytewheels.inventory.service;

import com.bytewheels.inventory.dto.CreateItemCategoryRequest;
import com.bytewheels.inventory.dto.ItemCategoryData;
import com.bytewheels.inventory.dto.UpdateItemCategoryRequest;
import com.bytewheels.inventory.exceptions.InventoryServiceException;

import java.util.List;

public interface ItemCategoryService {

    List<ItemCategoryData> getAllCategories();

    ItemCategoryData createItemCategory(CreateItemCategoryRequest createItemCategoryRequest) throws InventoryServiceException;

    void updateItemCategory(UpdateItemCategoryRequest updateCategoryRequest) throws InventoryServiceException;

    void removeItemCategory(String itemCategoryId) throws InventoryServiceException;
}
