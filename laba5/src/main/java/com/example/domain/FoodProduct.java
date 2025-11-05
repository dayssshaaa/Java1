package com.example.domain;

public class FoodProduct extends Product {
    private String expirationDate;

    public FoodProduct(String name, double price, String expirationDate) {
        super(name, price, "Продукты питания");
        this.expirationDate = expirationDate;
    }

    public String getExpirationDate() { return expirationDate; }
    public void setExpirationDate(String expirationDate) { this.expirationDate = expirationDate; }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Срок годности: " + expirationDate);
    }
}
