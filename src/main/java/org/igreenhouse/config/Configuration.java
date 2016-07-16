package org.igreenhouse.config;

import org.igreenhouse.util.PropsUtil;

import java.util.Properties;

/**
 * Created by holten.gao on 2016/7/13.
 */


public class Configuration {
    //加载设备配置文件
    private static final Properties conf = PropsUtil.loadProps("conf.properties");
    private static final Properties dbconf = PropsUtil.loadProps("dbconfig.properties");

    public static final int WeatherStationID;
    public static final int OutdoorAcqDelay;
    public static final int OutdoorAcqCycle;
    public static final int SolarRadiationAcqDelay;
    public static final int SolarRadiationAcqCycle;


    public static final int ZCNum;
    public static final int WeatherStationNum;
    public static final int SolarRadiationNum;


    public static final String db_driver;
    public static final String db_name;
    public static final String db_url;
    public static final String db_username;
    public static final String db_password;

    public static final String clouddb_name;
    public static final String clouddb_url;
    public static final String clouddb_username;
    public static final String clouddb_password;

    //进行初始化工作
    static {
        // 获取设备配置参数
        WeatherStationID = PropsUtil.getInt(conf, "weather_station_ID");
        OutdoorAcqDelay = PropsUtil.getInt(conf, "outdoor_acq_delay");
        OutdoorAcqCycle = PropsUtil.getInt(conf, "outdoor_acq_cycle");
        SolarRadiationAcqDelay = PropsUtil.getInt(conf, "solar_radiation_acq_delay");
        SolarRadiationAcqCycle = PropsUtil.getInt(conf, "solar_radiation_acq_cycle");

        ZCNum = PropsUtil.getInt(conf, "zc_num");
        WeatherStationNum = PropsUtil.getInt(conf, "weather_station_num");
        SolarRadiationNum=PropsUtil.getInt(conf,"solar_radiation_num");

        // 数据库相关属性
        db_driver = PropsUtil.getString(dbconf, "driver");
        db_name = PropsUtil.getString(dbconf, "dbname");
        db_url = PropsUtil.getString(dbconf, "url") + db_name;
        db_username = PropsUtil.getString(dbconf, "user");
        db_password = PropsUtil.getString(dbconf, "password");
        clouddb_name = PropsUtil.getString(dbconf, "clouddbname");
        clouddb_url = PropsUtil.getString(dbconf, "cloudurl") + clouddb_name;
        clouddb_username = PropsUtil.getString(dbconf, "clouduser");
        clouddb_password = PropsUtil.getString(dbconf, "cloudpassword");
    }
}
