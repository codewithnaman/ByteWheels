package com.bytewheels.inventory.converter;

import com.bytewheels.inventory.dao.Item;
import com.bytewheels.inventory.dao.ItemCategory;
import com.bytewheels.inventory.dto.CreateItemRequest;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


@Component("itemRequestConverter")
public class ItemRequestConverter implements Converter<CreateItemRequest, Item>{
    @Override
    public Item convert(CreateItemRequest source) {
        Item item = null;
        if(source instanceof CreateItemRequest){
            ItemCategory itemCategory = new ItemCategory();
            itemCategory.setId(source.getItemCategoryId());
            item = new Item();
            item.setName(source.getName());
            item.setDescription(source.getDescription());
            item.setItemCategory(itemCategory);
            item.setPrice(source.getPrice());
        }
        return item;
    }
}
