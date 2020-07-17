package com.altman;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class EventDemo extends Application implements EventHandler<MouseEvent> {
    private Button button;

    public static void main(String[] args) {
        // write your code here
//        System.out.println("你好");
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // 实例化按钮
        button = new Button("这是按钮");

        // 1、添加按钮点击事件， this.handle 处理事件
//        button.setOnMouseClicked(this);

//        2、使用单独实现的类 事件监听
//        button.setOnMouseClicked(new MyMouseEvent());

//        3、使用匿名类添加事件监听
        button.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("鼠标点击按钮了");
            }
        });

//        4、jdk 8  使用简写执行一条输出
        button.setOnMouseClicked(e -> System.out.println("简写的监听事件"));

//        5、同时输出多条
        button.setOnMouseClicked(e -> {
            System.out.println("简写的监听事件1");
            System.out.println("简写的监听事件2");
        });

        // 创建布局控件
        StackPane stackPane = new StackPane();

        // 将button添加到布局
        stackPane.getChildren().add(button);

        // 创建场景
        Scene scene = new Scene(stackPane, 400, 400);

        // 给场景添加事件处理的对象
//        scene.setOnMousePressed(this);
        scene.setOnMousePressed(new MySceneMouseEvent());

        // 将场景添加到窗口
        primaryStage.setScene(scene);

        // 显示窗口
        primaryStage.show();
    }

    @Override
    public void handle(MouseEvent event) {

        // event.getSource() 获取事件对象
        if (event.getSource() == button) {
            System.out.println("点击了按钮");
        } else {
            System.out.println("点击了场景");
        }
    }
}
