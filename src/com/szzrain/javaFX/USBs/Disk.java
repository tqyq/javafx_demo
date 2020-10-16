package com.szzrain.javaFX.USBs;

import com.szzrain.javaFX.USB;

@IAmUSB(openMethod = "openDevices", useMethod = "useDevices", closeMethod = "closeDevices")
public final class Disk implements USB {
    @Override
    public void openDevices() {
        System.out.println("打开U盘");
    }

    @Override
    public void useDevices() {
        System.out.println("使用U盘");
    }

    @Override
    public void closeDevices() {
        System.out.println("关闭U盘");
    }
}
