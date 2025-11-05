package org.example;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class AllTasks {
    public static void main(String[] args) {
        task1();
        System.out.println("\n---\n");
        task2();
        System.out.println("\n---\n");
        task3();
    }

    private static void task1() {
        Path p = Paths.get("about_me.txt");
        String info = "Имя: Дарья\nГород: Минск\nПрофессия: студент\nКоротко: люблю программировать на Java\n";
        try {
            Files.write(p, info.getBytes(StandardCharsets.UTF_8));
            BasicFileAttributes attr = Files.readAttributes(p, BasicFileAttributes.class);
            System.out.println("Задание 1. Информация о файле:");
            System.out.println("Путь: " + p.toAbsolutePath());
            System.out.println("Размер в байтах: " + attr.size());
            System.out.println("Создан: " + attr.creationTime());
            System.out.println("Последняя модификация: " + attr.lastModifiedTime());
            System.out.println("Содержимое файла:");
            Files.lines(p, StandardCharsets.UTF_8).forEach(System.out::println);
        } catch (IOException e) {
            System.err.println("Task1: ошибка ввода-вывода: " + e.getMessage());
        }
    }

    private static void task2() {
        Path p = Paths.get("temperatures.txt");
        Scanner sc = new Scanner(System.in);
        List<Double> temps = new ArrayList<>();
        System.out.println("Задание 2. Введите 15 вещественных значений температуры (Enter после каждого):");
        while (temps.size() < 5) {
            System.out.print((temps.size() + 1) + ": ");
            String line = sc.nextLine().trim();
            try {
                double v = Double.parseDouble(line.replace(',', '.'));
                temps.add(v);
            } catch (NumberFormatException e) {
                System.out.println("Неверный формат, попробуйте снова.");
            }
        }
        try {
            List<String> out = new ArrayList<>();
            for (Double d : temps) out.add(d.toString());
            Files.write(p, out, StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.err.println("Task2: ошибка записи: " + e.getMessage());
            return;
        }

        try {
            List<String> lines = Files.readAllLines(p, StandardCharsets.UTF_8);
            double sum = 0;
            int count = 0;
            for (String s : lines) {
                if (s.isBlank()) continue;
                try {
                    double v = Double.parseDouble(s);
                    sum += v;
                    count++;
                } catch (NumberFormatException ex) {
                    System.err.println("В файле найдено неверное число: " + s);
                }
            }
            double avg = count > 0 ? sum / count : 0;
            System.out.printf("Средняя температура (по %d значениям): %.3f%n", count, avg);
        } catch (IOException e) {
            System.err.println("Task2: ошибка чтения: " + e.getMessage());
        }
    }

    private static void task3() {
        Path p = Paths.get("dates.txt");
        String sample = "01.01.2020\n23.02.2019\n21.04.2021\n15.08.1995\n32.01.2020\nabc\n";
        try {
            Files.write(p, sample.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            System.err.println("Task3: не удалось создать файл: " + e.getMessage());
            return;
        }

        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        sdf.setLenient(false);
        System.out.println("Задание 3. Проверка дат в файле dates.txt (формат dd.MM.yyyy):");
        try {
            List<String> lines = Files.readAllLines(p, StandardCharsets.UTF_8);
            int ln = 0;
            for (String line : lines) {
                ln++;
                String t = line.trim();
                if (t.isEmpty()) {
                    System.out.println(ln + ": пустая строка");
                    continue;
                }
                try {
                    sdf.parse(t);
                    System.out.println(ln + ": корректная дата " + t);
                } catch (ParseException e) {
                    System.out.println(ln + ": НЕКОРРЕКТНАЯ дата " + t);
                }
            }
        } catch (IOException e) {
            System.err.println("Task3: ошибка чтения: " + e.getMessage());
        }
    }
}
