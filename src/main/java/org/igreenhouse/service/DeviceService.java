package org.igreenhouse.service;

import org.igreenhouse.domain.DeviceMap;
import org.igreenhouse.helper.DatabaseHelper;


/**
 * Created by AllenKO on 2015/11/2.
 */
public class DeviceService {
    public static final int serialId2DeviceId(int serialId) {
        String sql = "SELECT * FROM devicemap WHERE serialid=" + serialId;
        DeviceMap deviceMap = DatabaseHelper.queryEntity(DeviceMap.class, sql);
        return deviceMap.getDeviceid();
    }
}
