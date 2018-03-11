package com.bytewheels.inventory.service.impl;

import com.bytewheels.inventory.constant.InventoryErrorCodes;
import com.bytewheels.inventory.dao.ItemCategory;
import com.bytewheels.inventory.dto.CreateItemCategoryRequest;
import com.bytewheels.inventory.dto.ItemCategoryData;
import com.bytewheels.inventory.dto.UpdateItemCategoryRequest;
import com.bytewheels.inventory.exceptions.InventoryServiceException;
import com.bytewheels.inventory.exceptions.ItemCategoryNotFoundException;
import com.bytewheels.inventory.manager.ItemCategoryManager;
import com.bytewheels.inventory.service.ItemCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemCategoryServiceImpl implements ItemCategoryService {

    @Autowired
    private ItemCategoryManager itemCategoryManager;


    @Autowired
    @Qualifier("itemCategoryRequestConverter")
    private Converter itemRequestConverter;

    @Autowired
    @Qualifier("updateItemRequestConverter")
    private Converter updateItemRequestConverter;

    @Autowired
    @Qualifier("itemCategoryResponseConverter")
    private Converter<ItemCategory, ItemCategoryData> itemCategoryResponseConverter;
    @Override
    public List<ItemCategoryData> getAllCategories(){
        List<ItemCategory> itemCategories = itemCategoryManager.getAllCategories();
        List<ItemCategoryData> itemCategoryData = new ArrayList<>();
        for (ItemCategory itemCategory : itemCategories) {
            itemCategoryData.add(itemCategoryResponseConverter.convert(itemCategory));
        }
        return itemCategoryData;
    }

    @Override
    public ItemCategoryData createItemCategory(CreateItemCategoryRequest createItemCategoryRequest) throws InventoryServiceException {
        ItemCategory itemCategory = (ItemCategory) itemRequestConverter.convert(createItemCategoryRequest);
        itemCategory = itemCategoryManager.createItemCategory(itemCategory);
        return itemCategoryResponseConverter.convert(itemCategory);
    }

    @Override
    public void updateItemCategory(UpdateItemCategoryRequest updateCategoryRequest) throws InventoryServiceException {
        ItemCategory itemCategory  = (ItemCategory) updateItemRequestConverter.convert(updateCategoryRequest);
        itemCategoryManager.updateItemCategory(itemCategory);
    }

    @Override
    public void removeItemCategory(String itemCategoryId) throws InventoryServiceException{
        ItemCategory itemCategory = null;
        try{
            itemCategory = itemCategoryManager.getItemCategory(itemCategoryId);
        }catch (ItemCategoryNotFoundException e){
            throw new InventoryServiceException(InventoryErrorCodes.PROVIDED_ITEM_CATEGORY_NOT_AVAILABLE.name(),
                    InventoryErrorCodes.PROVIDED_ITEM_CATEGORY_NOT_AVAILABLE.getMessage());
        }
        itemCategoryManager.removeItemCategory(itemCategory.getId());
    }

}
