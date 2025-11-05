package org.example;

class Flower implements Plant {
    private final String name;

    public Flower(String name) {
        this.name = name;
    }

    @Override
    public void grow() {
        System.out.println(name + " распускается быстро и красиво — это цветок.");
    }
}
