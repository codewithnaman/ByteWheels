package com.bytewheels.inventory.dao;

import com.bytewheels.common.dao.ModificationMetaData;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "item")
public class Item {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name="description",nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name = "item_category_id",referencedColumnName = "id",nullable = false)
    private ItemCategory itemCategory;

    @Column(name = "price")
    private Float price;

    @OneToMany(mappedBy = "item",fetch = FetchType.LAZY)
    private List<ItemInventory> inventoryItems;

    @Embedded
    private ModificationMetaData modificationMetaData;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ItemCategory getItemCategory() {
        return itemCategory;
    }

    public void setItemCategory(ItemCategory itemCategory) {
        this.itemCategory = itemCategory;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public ModificationMetaData getModificationMetaData() {
        return modificationMetaData;
    }

    public void setModificationMetaData(ModificationMetaData modificationMetaData) {
        this.modificationMetaData = modificationMetaData;
    }
}
