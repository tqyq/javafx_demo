package com.szzrain;

import java.util.ArrayList;

public final class Laptop {
    private String name;
    private String module;
    private String colour;
    private ArrayList<USB> USBList = new ArrayList<>();

    public void addUSB(USB usb, int index) {
        USBList.set(index, usb);
    }


    @Override
    public String toString() {
        return getName() + getModule() + getColour();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return "电脑名字是" + name;
    }

    public Laptop(String name, String Brand, String colour) {
        this.module = Brand;
        this.name = name;

        if (colour.equals("")) {
            throw new NameException("");
        }
        this.colour = colour;
    }

    public String getModule() {
        return "电脑品牌是" + module;
    }

    public String getColour() {
        return "电脑颜色是" + colour;
    }

    public USB getUSB(int index) {
        return USBList.get(index);
    }

    public void useUSB(USB usb) {
        usb.openDevices();
        usb.useDevices();
        usb.closeDevices();
    }
}
