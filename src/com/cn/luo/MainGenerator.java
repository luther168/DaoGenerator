package com.cn.luo;

import com.cn.luo.db.util.DBUtil;
import com.cn.luo.db.util.DistributionHelperDBUtil;
import com.cn.luo.db.util.NoteHelperDBUtil;
import org.greenrobot.greendao.generator.DaoGenerator;
import org.greenrobot.greendao.generator.Schema;

public class MainGenerator {

    public static void main(String[] args) {
        String generatedDB = NoteHelperDBUtil.DATABASE_NAME;
        DBUtil dbUtil = getDbUtil(generatedDB);

        if (dbUtil != null) {
            Schema schema = new Schema(dbUtil.getVersion(), dbUtil.getDefaultJavaPackage());

            dbUtil.generateDB(schema);
            schema.setDefaultJavaPackageDao(dbUtil.getDefaultJavaPackageDao());
            try {
                new DaoGenerator().generateAll(schema, DBUtil.OUT_DIR);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static DBUtil getDbUtil(String generatedDB) {
        DBUtil dbUtil = null;
        if (generatedDB.equals(DistributionHelperDBUtil.DATABASE_NAME)) {
            dbUtil = new DistributionHelperDBUtil();
        } else if (generatedDB.equals(NoteHelperDBUtil.DATABASE_NAME)) {
            dbUtil = new NoteHelperDBUtil();
        }
        return dbUtil;
    }

}
