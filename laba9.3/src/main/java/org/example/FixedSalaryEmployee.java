package org.example;

class FixedSalaryEmployee extends Employee {
    public FixedSalaryEmployee(String fullname, double fixedMonthlySalary) {
        super(fullname, fixedMonthlySalary);
    }

    @Override
    public double getMonthlySalary() {
        return salary;
    }
}
