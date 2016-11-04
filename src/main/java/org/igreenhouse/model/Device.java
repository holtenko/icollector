package org.igreenhouse.model;

/**
 * Created by holten on 2016/7/15.
 */
public class Device {
    private int id;
    private int serialid;

    public Device() {
    }

    public Device(int id, int serialid) {
        this.id = id;
        this.serialid = serialid;
    }

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
}
