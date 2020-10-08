package com.altman.demo.listener;

import java.util.Arrays;
import java.util.List;

public class EventEmitter {

    private List<EventListener> listenerList = Arrays.asList(new LogListener(), new CpuListener());

    public static void main(String[] args) {
        EventEmitter emitter = new EventEmitter();
        Event e = new Event("Event demo");
        for (EventListener listener : emitter.listenerList) {
            listener.onEvent(e);
        }
    }

}
