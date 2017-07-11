package com.cn.luo.helper.note.model.dao;

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

import com.cn.luo.helper.note.model.entity.NoteAndTag;

import com.cn.luo.helper.note.model.entity.Note;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "note".
*/
public class NoteDao extends AbstractDao<Note, Long> {

    public static final String TABLENAME = "note";

    /**
     * Properties of entity Note.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "id");
        public final static Property Title = new Property(1, String.class, "title", false, "title");
        public final static Property Content = new Property(2, String.class, "content", false, "content");
        public final static Property Create_time = new Property(3, java.util.Date.class, "create_time", false, "create_time");
    }

    private DaoSession daoSession;

    private Query<Note> tag_NoteListQuery;

    public NoteDao(DaoConfig config) {
        super(config);
    }
    
    public NoteDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"note\" (" + //
                "\"id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"title\" TEXT NOT NULL ," + // 1: title
                "\"content\" TEXT NOT NULL ," + // 2: content
                "\"create_time\" INTEGER NOT NULL );"); // 3: create_time
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"note\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Note entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindString(2, entity.getTitle());
        stmt.bindString(3, entity.getContent());
        stmt.bindLong(4, entity.getCreate_time().getTime());
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Note entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindString(2, entity.getTitle());
        stmt.bindString(3, entity.getContent());
        stmt.bindLong(4, entity.getCreate_time().getTime());
    }

    @Override
    protected final void attachEntity(Note entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public Note readEntity(Cursor cursor, int offset) {
        Note entity = new Note( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.getString(offset + 1), // title
            cursor.getString(offset + 2), // content
            new java.util.Date(cursor.getLong(offset + 3)) // create_time
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, Note entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setTitle(cursor.getString(offset + 1));
        entity.setContent(cursor.getString(offset + 2));
        entity.setCreate_time(new java.util.Date(cursor.getLong(offset + 3)));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(Note entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(Note entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(Note entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
    /** Internal query to resolve the "noteList" to-many relationship of Tag. */
    public List<Note> _queryTag_NoteList(long tagId) {
        synchronized (this) {
            if (tag_NoteListQuery == null) {
                QueryBuilder<Note> queryBuilder = queryBuilder();
                queryBuilder.join(NoteAndTag.class, NoteAndTagDao.Properties.NoteId)
                    .where(NoteAndTagDao.Properties.TagId.eq(tagId));
                tag_NoteListQuery = queryBuilder.build();
            }
        }
        Query<Note> query = tag_NoteListQuery.forCurrentThread();
        query.setParameter(0, tagId);
        return query.list();
    }

}
