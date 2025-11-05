package org.example;

class HourlySalaryEmployee extends Employee {
    private double hoursPerMonth;
    private double ratePerHour;

    public HourlySalaryEmployee(String fullname, double hoursPerMonth, double ratePerHour) {
        super(fullname, 0.0);
        this.hoursPerMonth = hoursPerMonth;
        this.ratePerHour = ratePerHour;
    }

    @Override
    public double getMonthlySalary() {
        return hoursPerMonth * ratePerHour;
    }
}
