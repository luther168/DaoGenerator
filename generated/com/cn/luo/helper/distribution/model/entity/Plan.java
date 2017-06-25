package com.cn.luo.helper.distribution.model.entity;

import org.greenrobot.greendao.annotation.*;

import java.util.List;
import com.cn.luo.helper.distribution.model.dao.DaoSession;
import org.greenrobot.greendao.DaoException;

import com.cn.luo.helper.distribution.model.dao.FolderDao;
import com.cn.luo.helper.distribution.model.dao.PlanDao;
import com.cn.luo.helper.distribution.model.dao.SuffixDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit.

/**
 * Entity mapped to table "plan".
 */
@Entity(active = true, nameInDb = "plan")
public class Plan {

    @Id
    @Property(nameInDb = "id")
    private Long id;

    @Property(nameInDb = "name")
    @NotNull
    @Unique
    private String name;

    /** Used to resolve relations */
    @Generated
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    @Generated
    private transient PlanDao myDao;

    @ToMany
    @JoinEntity(entity = PlanAndFolder.class, sourceProperty = "planId", targetProperty = "folderId")
    private List<Folder> folderList;

    @ToMany
    @JoinEntity(entity = PlanAndSuffix.class, sourceProperty = "planId", targetProperty = "suffixId")
    private List<Suffix> suffixList;

    @Generated
    public Plan() {
    }

    public Plan(Long id) {
        this.id = id;
    }

    @Generated
    public Plan(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getPlanDao() : null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NotNull
    public String getName() {
        return name;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setName(@NotNull String name) {
        this.name = name;
    }

    /** To-many relationship, resolved on first access (and after reset). Changes to to-many relations are not persisted, make changes to the target entity. */
    @Generated
    public List<Folder> getFolderList() {
        if (folderList == null) {
            __throwIfDetached();
            FolderDao targetDao = daoSession.getFolderDao();
            List<Folder> folderListNew = targetDao._queryPlan_FolderList(id);
            synchronized (this) {
                if(folderList == null) {
                    folderList = folderListNew;
                }
            }
        }
        return folderList;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated
    public synchronized void resetFolderList() {
        folderList = null;
    }

    /** To-many relationship, resolved on first access (and after reset). Changes to to-many relations are not persisted, make changes to the target entity. */
    @Generated
    public List<Suffix> getSuffixList() {
        if (suffixList == null) {
            __throwIfDetached();
            SuffixDao targetDao = daoSession.getSuffixDao();
            List<Suffix> suffixListNew = targetDao._queryPlan_SuffixList(id);
            synchronized (this) {
                if(suffixList == null) {
                    suffixList = suffixListNew;
                }
            }
        }
        return suffixList;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated
    public synchronized void resetSuffixList() {
        suffixList = null;
    }

    /**
    * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
    * Entity must attached to an entity context.
    */
    @Generated
    public void delete() {
        __throwIfDetached();
        myDao.delete(this);
    }

    /**
    * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
    * Entity must attached to an entity context.
    */
    @Generated
    public void update() {
        __throwIfDetached();
        myDao.update(this);
    }

    /**
    * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
    * Entity must attached to an entity context.
    */
    @Generated
    public void refresh() {
        __throwIfDetached();
        myDao.refresh(this);
    }

    @Generated
    private void __throwIfDetached() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
    }

}