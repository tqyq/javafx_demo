package com.szzrain;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;


public class javaFxTest extends Application implements EventHandler<MouseEvent> {

    public static ArrayList<Laptop> laptops = new ArrayList();

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

    static void getComputer(String name, String brand, String colour) {
        try {
            laptops.add(new Laptop(name, brand, colour));
            ButtonFrame.computerNumber++;
            System.out.println("create succeed");
        } catch (NameException e1) {
            System.out.println("can not be like that!");
        }
    }

    public static void main(String[] args) {
        System.out.println("Window start");
        launch(args);
    }

    @Override
    public void handle(MouseEvent event) {

    }
}
