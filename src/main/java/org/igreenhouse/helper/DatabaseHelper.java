package org.igreenhouse.helper;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.igreenhouse.initiate.DBconf;
import org.igreenhouse.service.LogService;
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
public class DatabaseHelper {
    private static final Logger LOGGER = LoggerFactory.getLogger(DatabaseHelper.class);

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
        DATA_SOURCE.setUrl(DBconf.db_url);
        DATA_SOURCE.setUsername(DBconf.db_username);
        DATA_SOURCE.setPassword(DBconf.db_password);
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
                System.out.println("Connect to " + DATA_SOURCE.getUrl() + " successfully");
            } catch (SQLException e) {
                LOGGER.error("Get connection to database failure", e);
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
    private static int executeUpdate(String sql, Object... params) {
        int rows = 0;
        try {
            Connection conn = getConnection();
            rows = QUERY_RUNNER.update(conn, sql, params);
            //保存数据库操作日志
            LogService.saveSqlLog(LogService.generateSqlLog(sql, params));
        } catch (SQLException e) {
            LOGGER.error("execute update/insert/delete failure", e);
        }
        return rows;
    }

    /**
     * 插入实体
     *
     * @param entityClass
     * @param fieldMap
     * @param <T>
     * @return
     */
    public static <T> boolean insertEntity(Class<T> entityClass, Map<String, Object> fieldMap) {
        String tableName = entityClass.getSimpleName().toLowerCase();
        if (CollectionUtil.isEmpty(fieldMap)) {
            LOGGER.error("Can Not insert entity:fieldMap is empty.");
            return false;
        }
        String sql = "INSERT INTO " + tableName;
        StringBuilder columns = new StringBuilder("(");
        StringBuilder values = new StringBuilder("(");
        for (String fieldName : fieldMap.keySet()) {
            columns.append(fieldName).append(",");
            values.append("?,");
        }
        columns.replace(columns.lastIndexOf(","), columns.length(), ")");
        values.replace(values.lastIndexOf(","), values.length(), ")");
        sql += columns + " VALUES " + values;
        Object[] params = fieldMap.values().toArray();
        return executeUpdate(sql, params) == 1;
    }

    /**
     * 更新
     *
     * @param entityClass
     * @param id
     * @param fieldMap
     * @param <T>
     * @return
     */
    public static <T> boolean updateEntity(Class<T> entityClass, long id, Map<String, Object> fieldMap) {
        String tableName = entityClass.getSimpleName().toLowerCase();
        if (CollectionUtil.isEmpty(fieldMap)) {
            LOGGER.error("Can Not update entity:fieldMap is empty.");
            return false;
        }
        String sql = "UPDATE " + tableName + " SET ";
        StringBuilder columns = new StringBuilder();
        for (String fieldName : fieldMap.keySet()) {
            columns.append(fieldName).append("=?, ");
        }
        sql += columns.substring(0, columns.lastIndexOf(", ")) + " WHERE id=?";

        List<Object> paramList = new ArrayList<Object>();
        paramList.addAll(fieldMap.values());
        paramList.add(id);
        Object[] params = paramList.toArray();
        return executeUpdate(sql, params) == 1;
    }

    /**
     * 删除
     *
     * @param entityClass
     * @param id
     * @param <T>
     * @return
     */
    public static <T> boolean deleteEntity(Class<T> entityClass, long id) {
        String tableName = entityClass.getSimpleName().toLowerCase();
        String sql = "DELETE FROM " + tableName + " WHERE id=?";
        return executeUpdate(sql, id) == 1;
    }

    /**
     * 查询实体类
     *
     * @param entityClass 实体类
     * @param sql         SQL语句
     * @param params
     * @param <T>
     * @return
     */
    public static <T> T queryEntity(Class<T> entityClass, String sql, Object... params) {
        T entity = null;
        try {
            Connection conn = getConnection();
            entity = QUERY_RUNNER.query(conn, sql, new BeanHandler<T>(entityClass), params);
        } catch (SQLException e) {
            LOGGER.error("Query entity failure!", e);
        }
        return entity;
    }

    /**
     * 查询实体类列表
     *
     * @param entityClass 实体类
     * @param sql         SQL语句
     * @param params
     * @param <T>
     * @return
     */
    public static <T> List<T> queryEntityList(Class<T> entityClass, String sql, Object... params) {
        List<T> entityList = null;
        try {
            Connection conn = getConnection();
            entityList = QUERY_RUNNER.query(conn, sql, new BeanListHandler<T>(entityClass), params);
        } catch (SQLException e) {
            LOGGER.error("Query entity list failure!", e);
        }
        return entityList;
    }
}
