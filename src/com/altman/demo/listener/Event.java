package com.altman.demo.listener;

public class Event {

    private String msg;

    public Event(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return this.msg;
    }
}
