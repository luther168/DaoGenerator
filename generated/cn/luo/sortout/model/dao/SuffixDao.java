package cn.luo.sortout.model.dao;

import java.util.List;
import java.util.ArrayList;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.SqlUtils;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.query.Query;
import org.greenrobot.greendao.query.QueryBuilder;

import cn.luo.sortout.model.entity.Category;
import cn.luo.sortout.model.entity.FolderAndSuffix;
import cn.luo.sortout.model.entity.PlanAndSuffix;

import cn.luo.sortout.model.entity.Suffix;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "suffix".
*/
public class SuffixDao extends AbstractDao<Suffix, Long> {

    public static final String TABLENAME = "suffix";

    /**
     * Properties of entity Suffix.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "id");
        public final static Property Name = new Property(1, String.class, "name", false, "name");
        public final static Property CategoryId = new Property(2, Long.class, "categoryId", false, "category_id");
    }

    private DaoSession daoSession;

    private Query<Suffix> folder_SuffixListQuery;
    private Query<Suffix> plan_SuffixListQuery;
    private Query<Suffix> category_SuffixListQuery;

    public SuffixDao(DaoConfig config) {
        super(config);
    }
    
    public SuffixDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"suffix\" (" + //
                "\"id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"name\" TEXT NOT NULL UNIQUE ," + // 1: name
                "\"category_id\" INTEGER);"); // 2: categoryId
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"suffix\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Suffix entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindString(2, entity.getName());
 
        Long categoryId = entity.getCategoryId();
        if (categoryId != null) {
            stmt.bindLong(3, categoryId);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Suffix entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindString(2, entity.getName());
 
        Long categoryId = entity.getCategoryId();
        if (categoryId != null) {
            stmt.bindLong(3, categoryId);
        }
    }

    @Override
    protected final void attachEntity(Suffix entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public Suffix readEntity(Cursor cursor, int offset) {
        Suffix entity = new Suffix( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.getString(offset + 1), // name
            cursor.isNull(offset + 2) ? null : cursor.getLong(offset + 2) // categoryId
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, Suffix entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setName(cursor.getString(offset + 1));
        entity.setCategoryId(cursor.isNull(offset + 2) ? null : cursor.getLong(offset + 2));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(Suffix entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(Suffix entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(Suffix entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
    /** Internal query to resolve the "suffixList" to-many relationship of Folder. */
    public List<Suffix> _queryFolder_SuffixList(long folderId) {
        synchronized (this) {
            if (folder_SuffixListQuery == null) {
                QueryBuilder<Suffix> queryBuilder = queryBuilder();
                queryBuilder.join(FolderAndSuffix.class, FolderAndSuffixDao.Properties.SuffixId)
                    .where(FolderAndSuffixDao.Properties.FolderId.eq(folderId));
                folder_SuffixListQuery = queryBuilder.build();
            }
        }
        Query<Suffix> query = folder_SuffixListQuery.forCurrentThread();
        query.setParameter(0, folderId);
        return query.list();
    }

    /** Internal query to resolve the "suffixList" to-many relationship of Plan. */
    public List<Suffix> _queryPlan_SuffixList(long planId) {
        synchronized (this) {
            if (plan_SuffixListQuery == null) {
                QueryBuilder<Suffix> queryBuilder = queryBuilder();
                queryBuilder.join(PlanAndSuffix.class, PlanAndSuffixDao.Properties.SuffixId)
                    .where(PlanAndSuffixDao.Properties.PlanId.eq(planId));
                plan_SuffixListQuery = queryBuilder.build();
            }
        }
        Query<Suffix> query = plan_SuffixListQuery.forCurrentThread();
        query.setParameter(0, planId);
        return query.list();
    }

    /** Internal query to resolve the "suffixList" to-many relationship of Category. */
    public List<Suffix> _queryCategory_SuffixList(Long categoryId) {
        synchronized (this) {
            if (category_SuffixListQuery == null) {
                QueryBuilder<Suffix> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.CategoryId.eq(null));
                category_SuffixListQuery = queryBuilder.build();
            }
        }
        Query<Suffix> query = category_SuffixListQuery.forCurrentThread();
        query.setParameter(0, categoryId);
        return query.list();
    }

    private String selectDeep;

    protected String getSelectDeep() {
        if (selectDeep == null) {
            StringBuilder builder = new StringBuilder("SELECT ");
            SqlUtils.appendColumns(builder, "T", getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T0", daoSession.getCategoryDao().getAllColumns());
            builder.append(" FROM suffix T");
            builder.append(" LEFT JOIN category T0 ON T.\"category_id\"=T0.\"id\"");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }
    
    protected Suffix loadCurrentDeep(Cursor cursor, boolean lock) {
        Suffix entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        Category category = loadCurrentOther(daoSession.getCategoryDao(), cursor, offset);
        entity.setCategory(category);

        return entity;    
    }

    public Suffix loadDeep(Long key) {
        assertSinglePk();
        if (key == null) {
            return null;
        }

        StringBuilder builder = new StringBuilder(getSelectDeep());
        builder.append("WHERE ");
        SqlUtils.appendColumnsEqValue(builder, "T", getPkColumns());
        String sql = builder.toString();
        
        String[] keyArray = new String[] { key.toString() };
        Cursor cursor = db.rawQuery(sql, keyArray);
        
        try {
            boolean available = cursor.moveToFirst();
            if (!available) {
                return null;
            } else if (!cursor.isLast()) {
                throw new IllegalStateException("Expected unique result, but count was " + cursor.getCount());
            }
            return loadCurrentDeep(cursor, true);
        } finally {
            cursor.close();
        }
    }
    
    /** Reads all available rows from the given cursor and returns a list of new ImageTO objects. */
    public List<Suffix> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<Suffix> list = new ArrayList<Suffix>(count);
        
        if (cursor.moveToFirst()) {
            if (identityScope != null) {
                identityScope.lock();
                identityScope.reserveRoom(count);
            }
            try {
                do {
                    list.add(loadCurrentDeep(cursor, false));
                } while (cursor.moveToNext());
            } finally {
                if (identityScope != null) {
                    identityScope.unlock();
                }
            }
        }
        return list;
    }
    
    protected List<Suffix> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }
    

    /** A raw-style query where you can pass any WHERE clause and arguments. */
    public List<Suffix> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }
 
}