package com.szzrain.USBs;

import com.szzrain.USB;

public final class Mouse implements USB {
    private String name;

    private Mouse() {
    }

    public Mouse(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void openDevices() {
        System.out.println("打开鼠标");
    }

    @Override
    public void useDevices() {
        System.out.println("click");
    }

    @Override
    public void closeDevices() {
        System.out.println("关闭鼠标");
    }

}
