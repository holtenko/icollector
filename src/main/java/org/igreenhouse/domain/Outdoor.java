package org.igreenhouse.domain;

import java.sql.Timestamp;

/**
 * Created by AllenKO on 2015/11/2.
 * 室外平均数据实体类
 */
public class Outdoor {
    private Timestamp timestamp;
    private float airtemp;
    private float airhum;
    private float winddirect;
    private float windspeed;
    private float atmosphere;
    private float rainfall;

    public Outdoor(Timestamp timestamp, float airtemp, float airhum, float winddirect, float windspeed, float atmosphere, float rainfall) {
        this.timestamp = timestamp;
        this.airtemp = airtemp;
        this.airhum = airhum;
        this.winddirect = winddirect;
        this.windspeed = windspeed;
        this.atmosphere = atmosphere;
        this.rainfall = rainfall;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
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
