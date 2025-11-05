package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Введите ваше имя: ");
        String userName = sc.nextLine().trim();
        if (userName.isEmpty()) userName = "Гость";
        System.out.println("Hello, " + userName + "!");

        System.out.println("\nДемонстрация класса Tester (ввод данных через пробел или по очереди).");

        System.out.println("\n1) Введите имя, фамилию и количество лет опыта:");
        String n1 = sc.next();
        String s1 = sc.next();
        int exp1 = readIntSafe(sc);
        Tester t1 = new Tester(n1, s1, exp1);

        System.out.println("\n2) Введите имя, фамилию, опыт и уровень английского");
        String n2 = sc.next();
        String s2 = sc.next();
        int exp2 = readIntSafe(sc);
        String eng2 = sc.next();
        Tester t2 = new Tester(n2, s2, exp2, eng2);

        System.out.println("\n3) Введите имя, фамилию, опыт, уровень английского и зарплату:");
        String n3 = sc.next();
        String s3 = sc.next();
        int exp3 = readIntSafe(sc);
        String eng3 = sc.next();
        double sal3 = readDoubleSafe(sc);
        Tester t3 = new Tester(n3, s3, exp3, eng3, sal3);

        sc.nextLine();

        System.out.println("\nВызов статического метода Tester.printCompanyPolicy():");
        Tester.printCompanyPolicy();

        System.out.println("\nВызовы перегруженных методов printInfo():");
        System.out.println("\nОбщая информация о t1:");
        t1.printInfo();

        System.out.println("\nИнформация о t2 с указанием уровня английского:");
        t2.printInfo(true);

        System.out.println("\nПолная информация о t3 с указанием английского и зарплаты:");
        t3.printInfo(true, true);

        System.out.println("\nПрограмма завершена.");
        sc.close();
    }

    private static int readIntSafe(Scanner sc) {
        while (!sc.hasNextInt()) {
            sc.next();
            System.out.print("Ожидалось целое число. Введите ещё раз: ");
        }
        return sc.nextInt();
    }

    private static double readDoubleSafe(Scanner sc) {
        while (!sc.hasNextDouble()) {
            sc.next();
            System.out.print("Ожидалось число (например 123.45). Введите ещё раз: ");
        }
        return sc.nextDouble();
    }
}

