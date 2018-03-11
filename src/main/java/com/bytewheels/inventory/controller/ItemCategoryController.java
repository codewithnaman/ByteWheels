package com.bytewheels.inventory.controller;

import com.bytewheels.common.controller.BaseController;
import com.bytewheels.common.exception.InvalidFieldException;
import com.bytewheels.common.utility.WebServiceEndPoints;
import com.bytewheels.inventory.dto.CreateItemCategoryRequest;
import com.bytewheels.inventory.dto.ItemCategoryData;
import com.bytewheels.inventory.dto.UpdateItemCategoryRequest;
import com.bytewheels.inventory.exceptions.InventoryServiceException;
import com.bytewheels.inventory.service.ItemCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ItemCategoryController extends BaseController {

    @Autowired
    private ItemCategoryService itemCategoryService;

    @RequestMapping(value = WebServiceEndPoints.ITEM_CATEGORY, method = RequestMethod.GET)
    public List<ItemCategoryData> getAllCategories() {
        return itemCategoryService.getAllCategories();
    }

    @RequestMapping(value = WebServiceEndPoints.ITEM_CATEGORY, method = RequestMethod.POST)
    public ResponseEntity<ItemCategoryData> createItemCategory(@RequestBody @Validated CreateItemCategoryRequest createItemCategoryRequest, BindingResult bindingResult) throws InvalidFieldException, InventoryServiceException {
        validRequest(bindingResult);
        ItemCategoryData itemCategoryData = itemCategoryService.createItemCategory(createItemCategoryRequest);
        return new ResponseEntity<ItemCategoryData>(itemCategoryData, HttpStatus.CREATED);
    }

    @RequestMapping(value = WebServiceEndPoints.ITEM_CATEGORY, method = RequestMethod.PUT)
    public void updateItemCategory(@RequestBody @Validated UpdateItemCategoryRequest updateCategoryRequest, BindingResult bindingResult) throws InvalidFieldException, InventoryServiceException {
        validRequest(bindingResult);
        itemCategoryService.updateItemCategory(updateCategoryRequest);
    }

    @RequestMapping(value = WebServiceEndPoints.ITEM_CATEGORY+"/{itemCategoryId}", method = RequestMethod.DELETE)
    public void removeItemCategory(@PathVariable("itemCategoryId") String itemCategoryId) throws InventoryServiceException {
        itemCategoryService.removeItemCategory(itemCategoryId);
    }
}
