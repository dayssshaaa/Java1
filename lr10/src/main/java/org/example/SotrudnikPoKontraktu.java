package org.example;

class SotrudnikPoKontraktu extends Sotrudnik {
    private int daysWorked;
    private double payPerDay;

    public SotrudnikPoKontraktu(String fio, String dolzhnost, double oklad, int daysWorked, double payPerDay) throws OkladException {
        super(fio, dolzhnost, oklad);
        this.daysWorked = daysWorked;
        this.payPerDay = payPerDay;
    }

    @Override
    public double rasschitatZarplatu() {
        try {
            double res = daysWorked * payPerDay;
            System.out.println(getFio() + " (по контракту) зарплата = " + res);
            return res;
        } catch (Exception e) {
            System.out.println("Ошибка при расчёте зарплаты (контракт): " + e.getMessage());
            return 0;
        }
    }
}
