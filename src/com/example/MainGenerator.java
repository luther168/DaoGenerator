package com.example;

import org.greenrobot.greendao.generator.DaoGenerator;
import org.greenrobot.greendao.generator.Schema;

public class MainGenerator {
    public static void main(String[] args) {
        Schema schema = new Schema(1, "com.cn.luo.helper.distribution.model.entity");
        DistributionHelperDBUtil.generateDistributionHelperDB(schema);
        schema.setDefaultJavaPackageDao("com.cn.luo.helper.distribution.model.dao");
        try {
            String dirPath = "generated";
            new DaoGenerator().generateAll(schema, dirPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
