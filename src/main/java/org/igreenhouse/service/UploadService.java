package org.igreenhouse.service;

import org.igreenhouse.domain.SqlLog;
import org.igreenhouse.helper.CloudDBHelper;
import org.igreenhouse.initiate.Configuration;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by AllenKO on 2015/12/3.
 */
public class UploadService {
    private static boolean saveLogToCloud(SqlLog log) {
        String sql = log.getSqlstatement();
        Object[] params = log.getParameters().split(",");
        return CloudDBHelper.executeUpdate(sql, params) == 1;
    }

    private static void clearSqlLog(int failnum, SqlLog log) {
        //同步全部成功，且日志总数大于日志有效数目，则清空日志表
        if (0 == failnum & log.getUid() > Configuration.LogValidity) {
            LogService.truncateSqlLog();
            System.out.println("Clear Log at " + new Timestamp(System.currentTimeMillis()));
        }
    }

    public static int[] uploadToCloud() {
        List<SqlLog> unsyncLog = LogService.getUnsyncLog();
        int[] uploadinfo = new int[2];//第一位为总数，第二位为上传失败的数量
        uploadinfo[0] = unsyncLog.size();
        //如果未同步SQL列表不为空，则进行同步
        if (0 != uploadinfo[0]) {
            for (SqlLog log : unsyncLog) {
                if (saveLogToCloud(log)) {
                    LogService.setLogStatus(log.getUid());
                } else {
                    if (saveLogToCloud(log)) {
                        LogService.setLogStatus(log.getUid());
                    } else {
                        uploadinfo[1]++;
                        System.out.println("Upload " + log.getUid() + " to Cloud Failure.");
                    }
                }
            }
            clearSqlLog(uploadinfo[1], unsyncLog.get(0));
        }
        return uploadinfo;
    }
}
