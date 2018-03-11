package com.bytewheels.inventory.converter;

import com.bytewheels.inventory.dao.ItemCategory;
import com.bytewheels.inventory.dto.ItemCategoryData;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


@Component("itemCategoryResponseConverter")
public class ItemCategoryResponseConverter implements Converter<ItemCategory, ItemCategoryData> {

    @Override
    public ItemCategoryData convert(ItemCategory itemCategory) {
        ItemCategoryData itemCategoryData = new ItemCategoryData();
        itemCategoryData.setId(itemCategory.getId());
        itemCategoryData.setName(itemCategory.getName());
        itemCategoryData.setPrice(itemCategory.getPrice());
        return itemCategoryData;
    }
}
