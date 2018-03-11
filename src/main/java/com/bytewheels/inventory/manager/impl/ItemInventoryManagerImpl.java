package com.bytewheels.inventory.manager.impl;

import com.bytewheels.inventory.dao.ItemInventory;
import com.bytewheels.inventory.manager.ItemInventoryManager;
import com.bytewheels.inventory.repository.ItemInventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class ItemInventoryManagerImpl implements ItemInventoryManager {

    @Autowired
    private ItemInventoryRepository itemInventoryRepository;

    public List<ItemInventory> getAvailableInventoryItemsByDateAndItemId(Date fromDate, Date toDate, String itemId) {
        List<ItemInventory> inventories = itemInventoryRepository.findAvailableInventory(fromDate, toDate, itemId);
        return inventories;
    }

}
