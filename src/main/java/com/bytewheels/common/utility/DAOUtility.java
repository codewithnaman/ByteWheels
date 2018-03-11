package com.bytewheels.common.utility;

import com.bytewheels.common.dao.ModificationMetaData;

import java.util.Date;
import java.util.UUID;

public class DAOUtility {

    public static ModificationMetaData getCurrentModificationData() {
        ModificationMetaData modificationMetaData = new ModificationMetaData();
        modificationMetaData.setCreateDate(new Date());
        modificationMetaData.setUpdateDate(new Date());
        return modificationMetaData;
    }

    public static ModificationMetaData changeUpdateDate(ModificationMetaData modificationMetaData) {
        modificationMetaData.setUpdateDate(new Date());
        return modificationMetaData;
    }

    public static String getUUID() {
        return UUID.randomUUID().toString();
    }
}
