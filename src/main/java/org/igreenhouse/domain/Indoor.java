package org.igreenhouse.domain;

import java.sql.Timestamp;

/**
 * Created by AllenKO on 2015/11/2.
 * 室内平均数据实体类
 */
public class Indoor {
    private Timestamp timestamp;
    private float airtemp;
    private float airhum;
    private float soiltemp;
    private float soilhum;
    private float light;

    public Indoor(Timestamp timestamp, float airtemp, float airhum, float soiltemp, float soilhum, float light) {
        this.timestamp = timestamp;
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
}
