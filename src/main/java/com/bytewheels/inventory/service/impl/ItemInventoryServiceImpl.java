package com.bytewheels.inventory.service.impl;

import com.bytewheels.common.service.impl.OrderEmailService;
import com.bytewheels.inventory.dao.Item;
import com.bytewheels.inventory.dao.ItemInventory;
import com.bytewheels.inventory.dto.ItemDetails;
import com.bytewheels.inventory.manager.ItemInventoryManager;
import com.bytewheels.inventory.manager.ItemManager;
import com.bytewheels.inventory.service.ItemInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ItemInventoryServiceImpl implements ItemInventoryService {

    @Autowired
    private ItemInventoryManager itemInventoryManager;

    @Autowired
    private ItemManager itemManager;

    @Autowired
    @Qualifier("itemDetailsConverter")
    private Converter itemDetailsConverter;

    @Autowired
    private OrderEmailService orderEmailService;

    public Map<String, Set<ItemDetails>> searchItemsByDateAvailablity(Date fromDate, Date toDate) {
        List<Item> items = itemManager.getAllItems();
        Map<String, Set<ItemDetails>> itemMap = new TreeMap<>();
        for (Item item : items) {
            ItemDetails itemDetails = (ItemDetails) itemDetailsConverter.convert(item);
            List<ItemInventory> availableItems = itemInventoryManager.getAvailableInventoryItemsByDateAndItemId(fromDate, toDate, itemDetails.getItemId());
            itemDetails.setAvailabilityStatus((availableItems != null && availableItems.size() > 0) ? "AVAILABLE" : "UNAVAILABLE");
            if (itemMap.get(item.getItemCategory().getName()) == null) {
                Set<ItemDetails> categoryItems = new TreeSet<>();
                categoryItems.add(itemDetails);
                itemMap.put(itemDetails.getCarCategory(), categoryItems);
            } else {
                itemMap.get(itemDetails.getCarCategory()).add(itemDetails);
            }
        }


        return itemMap;
    }

}
