package com.szzrain.RegDemo;

import com.szzrain.RegDemo.Computers.ComputerRegister;
import com.szzrain.RegDemo.Computers.IHaveComputer;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestMain {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ComputerRegister.init();
        if (GameRegisterManager.getComputer(0).getClass().isAnnotationPresent(IHaveComputer.class)) {
            IHaveComputer computer = GameRegisterManager.getComputer(0).getClass().getAnnotation(IHaveComputer.class);
            Method openComputerMethod = GameRegisterManager.getComputer(0).getClass().getMethod(computer.openMethod());
            openComputerMethod.invoke(GameRegisterManager.getComputer(0));
        }
    }
}
