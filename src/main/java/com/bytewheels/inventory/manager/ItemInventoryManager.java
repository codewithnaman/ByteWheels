package com.bytewheels.inventory.manager;

import com.bytewheels.inventory.dao.ItemInventory;

import java.util.Date;
import java.util.List;

public interface ItemInventoryManager {

    List<ItemInventory> getAvailableInventoryItemsByDateAndItemId(Date fromDate, Date toDate, String category);
}
