package com.cn.luo.db.util;

import com.cn.luo.db.DBName;
import com.cn.luo.db.PropertyName;
import org.greenrobot.greendao.generator.Entity;
import org.greenrobot.greendao.generator.Property;
import org.greenrobot.greendao.generator.Schema;

public class DistributionHelperDBUtil extends DBUtil {

    public static final String DATABASE_NAME = "distribution_helper.db";
    public static final int DATABASE_VERSION = 1;
    public static final String DEFAULT_JAVA_PACKAGE = "com.cn.luo.android.model.entity.distribution";
    public static final String DEFAULT_JAVA_PACKAGE_DAO = "com.cn.luo.android.model.dao.distribution";

    public DistributionHelperDBUtil() {
        super(DATABASE_VERSION, DEFAULT_JAVA_PACKAGE, DEFAULT_JAVA_PACKAGE_DAO);
    }

    @Override
    public void generateDB(Schema schema) {
        // Plan table
        Entity plan = schema.addEntity("Plan");
        plan.setDbName(DBName.PLAN);
        plan.addIdProperty().dbName(DBName.ID);
        plan.addStringProperty(PropertyName.NAME).dbName(DBName.NAME).notNull().unique();

        // Folder table
        Entity folder = schema.addEntity("Folder");
        folder.setDbName(DBName.FOLDER);
        folder.addIdProperty().dbName(DBName.ID);
        folder.addStringProperty(PropertyName.PATH).dbName(DBName.PATH).notNull();

        // Suffix table
        Entity suffix = schema.addEntity("Suffix");
        suffix.setDbName(DBName.SUFFIX);
        suffix.addIdProperty().dbName(DBName.ID);
        suffix.addStringProperty(PropertyName.NAME).dbName(DBName.NAME).notNull();

        // Category table
        Entity category = schema.addEntity("Category");
        category.setDbName(DBName.CATEGORY);
        category.addIdProperty().dbName(DBName.ID);
        category.addStringProperty(PropertyName.NAME).dbName(DBName.NAME).notNull().unique();

        // Build the relationship between tables
        // Build the many-to-many relationship
//        Entity planAndFolder = schema.addEntity("PlanAndFolder");
//        planAndFolder.setDbName("plan_and_folder");
//        planAndFolder.addIdProperty().dbName(DBName.ID);
//        Property planId = planAndFolder.addLongProperty("planId").dbName("plan_id").notNull().getProperty();
//        Property folderId = planAndFolder.addLongProperty("folderId").dbName("folder_id").notNull().getProperty();
//        plan.addToMany(folder, planAndFolder, planId, folderId);
//        folder.addToMany(plan, planAndFolder, folderId, planId);

//        Entity folderAndSuffix = schema.addEntity("FolderAndSuffix");
//        folderAndSuffix.setDbName("folder_and_suffix");
//        folderAndSuffix.addIdProperty().dbName(DBName.ID);
//        Property folderId1 = folderAndSuffix.addLongProperty("folderId").dbName("folder_id").notNull().getProperty();
//        Property suffixId = folderAndSuffix.addLongProperty("suffixId").dbName("suffix_id").notNull().getProperty();
//        suffix.addToMany(folder, folderAndSuffix, suffixId, folderId1);
//        folder.addToMany(suffix, folderAndSuffix, folderId1, suffixId);

//        Entity planAndSuffix = schema.addEntity("PlanAndSuffix");
//        planAndSuffix.setDbName("plan_and_suffix");
//        planAndSuffix.addIdProperty().dbName(DBName.ID);
//        Property planId1 = planAndSuffix.addLongProperty("planId").dbName("plan_id").notNull().getProperty();
//        Property suffixId1 = planAndSuffix.addLongProperty("suffixId").dbName("suffix_id").notNull().getProperty();
//        plan.addToMany(suffix, planAndSuffix, planId1, suffixId1);
//        suffix.addToMany(plan, planAndSuffix, suffixId1, planId1);

        // Build the one-to-many relationship
        Property planId = folder.addLongProperty(PropertyName.PLAN_ID).dbName(DBName.PLAN_ID).getProperty();
        folder.addToOne(plan, planId).setName(PropertyName.PLAN);
        plan.addToMany(folder, planId).setName(PropertyName.FOLDER_LIST);

        Property folderId = suffix.addLongProperty(PropertyName.FOLDER_ID).dbName(DBName.FOLDER_ID).getProperty();
        suffix.addToOne(folder, folderId).setName(PropertyName.FOLDER);
        folder.addToMany(suffix, folderId).setName(PropertyName.SUFFIX_LIST);

        Property categoryId = suffix.addLongProperty(PropertyName.CATEGORY_ID).dbName(DBName.CATEGORY_ID).getProperty();
        suffix.addToOne(category, categoryId).setName(PropertyName.CATEGORY);
        category.addToMany(suffix, categoryId).setName(PropertyName.SUFFIX_LIST);
    }
}
