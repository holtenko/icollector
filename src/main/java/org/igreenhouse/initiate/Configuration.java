package org.igreenhouse.initiate;

import org.igreenhouse.util.PropsUtil;

import java.util.Properties;

/**
 * Created by AllenKO on 2015/12/2.
 */
public class Configuration {
    //加载设备配置文件
    private static final Properties conf = PropsUtil.loadProps("conf.properties");
    public static final int WeatherStationID;
    public static final int OutdoorAcqDelay;
    public static final int OutdoorAcqCycle;
    public static final int AverageAcqDelay;
    public static final int AverageAcqCycle;
    public static final int UploadDelay;
    public static final int UploadCycle;
    public static final int LogValidity;

    //进行初始化工作
    static {
        // 获取设备配置参数
        WeatherStationID = PropsUtil.getInt(conf, "weather_station_ID");
        OutdoorAcqDelay =PropsUtil.getInt(conf, "outdoor_acq_delay");
        OutdoorAcqCycle =PropsUtil.getInt(conf, "outdoor_acq_cycle");
        AverageAcqDelay =PropsUtil.getInt(conf, "average_acq_delay");
        AverageAcqCycle =PropsUtil.getInt(conf, "average_acq_cycle");
        UploadDelay =PropsUtil.getInt(conf, "upload_delay");
        UploadCycle =PropsUtil.getInt(conf, "upload_cycle");
        LogValidity =PropsUtil.getInt(conf, "log_validity");
    }
}
