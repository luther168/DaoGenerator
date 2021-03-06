package com.cn.luo.android.model.dao.note;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.cn.luo.android.model.entity.note.Note;
import com.cn.luo.android.model.entity.note.Tag;
import com.cn.luo.android.model.entity.note.NoteAndTag;

import com.cn.luo.android.model.dao.note.NoteDao;
import com.cn.luo.android.model.dao.note.TagDao;
import com.cn.luo.android.model.dao.note.NoteAndTagDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig noteDaoConfig;
    private final DaoConfig tagDaoConfig;
    private final DaoConfig noteAndTagDaoConfig;

    private final NoteDao noteDao;
    private final TagDao tagDao;
    private final NoteAndTagDao noteAndTagDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        noteDaoConfig = daoConfigMap.get(NoteDao.class).clone();
        noteDaoConfig.initIdentityScope(type);

        tagDaoConfig = daoConfigMap.get(TagDao.class).clone();
        tagDaoConfig.initIdentityScope(type);

        noteAndTagDaoConfig = daoConfigMap.get(NoteAndTagDao.class).clone();
        noteAndTagDaoConfig.initIdentityScope(type);

        noteDao = new NoteDao(noteDaoConfig, this);
        tagDao = new TagDao(tagDaoConfig, this);
        noteAndTagDao = new NoteAndTagDao(noteAndTagDaoConfig, this);

        registerDao(Note.class, noteDao);
        registerDao(Tag.class, tagDao);
        registerDao(NoteAndTag.class, noteAndTagDao);
    }
    
    public void clear() {
        noteDaoConfig.clearIdentityScope();
        tagDaoConfig.clearIdentityScope();
        noteAndTagDaoConfig.clearIdentityScope();
    }

    public NoteDao getNoteDao() {
        return noteDao;
    }

    public TagDao getTagDao() {
        return tagDao;
    }

    public NoteAndTagDao getNoteAndTagDao() {
        return noteAndTagDao;
    }

}
