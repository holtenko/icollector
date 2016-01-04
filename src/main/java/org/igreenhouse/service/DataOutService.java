package org.igreenhouse.service;

import org.igreenhouse.domain.DataOut;
import org.igreenhouse.domain.Outdoor;
import org.igreenhouse.helper.DatabaseHelper;
import org.igreenhouse.util.ByteUtil;
import org.igreenhouse.util.SplitUtil;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by AllenKO on 2015/11/3.
 * 用于操作室外数据的类
 */
public class DataOutService {
    /**
     * 将室外数据字节数组转换为室外数据实体类
     *
     * @param dataOutByte 室外数据字节数组
     * @param deviceid    室外气象站DeviceID
     * @return 室外数据实体类
     */
    public static final DataOut parseDataOut(byte[][] dataOutByte, int deviceid) {
        DataOut dataOut = new DataOut();

        byte[] rainfallBytes = new byte[dataOutByte[0].length - 2];
        byte[] otherFiveBytes = new byte[dataOutByte[1].length - 2];
        System.arraycopy(dataOutByte[0], 1, rainfallBytes, 0, rainfallBytes.length);
        System.arraycopy(dataOutByte[1], 1, otherFiveBytes, 0, otherFiveBytes.length);
        String[] otherFive = SplitUtil.splitString(new String(otherFiveBytes, 0, otherFiveBytes.length), ",");

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        float windspeed = Float.parseFloat(otherFive[0]);
        float winddirect = Float.parseFloat(otherFive[1]);
        float airhum = Float.parseFloat(otherFive[2]);
        float airtemp = Float.parseFloat(otherFive[3]);
        float atmosphere = Float.parseFloat(otherFive[4]);
        float rainfall = Float.parseFloat(ByteUtil.bytesToString(rainfallBytes));

        dataOut.setDeviceid(deviceid);
        dataOut.setTimestamp(timestamp);
        dataOut.setAirtemp(airtemp);
        dataOut.setAirhum(airhum);
        dataOut.setWinddirect(winddirect);
        dataOut.setWindspeed(windspeed);
        dataOut.setAtmosphere(atmosphere);
        dataOut.setRainfall(rainfall);
        return dataOut;
    }

    /**
     * 保存室外数据到数据库
     *
     * @param data 室外数据实体类
     * @return 保存结果
     */
    public static boolean saveDataOut(DataOut data) {
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("deviceid", data.getDeviceid());
        dataMap.put("timestamp", data.getTimestamp());
        dataMap.put("airtemp", data.getAirtemp());
        dataMap.put("airhum", data.getAirhum());
        dataMap.put("winddirect", data.getWinddirect());
        dataMap.put("windspeed", data.getWindspeed());
        dataMap.put("atmosphere", data.getAtmosphere());
        dataMap.put("rainfall", data.getRainfall());
        return DatabaseHelper.insertEntity(DataOut.class, dataMap);
    }

    /**
     * 保存室外平均数据到数据库
     *
     * @param data 室外数据实体类
     * @return 保存结果
     */
    public static boolean saveOutdoor(Outdoor data) {
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("timestamp", data.getTimestamp());
        dataMap.put("airtemp", data.getAirtemp());
        dataMap.put("airhum", data.getAirhum());
        dataMap.put("winddirect", data.getWinddirect());
        dataMap.put("windspeed", data.getWindspeed());
        dataMap.put("atmosphere", data.getAtmosphere());
        dataMap.put("rainfall", data.getRainfall());
        return DatabaseHelper.insertEntity(Outdoor.class, dataMap);
    }
}
