package com.cn.luo.db.util;

import com.cn.luo.db.DBName;
import com.cn.luo.db.PropertyName;
import org.greenrobot.greendao.generator.Entity;
import org.greenrobot.greendao.generator.Schema;

/**
 * AUTHOR:       Luo
 * VERSION:      V1.0
 * DESCRIPTION:  description
 * CREATE TIME:        2017/7/11 10:25
 * NOTE:
 */
public class NoteHelperDBUtil {

    public static final String DATABASE_NAME = "note_helper.db";
    public static final String DEFAULT_JAVA_PACKAGE = "com.cn.luo.helper.note.model.entity";
    public static final String DEFAULT_JAVA_PACKAGE_DAO = "com.cn.luo.helper.note.model.dao";

    public static void generateDistributionHelperDB(Schema schema) {
        // Note table
        Entity note = schema.addEntity("Note");
        note.setDbName(DBName.NOTE);
        note.addIdProperty().dbName(DBName.ID);
        note.addStringProperty(PropertyName.TITLE).dbName(DBName.TITLE).notNull();
        note.addStringProperty(PropertyName.CONTENT).dbName(DBName.CONTENT).notNull();
        note.addDateProperty(PropertyName.CREATE_TIME).dbName(DBName.CREATE_TIME).notNull();

        // Tag table
        Entity tag = schema.addEntity("Tag");
        tag.setDbName(DBName.TAG);
        tag.addIdProperty().dbName(DBName.ID);
        tag.addStringProperty(PropertyName.NAME).dbName(DBName.NAME).notNull();
    }
}
