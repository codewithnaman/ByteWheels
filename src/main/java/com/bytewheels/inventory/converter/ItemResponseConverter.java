package com.bytewheels.inventory.converter;

import com.bytewheels.inventory.dao.Item;
import com.bytewheels.inventory.dto.ItemCategoryData;
import com.bytewheels.inventory.dto.ItemData;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component("itemResponseConverter")
public class ItemResponseConverter implements Converter<Item, ItemData> {

    @Override
    public ItemData convert(Item item) {
        ItemData itemData = new ItemData();
        ItemCategoryData itemCategoryData = new ItemCategoryData();
        itemData.setId(item.getId());
        itemData.setName(item.getName());
        itemData.setDescription(item.getDescription());
        itemData.setPrice(item.getPrice());
        itemCategoryData.setId(item.getItemCategory().getId());
        itemCategoryData.setName(item.getItemCategory().getName());
        itemCategoryData.setPrice(item.getItemCategory().getPrice());
        itemData.setItemCategoryData(itemCategoryData);
        return itemData;
    }
}
