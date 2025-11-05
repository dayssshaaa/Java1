package org.example;

abstract class Plant {
    protected String name;
    protected int heightCm;

    public void display() {
        String type = this.getClass().getSimpleName();
        System.out.println("");
    }

    public Plant(String name, int initialHeightCm) {
        this.name = name;
        this.heightCm = initialHeightCm;
    }

    public abstract void grow();
}
