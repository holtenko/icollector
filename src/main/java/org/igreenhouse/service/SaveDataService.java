package org.igreenhouse.service;

import org.igreenhouse.dao.DataIn;
import org.igreenhouse.dao.DataOut;
import org.igreenhouse.helper.DataBaseHelper;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by holten.gao on 2016/7/14.
 */
public class SaveDataService {

    public static boolean saveDataIn(DataIn data) {
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("deviceid", data.getDeviceid());
        dataMap.put("timestamp", data.getTimestamp());
        dataMap.put("airtemp", data.getAirtemp());
        dataMap.put("airhum", data.getAirhum());
        dataMap.put("soiltemp", data.getSoiltemp());
        dataMap.put("soilhum", data.getSoilhum());
        dataMap.put("light", data.getLight());
        return DataBaseHelper.insertEntity(DataIn.class, dataMap);
    }
    
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
        return DataBaseHelper.insertEntity(DataOut.class, dataMap);
    }
}
