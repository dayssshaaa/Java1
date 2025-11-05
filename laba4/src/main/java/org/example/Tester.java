package org.example;

class Tester {
    private final String name;
    private final String surname;
    private final int experienceInYears;
    private final String englishLevel;
    private double salary;

    public Tester(String name, String surname, int experienceInYears, String englishLevel, double salary) {
        this.name = name;
        this.surname = surname;
        this.experienceInYears = experienceInYears;
        this.englishLevel = englishLevel;
        this.salary = salary;
    }

    public Tester(String name, String surname, int experienceInYears, String englishLevel) {
        this(name, surname, experienceInYears, englishLevel, 0.0);
    }

    public Tester(String name, String surname, int experienceInYears) {
        this(name, surname, experienceInYears, "a1");
    }

    public void printInfo() {
        System.out.println("Тестер: " + name + " " + surname + ", опыт: " + experienceInYears + " лет");
    }

    public void printInfo(boolean includeEnglishLevel) {
        if (includeEnglishLevel) {
            System.out.println("Тестер: " + name + " " + surname + ", опыт: " + experienceInYears +
                    " лет, английский: " + englishLevel);
        } else {
            printInfo();
        }
    }

    public void printInfo(boolean includeEnglishLevel, boolean includeSalary) {
        if (includeEnglishLevel && includeSalary) {
            System.out.println("Тестер: " + name + " " + surname + ", опыт: " + experienceInYears +
                    " лет, английский: " + englishLevel + ", зарплата: " + salary);
        } else if (includeEnglishLevel) {
            printInfo(true);
        } else if (includeSalary) {
            System.out.println("Тестер: " + name + " " + surname + ", опыт: " + experienceInYears +
                    " лет, зарплата: " + salary);
        } else {
            printInfo();
        }
    }


    public void printSalary() {
        System.out.println("Зарплата: " + salary + " руб.");
    }


    public static void printCompanyPolicy() {
        System.out.println("Политика компании: мы крутые.");
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getExperienceInYears() {
        return experienceInYears;
    }

    public String getEnglishLevel() {
        return englishLevel;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
