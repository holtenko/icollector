package org.igreenhouse.service;

import org.igreenhouse.domain.DataIn;
import org.igreenhouse.domain.DeviceMap;
import org.igreenhouse.domain.LogDevice;
import org.igreenhouse.helper.DatabaseHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by AllenKO on 2015/11/2.
 */
public class DeviceService {
    private static final Logger LOGGER = LoggerFactory.getLogger(DeviceService.class);

    public static final int serialId2DeviceId(int serialId) {
        String sql = "SELECT * FROM devicemap WHERE serialid=" + serialId;
        DeviceMap deviceMap = DatabaseHelper.queryEntity(DeviceMap.class, sql);
        return deviceMap.getDeviceid();
    }

    private static final LogDevice getStatus(int deviceid) {
        String sql = "SELECT * FROM logdevice WHERE deviceid=" + deviceid + " ORDER BY uid DESC LIMIT 1";
        return DatabaseHelper.queryEntity(LogDevice.class, sql);
    }

    public static final void saveDeviceStatus(DataIn dataIn) {
        LogDevice logDevice = getStatus(dataIn.getDeviceid());
        byte prestatus;
        if (logDevice == null) {
            prestatus = 127;
        } else {
            prestatus = logDevice.getCurstatus();
        }
        if (prestatus != dataIn.getStatus()) {
            Map<String, Object> logMap = new HashMap();
            logMap.put("deviceid", dataIn.getDeviceid());
            logMap.put("prestatus", prestatus);
            logMap.put("curstatus", dataIn.getStatus());
            logMap.put("timestamp", dataIn.getTimestamp());
            DatabaseHelper.insertEntity(LogDevice.class, logMap);
            LOGGER.error("Device status changed. DEVICEID=" + dataIn.getDeviceid());
        }
    }
}
