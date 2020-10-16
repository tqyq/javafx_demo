package com.szzrain.RegDemo.Computers;

import com.szzrain.RegDemo.GameRegisterManager;

public class ComputerRegister {
    public static void init() {
        GameRegisterManager.addComputer(new ComputerLevelOne("DELL", 0));
    }
}
