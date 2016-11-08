package org.igreenhouse.service;

import org.igreenhouse.config.Configuration;
import org.igreenhouse.helper.DataBaseHelper;
import org.igreenhouse.model.Device;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by holten on 2015/11/3. 用于解析数据的类
 */
public class ParseAndSaveDataService {
    public static final BlockingQueue dataShowQueue = new LinkedBlockingQueue();

    public static void parseIndoorPackage(Map<String, Object> dataPackageMap) {
        byte[] dataPackage = (byte[]) dataPackageMap.get("data");
        Timestamp sampleTime = (Timestamp) dataPackageMap.get("sampletime");

        int serialIdBytes = dataPackage[1];// 建立设备串口id字节数组
        int serialId = (serialIdBytes / 16 * 10) + (serialIdBytes % 16);
        int deviceId = serialId2DeviceId(serialId);// 根据设备串口id找到设备id

        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("deviceid", deviceId);
        dataMap.put("sampletime", sampleTime);

        //从第2位开始依次向后推5位为一个数据
        float airtemp = Float.parseFloat(new String(dataPackage, 2, 5));
        dataMap.put("value", airtemp);
        DataBaseHelper.insertEntity("t_airtemp", dataMap);

        float airhum = Float.parseFloat(new String(dataPackage, 2 + 5, 5));
        dataMap.put("value", airhum);
        DataBaseHelper.insertEntity("t_airhumidity", dataMap);

        if (dataPackage.length > 13) {
            float soiltemp = Float.parseFloat(new String(dataPackage, 2 + 5 * 2, 5));
            dataMap.put("value", soiltemp);
            DataBaseHelper.insertEntity("t_soiltemp", dataMap);
            float soilhum = Float.parseFloat(new String(dataPackage, 2 + 5 * 3, 5));
            dataMap.put("value", soilhum);
            DataBaseHelper.insertEntity("t_soilhumidity", dataMap);
            float light = Float.parseFloat(new String(dataPackage, 2 + 5 * 4, 5));
            dataMap.put("value", light);
            DataBaseHelper.insertEntity("t_light", dataMap);
        }

        putDataShowQueue(serialId,"in","AT:" + airtemp + ",AH:" + airhum);
    }

    public static void parseOutdoorPackage(Map<String, Object> dataPackageMap) {
        byte[] dataPackage = (byte[]) dataPackageMap.get("data");
        Timestamp sampleTime = (Timestamp) dataPackageMap.get("sampletime");
        long deviceId = Configuration.WeatherStationID;
        String[] outdoor = new String(dataPackage, 1, dataPackage.length - 2).split(",");

        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("deviceid", deviceId);
        dataMap.put("sampletime", sampleTime);
        if (outdoor.length > 1) {
            float windspeed = Float.parseFloat(outdoor[0]);
            dataMap.put("value", windspeed);
            DataBaseHelper.insertEntity("t_windspeed", dataMap);
            float winddirect = Float.parseFloat(outdoor[1]);
            dataMap.put("value", winddirect);
            DataBaseHelper.insertEntity("t_winddirect", dataMap);
            float airhum = Float.parseFloat(outdoor[2]);
            dataMap.put("value", airhum);
            DataBaseHelper.insertEntity("t_airhumidity", dataMap);
            float airtemp = Float.parseFloat(outdoor[3]);
            dataMap.put("value", airtemp);
            DataBaseHelper.insertEntity("t_airtemp", dataMap);
            float atmosphere = Float.parseFloat(outdoor[4]);
            dataMap.put("value", atmosphere);
            DataBaseHelper.insertEntity("t_atmosphere", dataMap);

            putDataShowQueue(deviceId, "out", "T:" + airtemp + ",H:" + airhum + "D:" + winddirect + "S:" + windspeed + "A:" + atmosphere);
        } else {
            float rainfall = Float.parseFloat(outdoor[0]);
            dataMap.put("value", rainfall);
            DataBaseHelper.insertEntity("t_rainfall", dataMap);

            putDataShowQueue(deviceId, "rf",rainfall+"");
        }
    }


    public static void parseSolarRadiationPackage(Map<String, Object> dataPackageMap) {
        byte[] dataPackage = (byte[]) dataPackageMap.get("data");
        Timestamp sampleTime = (Timestamp) dataPackageMap.get("sampletime");
        long deviceId = Configuration.SolarRadiationID;

        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("deviceid", deviceId);
        dataMap.put("timestamp", sampleTime);

        float solarRadiation = Float.parseFloat(new String(dataPackage, 1, dataPackage.length - 2));
        dataMap.put("value", solarRadiation);
        DataBaseHelper.insertEntity("t_solar", dataMap);

        putDataShowQueue(deviceId,"sr",solarRadiation+"");
    }

    private static void putDataShowQueue(long id, String type, String data) {
        try {
            Map<String, Object> dataShowMap = new HashMap<>();
            dataShowMap.put("id", id);
            dataShowMap.put("type", type);
            dataShowMap.put("data", data);
            dataShowQueue.put(dataShowMap);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static int serialId2DeviceId(int serialId) {
        String sql = "SELECT * FROM device WHERE serialid=" + serialId;
        Device deviceMap = DataBaseHelper.queryEntity(Device.class, sql);
        return deviceMap.getId();
    }
}
