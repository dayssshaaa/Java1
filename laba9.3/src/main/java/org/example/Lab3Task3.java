package org.example;

import java.util.*;

abstract class Employee {
    private static int NEXT_ID = 1;
    protected final int id;
    protected String fullname;
    protected double salary;

    public Employee(String fullname, double salary) {
        this.id = NEXT_ID++;
        this.fullname = fullname;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getFullname() {
        return fullname;
    }

    public abstract double getMonthlySalary();

    @Override
    public String toString() {
        return id + " " + fullname + " " + String.format("%.2f", getMonthlySalary());
    }
}

public class Lab3Task3 {
    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();

        list.add(new FixedSalaryEmployee("Иванов Иван", 50000));
        list.add(new FixedSalaryEmployee("Петрова Анна", 65000));
        list.add(new HourlySalaryEmployee("Сидоров Петр", 160, 200)); // 32000
        list.add(new HourlySalaryEmployee("Кузнецов Алексей", 170, 250)); // 42500
        list.add(new FixedSalaryEmployee("Алексеева Мария", 65000)); // равная зарплата с Петрова
        list.add(new HourlySalaryEmployee("Белоусов Олег", 150, 300)); // 45000
        list.add(new FixedSalaryEmployee("Зайцева Юлия", 30000));
        list.add(new HourlySalaryEmployee("Григорьев Сергей", 180, 220)); // 39600
        list.add(new FixedSalaryEmployee("Михайлов Денис", 45000));
        list.add(new HourlySalaryEmployee("Николаев Илья", 120, 400)); // 48000

        list.sort(Comparator
                .comparingDouble(Employee::getMonthlySalary).reversed()
                .thenComparing(Employee::getFullname));

        System.out.println("Отсортированный список сотрудников (id, имя, среднемесячная зарплата):");
        for (Employee e : list) {
            System.out.println(String.format("%-4d %-20s %10.2f", e.getId(), e.getFullname(), e.getMonthlySalary()));
        }
        System.out.println();

        System.out.println("Табличный отчёт (фамилия 15 символов, зарплата выравнена вправо, 2 знака):");
        Report.generateReport(list);
        System.out.println();

        System.out.println("Первые 5 имён сотрудников:");
        list.stream()
                .limit(5)
                .map(Employee::getFullname)
                .forEach(System.out::println);
        System.out.println();

        System.out.println("Последние 3 id сотрудников:");
        int size = list.size();
        list.stream()
                .skip(Math.max(0, size - 3))
                .map(Employee::getId)
                .forEach(id -> System.out.println(id));
    }
}
