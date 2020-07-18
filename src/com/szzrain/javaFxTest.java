package com.szzrain;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class javaFxTest extends Application implements EventHandler<MouseEvent> {
    @Override
    public void start(Stage primaryStage) throws Exception {
        TextField textField = new TextField();
        Button button = new Button("输出字符");
        button.setOnMouseClicked(event -> System.out.println(textField.getText()));

        VBox vBox = new VBox();
        vBox.getChildren().addAll(button, textField);
        Scene scene = new Scene(vBox, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        System.out.println("Window start");
        launch(args);
    }

    @Override
    public void handle(MouseEvent event) {

    }
}
