package com.bytewheels.inventory.service.impl;

import com.bytewheels.inventory.constant.InventoryErrorCodes;
import com.bytewheels.inventory.dao.Item;
import com.bytewheels.inventory.dao.ItemCategory;
import com.bytewheels.inventory.dto.CreateItemRequest;
import com.bytewheels.inventory.dto.ItemData;
import com.bytewheels.inventory.dto.ItemDetails;
import com.bytewheels.inventory.exceptions.InventoryServiceException;
import com.bytewheels.inventory.exceptions.ItemCategoryNotFoundException;
import com.bytewheels.inventory.manager.ItemCategoryManager;
import com.bytewheels.inventory.manager.ItemManager;
import com.bytewheels.inventory.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemCategoryManager itemCategoryManager;

    @Autowired
    private ItemManager itemManager;

    @Autowired
    @Qualifier("itemRequestConverter")
    private Converter itemRequestConverter;

    @Autowired
    @Qualifier("itemResponseConverter")
    private Converter<Item, ItemData> itemResponseConverter;

    @Autowired
    @Qualifier(value = "itemDetailsConverter")
    private Converter itemDetailsConverter;

    @Override
    public ItemData getItem(String itemId) throws InventoryServiceException {
        Item item = itemManager.getItemById(itemId);
        return itemResponseConverter.convert(item);
    }

    @Override
    public List<ItemData> getAllItems() {
        List<Item> items = itemManager.getAllItems();
        List<ItemData> itemDataList = new ArrayList<>();
        for(Item item : items){
            itemDataList.add(itemResponseConverter.convert(item));
        }
        return itemDataList;
    }

    @Override
    public ItemDetails createItem(CreateItemRequest createItemRequest) throws InventoryServiceException {
        Item item = (Item) itemRequestConverter.convert(createItemRequest);
        ItemCategory itemCategory = null;
        try {
            itemCategory = itemCategoryManager.getItemCategory(item.getItemCategory().getId());
        } catch (ItemCategoryNotFoundException itemCategoryNotFoundException) {
            throw new InventoryServiceException(InventoryErrorCodes.PROVIDED_ITEM_CATEGORY_NOT_AVAILABLE.name(),
                    InventoryErrorCodes.PROVIDED_ITEM_CATEGORY_NOT_AVAILABLE.getMessage());
        }
        item = itemManager.createItem(item, itemCategory);
        return (ItemDetails) itemDetailsConverter.convert(item);
    }


}
