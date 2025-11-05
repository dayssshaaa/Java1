package org.example;

import java.util.List;

class Report {

    public static void generateReport(List<Employee> employees) {
        System.out.println(String.format("%-4s %-15s %-20s %10s", "ID", "Фамилия", "Полное имя", "Зарплата"));
        System.out.println("---------------------------------------------------------------");
        for (Employee e : employees) {
            String full = e.getFullname();
            String surname = extractSurname(full);
            System.out.println(String.format("%-4d %-15s %-20s %10.2f",
                    e.getId(),
                    padSurname(surname),
                    full,
                    e.getMonthlySalary()));
        }
    }

    private static String extractSurname(String fullname) {
        String[] parts = fullname.trim().split("\\s+");
        return parts.length > 0 ? parts[0] : fullname;
    }

    private static String padSurname(String surname) {
        if (surname.length() <= 15) return surname;
        return surname.substring(0, 15);
    }
}
