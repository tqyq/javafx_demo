package com.altman.demo.listener2;


@ListenerAnnotation
public class LogListener implements EventListener {
    @Override
    public void onEvent(Event e) {
        System.out.println("I'm LogListener, log recorded: " + e);
    }
}
