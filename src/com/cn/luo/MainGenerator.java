package com.cn.luo;

import com.cn.luo.db.util.DistributionHelperDBUtil;
import com.cn.luo.db.util.NoteHelperDBUtil;
import org.greenrobot.greendao.generator.DaoGenerator;
import org.greenrobot.greendao.generator.Schema;

public class MainGenerator {

    public static void main(String[] args) {
        String generatedDB = NoteHelperDBUtil.DATABASE_NAME;
        String defaultJavaPackage = NoteHelperDBUtil.DEFAULT_JAVA_PACKAGE;
        String defaultJavaPackageDao = NoteHelperDBUtil.DEFAULT_JAVA_PACKAGE_DAO;
        Schema schema = new Schema(1, defaultJavaPackage);

        switch (generatedDB) {
            case DistributionHelperDBUtil.DATABASE_NAME:
                DistributionHelperDBUtil.generateDistributionHelperDB(schema);
                break;
            case NoteHelperDBUtil.DATABASE_NAME:
                NoteHelperDBUtil.generateDistributionHelperDB(schema);
                break;
            default:
                break;
        }

        schema.setDefaultJavaPackageDao(defaultJavaPackageDao);
        try {
            String dirPath = "generated";
            new DaoGenerator().generateAll(schema, dirPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
