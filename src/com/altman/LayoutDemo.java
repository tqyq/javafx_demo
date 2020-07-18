package com.altman;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class LayoutDemo extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // 实例化按钮
        Button b1 = new Button("这是按钮上的文字1");
        b1.setLayoutX(0);
        b1.setLayoutY(0);

        Button b2 = new Button("这是按钮上的文字2");
        b2.setLayoutX(100);
        b2.setLayoutY(100);

        // 创建布局控件
        Pane pane = new Pane();

        // 将button添加到布局
        pane.getChildren().add(b1);
        pane.getChildren().add(b2);

        // 创建场景 宽=400 高=400
        Scene scene = new Scene(pane, 400, 400);

        // 将场景添加到窗口
        primaryStage.setScene(scene);

        // 显示窗口
        primaryStage.show();
    }
}
