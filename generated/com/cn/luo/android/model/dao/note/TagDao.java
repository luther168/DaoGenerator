package com.cn.luo.android.model.dao.note;

import java.util.List;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.query.Query;
import org.greenrobot.greendao.query.QueryBuilder;

import com.cn.luo.android.model.entity.note.NoteAndTag;

import com.cn.luo.android.model.entity.note.Tag;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "tag".
*/
public class TagDao extends AbstractDao<Tag, Long> {

    public static final String TABLENAME = "tag";

    /**
     * Properties of entity Tag.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "id");
        public final static Property Name = new Property(1, String.class, "name", false, "name");
    }

    private DaoSession daoSession;

    private Query<Tag> note_TagListQuery;

    public TagDao(DaoConfig config) {
        super(config);
    }
    
    public TagDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"tag\" (" + //
                "\"id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"name\" TEXT NOT NULL UNIQUE );"); // 1: name
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"tag\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Tag entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindString(2, entity.getName());
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Tag entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindString(2, entity.getName());
    }

    @Override
    protected final void attachEntity(Tag entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public Tag readEntity(Cursor cursor, int offset) {
        Tag entity = new Tag( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.getString(offset + 1) // name
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, Tag entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setName(cursor.getString(offset + 1));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(Tag entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(Tag entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(Tag entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
    /** Internal query to resolve the "tagList" to-many relationship of Note. */
    public List<Tag> _queryNote_TagList(long noteId) {
        synchronized (this) {
            if (note_TagListQuery == null) {
                QueryBuilder<Tag> queryBuilder = queryBuilder();
                queryBuilder.join(NoteAndTag.class, NoteAndTagDao.Properties.TagId)
                    .where(NoteAndTagDao.Properties.NoteId.eq(noteId));
                note_TagListQuery = queryBuilder.build();
            }
        }
        Query<Tag> query = note_TagListQuery.forCurrentThread();
        query.setParameter(0, noteId);
        return query.list();
    }

}
