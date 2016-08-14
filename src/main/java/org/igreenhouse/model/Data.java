package org.igreenhouse.model;

import java.sql.Timestamp;

/**
 * Created by holten on 2016/7/16.
 */
public class Data {
    private long deviceid;
    private Timestamp timestamp;
    private float value;

    public Data() {
    }

    public Data(long deviceid, Timestamp timestamp, float value) {
        this.deviceid = deviceid;
        this.timestamp = timestamp;
        this.value = value;
    }

    public long getDeviceid() {
        return deviceid;
    }

    public void setDeviceid(long deviceid) {
        this.deviceid = deviceid;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }
}
