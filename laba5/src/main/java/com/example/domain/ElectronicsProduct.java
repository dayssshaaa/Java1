package com.example.domain;

public class ElectronicsProduct extends Product {
    private int warrantyMonths;

    public ElectronicsProduct(String name, double price, int warrantyMonths) {
        super(name, price, "Электроника");
        this.warrantyMonths = warrantyMonths;
    }

    public int getWarrantyMonths() { return warrantyMonths; }
    public void setWarrantyMonths(int warrantyMonths) { this.warrantyMonths = warrantyMonths; }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Гарантия: " + warrantyMonths + " мес.");
    }
}
