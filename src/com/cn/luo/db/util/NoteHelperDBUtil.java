package com.cn.luo.db.util;

import com.cn.luo.db.DBName;
import com.cn.luo.db.PropertyName;
import org.greenrobot.greendao.generator.Entity;
import org.greenrobot.greendao.generator.Property;
import org.greenrobot.greendao.generator.Schema;

/**
 * AUTHOR:       Luo
 * VERSION:      V1.0
 * DESCRIPTION:  description
 * CREATE TIME:        2017/7/11 10:25
 * NOTE:
 */
public class NoteHelperDBUtil extends DBUtil {

    public static final String DATABASE_NAME = "note_helper.db";
    public static final int DATABASE_VERSION = 1;
    public static final String DEFAULT_JAVA_PACKAGE = "com.cn.luo.android.model.entity.note";
    public static final String DEFAULT_JAVA_PACKAGE_DAO = "com.cn.luo.android.model.dao.note";

    public NoteHelperDBUtil() {
        super(DATABASE_VERSION, DEFAULT_JAVA_PACKAGE, DEFAULT_JAVA_PACKAGE_DAO);
    }

    @Override
    public void generateDB(Schema schema) {
        // Note table
        Entity note = schema.addEntity("Note");
        note.setDbName(DBName.NOTE);
        note.addIdProperty().dbName(DBName.ID);
        note.addStringProperty(PropertyName.TITLE).dbName(DBName.TITLE).notNull().unique();
        note.addStringProperty(PropertyName.CONTENT).dbName(DBName.CONTENT).notNull();
        note.addDateProperty(PropertyName.CREATE_TIME).dbName(DBName.CREATED_TIME).notNull();
        note.addDateProperty(PropertyName.MODIFY_TIM).dbName(DBName.MODIFIED_TIME).notNull();

        // Tag table
        Entity tag = schema.addEntity("Tag");
        tag.setDbName(DBName.TAG);
        tag.addIdProperty().dbName(DBName.ID);
        tag.addStringProperty(PropertyName.NAME).dbName(DBName.NAME).notNull().unique();

        // Build the relationship between tables
        // Build the many-to-many relationship
        Entity noteAndTag = schema.addEntity("NoteAndTag");
        noteAndTag.setDbName("note_and_tag");
        noteAndTag.addIdProperty().dbName(DBName.ID);
        Property noteId = noteAndTag.addLongProperty("noteId").dbName("note_id").notNull().getProperty();
        Property tagId = noteAndTag.addLongProperty("tagId").dbName("tag_id").notNull().getProperty();
        note.addToMany(tag, noteAndTag, noteId, tagId);
        tag.addToMany(note, noteAndTag, tagId, noteId);
    }
}
