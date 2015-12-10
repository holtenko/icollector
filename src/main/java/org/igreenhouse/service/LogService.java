package org.igreenhouse.service;

import org.igreenhouse.domain.SqlLog;
import org.igreenhouse.helper.DatabaseHelper;
import org.igreenhouse.initiate.DBconf;
import org.igreenhouse.helper.LogDBHelper;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by AllenKO on 2015/12/2.
 */
public class LogService {

    public static SqlLog generateSqlLog(String sql, Object... params) {
        SqlLog sqlLog = new SqlLog();
        String paramString = "";
        for (Object param : params) {
            paramString = paramString + param + ",";
        }
        sqlLog.setDbname(DBconf.db_name);
        sqlLog.setSqlstatement(sql);
        sqlLog.setParameters(paramString);
        sqlLog.setTimestamp(new Timestamp(System.currentTimeMillis()));
        sqlLog.setStatus(0);
        return sqlLog;
    }

    public static boolean saveSqlLog(SqlLog data) {
        Map<String, Object> logMap = new HashMap();
        logMap.put("dbname", data.getDbname());
        logMap.put("sqlstatement", data.getSqlstatement());
        logMap.put("parameters", data.getParameters());
        logMap.put("timestamp", data.getTimestamp());
        logMap.put("status", data.getStatus());
        return LogDBHelper.insertEntity(SqlLog.class, logMap);
    }

    public static void truncateSqlLog() {
        LogDBHelper.truncateTable("sqllog");
    }

    public static List<SqlLog> getUnsyncLog() {
        String sql = "SELECT * FROM sqllog WHERE status=0";
        return LogDBHelper.queryEntityList(SqlLog.class, sql);
    }

    public static boolean setLogStatus(int id) {
        Map<String, Object> logMap = new HashMap();
        logMap.put("status", 1);
        return LogDBHelper.updateEntity(SqlLog.class, id, logMap);
    }


}
