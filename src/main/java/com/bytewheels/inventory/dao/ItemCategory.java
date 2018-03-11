package com.bytewheels.inventory.dao;

import com.bytewheels.common.dao.ModificationMetaData;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "item_category")
public class ItemCategory {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "price",nullable = false)
    private Float price;

    @OneToMany(mappedBy = "itemCategory",fetch = FetchType.LAZY)
    List<Item> items;

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
