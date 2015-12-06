package org.igreenhouse.domain;

/**
 * Created by AllenKO on 2015/11/2.
 * 串口ID和设备ID对应关系实体类
 */
public class DeviceMap {
    private int id;
    private int serialid;
    private int deviceid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSerialid() {
        return serialid;
    }

    public void setSerialid(int serialid) {
        this.serialid = serialid;
    }

    public int getDeviceid() {
        return deviceid;
    }

    public void setDeviceid(int deviceid) {
        this.deviceid = deviceid;
    }
}
