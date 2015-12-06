package org.igreenhouse.initiate;

import org.igreenhouse.util.PropsUtil;

import java.util.Properties;

/**
 * Created by AllenKO on 2015/12/2.
 */
public class DBconf {
    private static final Properties conf = PropsUtil.loadProps("dbconfig.properties");
    public static final String db_driver;
    public static final String db_name;
    public static final String db_url;
    public static final String db_username;
    public static final String db_password;
    public static final String logdb_url;

    public static final String clouddb_name;
    public static final String clouddb_url;
    public static final String clouddb_username;
    public static final String clouddb_password;


    //进行初始化工作
    static {
        // 数据库相关属性
        db_driver = PropsUtil.getString(conf, "driver");
        db_name = PropsUtil.getString(conf, "dbname");
        db_url = PropsUtil.getString(conf, "url") + db_name;
        db_username = PropsUtil.getString(conf, "user");
        db_password = PropsUtil.getString(conf, "password");

        logdb_url = PropsUtil.getString(conf, "url") + "logs";

        clouddb_name = PropsUtil.getString(conf, "clouddbname");
        clouddb_url = PropsUtil.getString(conf, "cloudurl") + clouddb_name;
        clouddb_username = PropsUtil.getString(conf, "clouduser");
        clouddb_password = PropsUtil.getString(conf, "cloudpassword");
    }
}
