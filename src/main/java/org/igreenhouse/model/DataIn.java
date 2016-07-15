package org.igreenhouse.model;

import java.sql.Timestamp;

/**
 * Created by holten.gao on 2016/7/13.
 */
public class DataIn {
    private Timestamp timestamp;
    private int deviceid;
    private float airtemp;
    private float airhum;
    private float soiltemp;
    private float soilhum;
    private float light;
    private byte status;

    public DataIn() {
    }

    public DataIn(Timestamp timestamp, int deviceid, float airtemp, float airhum, float soiltemp, float soilhum, float light) {
        this.timestamp = timestamp;
        this.deviceid = deviceid;
        this.airtemp = airtemp;
        this.airhum = airhum;
        this.soiltemp = soiltemp;
        this.soilhum = soilhum;
        this.light = light;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public int getDeviceid() {
        return deviceid;
    }

    public void setDeviceid(int deviceid) {
        this.deviceid = deviceid;
    }

    public float getAirtemp() {
        return airtemp;
    }

    public void setAirtemp(float airtemp) {
        this.airtemp = airtemp;
    }

    public float getAirhum() {
        return airhum;
    }

    public void setAirhum(float airhum) {
        this.airhum = airhum;
    }

    public float getSoiltemp() {
        return soiltemp;
    }

    public void setSoiltemp(float soiltemp) {
        this.soiltemp = soiltemp;
    }

    public float getSoilhum() {
        return soilhum;
    }

    public void setSoilhum(float soilhum) {
        this.soilhum = soilhum;
    }

    public float getLight() {
        return light;
    }

    public void setLight(float light) {
        this.light = light;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }
}
