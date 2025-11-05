package org.example;

class Tree extends Plant {
    public Tree(String name, int initialHeightCm) {
        super(name, initialHeightCm);
    }
    public void printInfo() {
        System.out.println("лялялял");
    }

    @Override
    public void grow() {
        heightCm += 30;
        System.out.println(name + " (дерево) выросло до " + heightCm + " см");
    }
}
