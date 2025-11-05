package org.example;

class Flower extends Plant {
    public Flower(String name, int initialHeightCm) {
        super(name, initialHeightCm);
    }

    @Override
    public void grow() {
        heightCm += 5;
        System.out.println(name + " (цветок) вырос до " + heightCm + " см");
    }
}
