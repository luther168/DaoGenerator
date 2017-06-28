package com.example;

import org.greenrobot.greendao.generator.Entity;
import org.greenrobot.greendao.generator.Property;
import org.greenrobot.greendao.generator.Schema;

class DistributionHelperDBUtil {

    static void generateDistributionHelperDB(Schema schema) {
        //分配方案表
        Entity plan = schema.addEntity("Plan");
        plan.setDbName("plan");
        plan.addIdProperty().dbName(Constant.DB_NAME_ID);
        plan.addStringProperty("name").dbName(Constant.DB_NAME_NAME).notNull().unique();

        //目标文件夹表
        Entity folder = schema.addEntity("Folder");
        folder.setDbName("folder");
        folder.addIdProperty().dbName(Constant.DB_NAME_ID);
        folder.addStringProperty("path").dbName("path").notNull();

        //文件后缀表
        Entity suffix = schema.addEntity("Suffix");
        suffix.setDbName("suffix");
        suffix.addIdProperty().dbName(Constant.DB_NAME_ID);
        suffix.addStringProperty("name").dbName(Constant.DB_NAME_NAME).notNull();

        //分类表
        Entity category = schema.addEntity("Category");
        category.setDbName("category");
        category.addIdProperty().dbName(Constant.DB_NAME_ID);
        category.addStringProperty("name").dbName(Constant.DB_NAME_NAME).notNull().unique();

        //建立表之间的关联
        //建立多对多关系
//        Entity planAndFolder = schema.addEntity("PlanAndFolder");
//        planAndFolder.setDbName("plan_and_folder");
//        planAndFolder.addIdProperty().dbName(Constant.DB_NAME_ID);
//        Property planId = planAndFolder.addLongProperty("planId").dbName("plan_id").notNull().getProperty();
//        Property folderId = planAndFolder.addLongProperty("folderId").dbName("folder_id").notNull().getProperty();
//        plan.addToMany(folder, planAndFolder, planId, folderId);
//        folder.addToMany(plan, planAndFolder, folderId, planId);

//        Entity folderAndSuffix = schema.addEntity("FolderAndSuffix");
//        folderAndSuffix.setDbName("folder_and_suffix");
//        folderAndSuffix.addIdProperty().dbName(Constant.DB_NAME_ID);
//        Property folderId1 = folderAndSuffix.addLongProperty("folderId").dbName("folder_id").notNull().getProperty();
//        Property suffixId = folderAndSuffix.addLongProperty("suffixId").dbName("suffix_id").notNull().getProperty();
//        suffix.addToMany(folder, folderAndSuffix, suffixId, folderId1);
//        folder.addToMany(suffix, folderAndSuffix, folderId1, suffixId);

//        Entity planAndSuffix = schema.addEntity("PlanAndSuffix");
//        planAndSuffix.setDbName("plan_and_suffix");
//        planAndSuffix.addIdProperty().dbName(Constant.DB_NAME_ID);
//        Property planId1 = planAndSuffix.addLongProperty("planId").dbName("plan_id").notNull().getProperty();
//        Property suffixId1 = planAndSuffix.addLongProperty("suffixId").dbName("suffix_id").notNull().getProperty();
//        plan.addToMany(suffix, planAndSuffix, planId1, suffixId1);
//        suffix.addToMany(plan, planAndSuffix, suffixId1, planId1);

        //一对多关系
        Property planId = folder.addLongProperty("planId").dbName("plan_id").getProperty();
        folder.addToOne(plan,planId).setName("plan");
        plan.addToMany(folder, planId).setName("folderList");

        Property folderId = suffix.addLongProperty("folderId").dbName("folder_id").getProperty();
        suffix.addToOne(folder, folderId).setName("folder");
        folder.addToMany(suffix, folderId).setName("suffixList");

        Property categoryId = suffix.addLongProperty("categoryId").dbName("category_id").getProperty();
        suffix.addToOne(category, categoryId).setName("category");
        category.addToMany(suffix, categoryId).setName("suffixList");
    }
}
