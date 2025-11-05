package org.example;
public class Main {
    public static void main(String[] args) {
        Plant oak = new Tree("Дуб");
        Plant rose = new Flower("Роза");

        oak.grow();
        rose.grow();
    }
}

