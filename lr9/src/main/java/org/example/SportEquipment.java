package org.example;

class SportEquipment {
    private String brand;

    public SportEquipment(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    @Override
    public String toString() {
        return "SportEquipment{brand='" + brand + "'}";
    }
}
