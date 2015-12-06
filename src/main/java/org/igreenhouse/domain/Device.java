package org.igreenhouse.domain;

/**
 * Created by AllenKO on 2015/11/30.
 */
public class Device {
    private int id;
    private int type;
    private String name;
    private String brand;
    private String model;
    private int available;
    private int greenhouse;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    public int getGreenhouse() {
        return greenhouse;
    }

    public void setGreenhouse(int greenhouse) {
        this.greenhouse = greenhouse;
    }
}
