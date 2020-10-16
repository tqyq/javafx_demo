package com.szzrain.RegDemo.Computers;

@IHaveComputer(prize = 10, gainEffect = 1, openMethod = "openComputer")
public class ComputerLevelOne {
    private String brand;
    private int prizeAffect;
    private boolean isOpen = false;

    public ComputerLevelOne(String brand, int prizeAffect) {
        this.brand = brand;
        this.prizeAffect = prizeAffect;
    }

    public String getBrand() {
        return brand;
    }

    public int getPrizeAffect() {
        return prizeAffect;
    }

    public void openComputer() {
        isOpen = true;
        System.out.println("Now I am Open");
    }

    public void closeComputer() {
        isOpen = false;
    }
}
