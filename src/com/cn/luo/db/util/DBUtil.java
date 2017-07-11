package com.cn.luo.db.util;

import org.greenrobot.greendao.generator.Schema;

/**
 * AUTHOR:       Luo
 * VERSION:      V1.0
 * DESCRIPTION:  description
 * CREATE TIME:        2017/7/11 14:26
 * NOTE:
 */
public class DBUtil {

    public static final String OUT_DIR = "generated";

    private int version = 1;
    private String defaultJavaPackage;
    private String defaultJavaPackageDao;

    public DBUtil(int version, String defaultJavaPackage, String defaultJavaPackageDao) {
        this.version = version;
        this.defaultJavaPackage = defaultJavaPackage;
        this.defaultJavaPackageDao = defaultJavaPackageDao;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getDefaultJavaPackage() {
        return defaultJavaPackage;
    }

    public void setDefaultJavaPackage(String defaultJavaPackage) {
        this.defaultJavaPackage = defaultJavaPackage;
    }

    public String getDefaultJavaPackageDao() {
        return defaultJavaPackageDao;
    }

    public void setDefaultJavaPackageDao(String defaultJavaPackageDao) {
        this.defaultJavaPackageDao = defaultJavaPackageDao;
    }

    public void generateDB(Schema schema) {

    }
}
