package org.example;

public class Ulitka {

    public String name;
    private int age;
    protected double speed;

    public Ulitka() {
        this.name = "Улиточка";
        this.age = 1;
        this.speed = 0.5;
    }

    public Ulitka(String name, int age, double speed) {
        this.name = name;
        this.age = age;
        this.speed = speed;
    }

    public void crawl() {
        System.out.println(name + " ползёт со скоростью " + speed + " см/мин");
    }

    private void grow() {
        age++;
        System.out.println(name + " стала старше! Теперь ей " + age + " лет.");
    }

    public void nextYear() {
        grow();
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void info() {
        System.out.println("Имя: " + name + ", Возраст: " + age + ", Скорость: " + speed);
    }

    public static void main(String[] args) {
        Ulitka s1 = new Ulitka();
        s1.info();
        s1.crawl();
        s1.nextYear();

        Ulitka s2 = new Ulitka("Улиточка", 3, 0.8);
        s2.info();
        s2.crawl();
    }
}
