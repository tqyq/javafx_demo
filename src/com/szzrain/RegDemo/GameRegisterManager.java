package com.szzrain.RegDemo;


import com.szzrain.RegDemo.Computers.IHaveComputer;

import java.util.ArrayList;
import java.util.List;

public class GameRegisterManager {
    private static List<Object> computerList = new ArrayList<>();

    public static <T> void addComputer(T computer) {
        computerList.add(computer);
    }

    public static Object getComputer(int index) {
        return computerList.get(index);
    }
}
