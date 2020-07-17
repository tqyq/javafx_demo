package com.altman;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class MySceneMouseEvent implements EventHandler<MouseEvent> {
    @Override
    public void handle(MouseEvent event) {
        System.out.println("场景鼠标点击");
    }
}
