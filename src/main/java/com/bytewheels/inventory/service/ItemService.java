package com.bytewheels.inventory.service;

import com.bytewheels.inventory.dto.CreateItemRequest;
import com.bytewheels.inventory.dto.ItemData;
import com.bytewheels.inventory.dto.ItemDetails;
import com.bytewheels.inventory.exceptions.InventoryServiceException;

import java.util.List;

public interface ItemService {
    ItemData getItem(String itemId) throws InventoryServiceException;

    List<ItemData> getAllItems();

    ItemDetails createItem(CreateItemRequest createItemRequest) throws InventoryServiceException;
}
