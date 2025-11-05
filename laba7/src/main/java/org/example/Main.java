package org.example;

public class Main {
    public static void main(String[] args) {
        Plant oak = new Tree("Дуб", 100);
        Tree oak1 = new Tree("Дуб", 100);

                oak.display();
                oak.printInfo();
                oak1.display();
                oak1.printInfo();
        Plant rose = new Flower("Роза", 10);

        for (int i = 1; i <= 3; i++) {
            System.out.println("Цикл роста " + i + ":");
            oak.grow();
            rose.grow();
            System.out.println();
        }
    }
}

