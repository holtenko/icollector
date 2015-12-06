package org.igreenhouse.domain;

import java.sql.Timestamp;

/**
 * Created by allenko on 15-10-28.
 * 室外数据实体类
 */
public class DataOut {
    private Timestamp timestamp;
    private int deviceid;
    private float airtemp;
    private float airhum;
    private float winddirect;
    private float windspeed;
    private float atmosphere;
    private float rainfall;

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

    public float getWinddirect() {
        return winddirect;
    }

    public void setWinddirect(float winddirect) {
        this.winddirect = winddirect;
    }

    public float getWindspeed() {
        return windspeed;
    }

    public void setWindspeed(float windspeed) {
        this.windspeed = windspeed;
    }

    public float getAtmosphere() {
        return atmosphere;
    }

    public void setAtmosphere(float atmosphere) {
        this.atmosphere = atmosphere;
    }

    public float getRainfall() {
        return rainfall;
    }

    public void setRainfall(float rainfall) {
        this.rainfall = rainfall;
    }
}
