package org.igreenhouse.model;

import java.sql.Timestamp;

/**
 * Created by holten on 2016/7/16.
 */
public class Data {
    private long deviceid;
    private Timestamp sampletime;
    private float value;

    public Data() {
    }

    public Data(long deviceid, Timestamp sampletime, float value) {
        this.deviceid = deviceid;
        this.sampletime = sampletime;
        this.value = value;
    }

    public long getDeviceid() {
        return deviceid;
    }

    public void setDeviceid(long deviceid) {
        this.deviceid = deviceid;
    }

    public Timestamp getSampletime() {
        return sampletime;
    }

    public void setSampletime(Timestamp sampletime) {
        this.sampletime = sampletime;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }
}
