package org.igreenhouse.domain;

import java.sql.Timestamp;

/**
 * Created by AllenKO on 2015/12/22.
 */
public class LogDevice {
    private int uid;
    private int deviceid;
    private byte prestatus;
    private byte curstatus;
    private Timestamp timestamp;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getDeviceid() {
        return deviceid;
    }

    public void setDeviceid(int deviceid) {
        this.deviceid = deviceid;
    }

    public byte getPrestatus() {
        return prestatus;
    }

    public void setPrestatus(byte prestatus) {
        this.prestatus = prestatus;
    }

    public byte getCurstatus() {
        return curstatus;
    }

    public void setCurstatus(byte curstatus) {
        this.curstatus = curstatus;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
