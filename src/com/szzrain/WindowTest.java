package com.szzrain;

import com.szzrain.USBs.Disk;
import com.szzrain.USBs.Mouse;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.InputMismatchException;
/**
 * @deprecated
 */
public class WindowTest {
    public static ArrayList<Laptop> laptops = new ArrayList();

    public static void main(String args[]) {
        EventQueue.invokeLater(() -> {
            JFrame jFrame = new ButtonFrame();
            jFrame.setTitle("Computer Demo");
            jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            jFrame.setVisible(true);
        });
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

    static void seeComputer(int num) {
        try {
            System.out.println(laptops.get(num));
        } catch (IndexOutOfBoundsException e) {
            System.out.println("That's not work!");
        }
    }

    static void getUSB(String name, String pinPai, String Colour, int type) {
        //TODO:use this method  with a actionListener in order to create USB device
        //Never mind,
    }
}

class ButtonFrame extends JFrame {
    public static int computerNumber;
    TextField computerInputName = new TextField("Name", 10);
    TextField computerInputBrand = new TextField("Brand", 10);
    TextField computerInputColour = new TextField("Colour", 10);
    TextField seeComputer = new TextField("see", 0);
    TextField seeUSB = new TextField("USB num", 0);
    TextField getUSBType = new TextField("Type(USB)", 10);

    ButtonFrame() {
        JPanel buttonPanel = new JPanel();
        JPanel textPanel = new JPanel();
        JPanel underPanel = new JPanel();
        setSize(1600, 800);

        JButton createComputerButton = new JButton("Create Computer");
        JButton seeComputerButton = new JButton("See Computer");
        JButton getUSBButton = new JButton("Get USB");
        JButton useUSBDevicesButton = new JButton("Use USB");

        ActionListener seeComputerInformationListener = new SeeComputerInformationListener(seeComputer);
        ActionListener createComputerListener = new CreateComputerListener(computerInputName, computerInputBrand, computerInputColour);
        ActionListener useUSBListener = new UseUSBListener(seeComputer);
        ActionListener getUSBListener = new GetUSBListener(computerInputName, seeComputer, getUSBType, seeComputer);

        createComputerButton.addActionListener(createComputerListener);
        seeComputerButton.addActionListener(seeComputerInformationListener);
        useUSBDevicesButton.addActionListener(useUSBListener);
        getUSBButton.addActionListener(getUSBListener);

        buttonPanel.add(seeComputerButton);
        buttonPanel.add(createComputerButton);
        buttonPanel.add(getUSBButton);
        buttonPanel.add(useUSBDevicesButton);
        buttonPanel.setBackground(Color.GREEN);

        textPanel.add(computerInputName);
        textPanel.add(computerInputColour);
        textPanel.add(computerInputBrand);
        textPanel.add(getUSBType);

        underPanel.add(seeUSB);
        underPanel.add(seeComputer);

        add(buttonPanel, BorderLayout.PAGE_START);
        add(textPanel, BorderLayout.WEST);
        add(underPanel, BorderLayout.CENTER);
    }

    private static class CreateComputerListener implements ActionListener {
        private TextField textFieldName;
        private TextField textFieldBrand;
        private TextField textFieldColour;


        public CreateComputerListener(TextField textFieldName, TextField textFieldBrand, TextField textFieldColour) {
            this.textFieldName = textFieldName;
            this.textFieldBrand = textFieldBrand;
            this.textFieldColour = textFieldColour;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            WindowTest.getComputer(textFieldName.getText(), textFieldBrand.getText(), textFieldColour.getText());
        }
    }

    static class UseUSBListener implements ActionListener {
        private TextField numField;

        public UseUSBListener(TextField numField) {
            this.numField = numField;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            try {//这tm啥玩意，我怎么一行都看不懂
                WindowTest.laptops.get(Integer.parseInt(numField.getText())).useUSB(new Mouse("mouse"));
            } catch (NumberFormatException e1) {
                System.out.println("That Computer haven't been created");
            }
        }
    }

    static class GetUSBListener implements ActionListener {
        TextField nameField;
        TextField computerNameField;
        TextField usbTypeField;
        TextField seeUSBField;

        public GetUSBListener(TextField nameField, TextField computerNumField, TextField usbTypeField, TextField seeUSBField) {
            this.nameField = nameField;
            this.computerNameField = computerNumField;
            this.usbTypeField = usbTypeField;
            this.seeUSBField = seeUSBField;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            USB usb;
            if (usbTypeField.getText().equals("disk") || usbTypeField.getText().equals("Disk")) {
                usb = new Disk();
                try {
                    WindowTest.laptops.get(Integer.parseInt(computerNameField.getText()) - 1).addUSB(usb, Integer.parseInt(seeUSBField.getText()) - 1);
                    System.out.println("create USB disk successful");
                } catch (NumberFormatException e1) {
                    System.out.println("wrong computer number! please check");
                }
            } else {
                System.out.println("create failed: that type of USB don't exist");
            }
        }
    }

    static class SeeComputerInformationListener implements ActionListener {
        private TextField textField;

        public SeeComputerInformationListener(TextField textField) {
            this.textField = textField;
        }

        @Override
        public void actionPerformed(ActionEvent event) {
            try {
                WindowTest.seeComputer(Integer.parseInt(textField.getText()) - 1);
            } catch (InputMismatchException e2) {
                System.out.println("wrong input!");
            } catch (NumberFormatException e3) {
                System.out.println("it can't be empty!");
            }
        }
    }
}