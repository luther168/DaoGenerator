package cn.luo.sortout.model.entity;

import org.greenrobot.greendao.annotation.*;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit.

/**
 * Entity mapped to table "plan_and_suffix".
 */
@Entity(nameInDb = "plan_and_suffix")
public class PlanAndSuffix {

    @Id
    @Property(nameInDb = "id")
    private Long id;

    @Property(nameInDb = "plan_id")
    private long planId;

    @Property(nameInDb = "suffix_id")
    private long suffixId;

    @Generated
    public PlanAndSuffix() {
    }

    public PlanAndSuffix(Long id) {
        this.id = id;
    }

    @Generated
    public PlanAndSuffix(Long id, long planId, long suffixId) {
        this.id = id;
        this.planId = planId;
        this.suffixId = suffixId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getPlanId() {
        return planId;
    }

    public void setPlanId(long planId) {
        this.planId = planId;
    }

    public long getSuffixId() {
        return suffixId;
    }

    public void setSuffixId(long suffixId) {
        this.suffixId = suffixId;
    }

}
