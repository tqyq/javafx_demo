package com.altman.demo.listener2;

import com.sun.management.OperatingSystemMXBean;

import java.lang.management.ManagementFactory;

@ListenerAnnotation
public class CpuListener implements EventListener {
    @Override
    public void onEvent(Event e) {
        OperatingSystemMXBean osBean = ManagementFactory.getPlatformMXBean(
                OperatingSystemMXBean.class);
        // What % CPU load this current JVM is taking, from 0.0-1.0
        System.out.println("I'm CpuListener, CPU load: " + osBean.getProcessCpuLoad());
    }
}
