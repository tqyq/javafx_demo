package com.szzrain.javaFX;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * @author SzzRain
 * @throws NameException if computer name is illegal, then throws this exception
 */
public class javaFxTest extends Application implements EventHandler<MouseEvent> {
    static int computerNumber = 0;

    Scene createComputerScene, homeScene;
    public static ArrayList<Laptop> laptops = new ArrayList();

    @Override
    public void start(Stage primaryStage) throws Exception {
        TextField textField = new TextField();


        Button button = new Button("输出字符");
        button.setOnMouseClicked(event -> System.out.println(textField.getText()));

//        TODO:
//        Button


        VBox vBox = new VBox();
        vBox.getChildren().addAll(button, textField);


        Scene scene = new Scene(vBox, 400, 400);


        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param brand  品牌
     * @param colour 颜色
     * @param name   名字
     */
    static void createComputer(String name, String brand, String colour) {
        try {
            laptops.add(new Laptop(name, brand, colour));
            computerNumber++;
            System.out.println("create succeed");
        } catch (NameException e1) {
            System.out.println("can not be like that!");
        }
    }

    /**
     * @param num 对象索引值
     */
    static void getComputer(int num) {
        try {
            System.out.println(laptops.get(num));
        } catch (IndexOutOfBoundsException e) {
            System.out.println("That's not work!");
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
