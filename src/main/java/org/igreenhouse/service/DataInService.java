package org.igreenhouse.service;

import org.igreenhouse.domain.DataIn;
import org.igreenhouse.domain.Indoor;
import org.igreenhouse.helper.DatabaseHelper;
import org.igreenhouse.util.ByteUtil;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by AllenKO on 2015/11/3.
 * 用于操作室内数据的类
 */
public class DataInService {
    /**
     * 将室内数据字节数组转换为室内数据实体类
     *
     * @param dataInBytes 室内数据字节数组
     * @return 室内数据实体类
     */
    public static final DataIn parseDataIn(byte[] dataInBytes) {

        byte[] serialIdBytes = new byte[4];// 建立设备串口id字节数组
        System.arraycopy(dataInBytes, 3, serialIdBytes, 2, 2);// 截取数据包4~5位为设备串口id
        int serialId = ByteUtil.bytesToInt(serialIdBytes);// 将字节数组转化为整型数

        int deviceId = DeviceService.serialId2DeviceId(serialId);// 根据设备串口id找到设备id
        Timestamp timestamp = new Timestamp(System.currentTimeMillis() - 10 * 1000);//将当前时间向前推10s作为数据时间戳
        //从第7位开始依次向后推5位为一个数据
        float airtemp = Float.parseFloat(new String(dataInBytes, 7, 5));
        float airhum = Float.parseFloat(new String(dataInBytes, 7 + 5, 5));
        float soiltemp = Float.parseFloat(new String(dataInBytes, 7 + 5 * 2, 5));
        float soilhum = Float.parseFloat(new String(dataInBytes, 7 + 5 * 3, 5));
        float light = Float.parseFloat(new String(dataInBytes, 7 + 5 * 4, 5));

        DataIn dataIn = new DataIn(timestamp,0,0,0,0,0,0);
        dataIn.setDeviceid(deviceId);
        dataIn.setTimestamp(timestamp);
        dataIn.setAirtemp(airtemp);
        dataIn.setAirhum(airhum);
        dataIn.setSoiltemp(soiltemp);
        dataIn.setSoilhum(soilhum);
        dataIn.setLight(light);
        return dataIn;
    }

    /**
     * 保存室内数据到数据库
     *
     * @param data 室内数据实体类
     * @return 保存结果
     */
    public static boolean saveDataIn(DataIn data) {
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("deviceid", data.getDeviceid());
        dataMap.put("timestamp", data.getTimestamp());
        dataMap.put("airtemp", data.getAirtemp());
        dataMap.put("airhum", data.getAirhum());
        dataMap.put("soiltemp", data.getSoiltemp());
        dataMap.put("soilhum", data.getSoilhum());
        dataMap.put("light", data.getLight());
        return DatabaseHelper.insertEntity(DataIn.class, dataMap);
    }

    /**
     * 保存室内平均数据到数据库
     *
     * @param data 室内数据实体类
     * @return 保存结果
     */
    public static boolean saveIndoor(Indoor data) {
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("timestamp", data.getTimestamp());
        dataMap.put("airtemp", data.getAirtemp());
        dataMap.put("airhum", data.getAirhum());
        dataMap.put("soiltemp", data.getSoiltemp());
        dataMap.put("soilhum", data.getSoilhum());
        dataMap.put("light", data.getLight());
        return DatabaseHelper.insertEntity(Indoor.class, dataMap);
    }
}
