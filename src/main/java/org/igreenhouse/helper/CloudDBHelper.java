package org.igreenhouse.helper;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.igreenhouse.initiate.DBconf;
import org.igreenhouse.util.CollectionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by AllenKO on 2015/11/30.
 */
public class CloudDBHelper {
    private static final Logger LOGGER = LoggerFactory.getLogger(CloudDBHelper.class);

    private static final ThreadLocal<Connection> CONNECTION_HOLDER;
    private static final QueryRunner QUERY_RUNNER;
    private static final BasicDataSource DATA_SOURCE;

    //进行初始化工作
    static {
        CONNECTION_HOLDER = new ThreadLocal<Connection>();
        QUERY_RUNNER = new QueryRunner();

        //配置数据库连接池
        DATA_SOURCE = new BasicDataSource();
        DATA_SOURCE.setDriverClassName(DBconf.db_driver);
        DATA_SOURCE.setUrl(DBconf.clouddb_url);
        DATA_SOURCE.setUsername(DBconf.clouddb_username);
        DATA_SOURCE.setPassword(DBconf.clouddb_password);
    }

    /**
     * 获取数据库连接
     *
     * @return 数据库连接
     */
    private static Connection getConnection() {
        Connection conn = CONNECTION_HOLDER.get();
        if (conn == null) {
            try {
                conn = DATA_SOURCE.getConnection();
                System.out.println("Connect to "+DATA_SOURCE.getUrl()+" successfully");
            } catch (SQLException e) {
                LOGGER.error("Get connection to "+DATA_SOURCE.getUrl()+" failure", e);
            } finally {
                CONNECTION_HOLDER.set(conn);
            }
        }
        return conn;
    }

    /**
     * 执行增/删/改
     *
     * @param sql    SQL语句
     * @param params
     * @return 受影响行数
     */
    public static int executeUpdate(String sql, Object... params) {
        int rows = 0;
        try {
            Connection conn = getConnection();
            rows = QUERY_RUNNER.update(conn, sql, params);
        } catch (SQLException e) {
            LOGGER.error("execute update/insert/delete failure", e);
        }
        return rows;
    }
}
