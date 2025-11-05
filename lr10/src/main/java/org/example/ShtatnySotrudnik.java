package org.example;

class ShtatnySotrudnik extends Sotrudnik {
    private double premiya;

    public ShtatnySotrudnik(String fio, String dolzhnost, double oklad, double premiya) throws OkladException {
        super(fio, dolzhnost, oklad);
        this.premiya = premiya;
    }

    public double getPremiya() {
        return premiya;
    }

    public void setPremiya(double p) {
        premiya = p;
    }

    @Override
    public double rasschitatZarplatu() {
        try {
            if (premiya < 0) throw new PremiyaException("Отрицательная премия: " + premiya);
            double res = oklad + premiya;
            System.out.println(getFio() + " (штатный) зарплата = " + res);
            return res;
        } catch (PremiyaException pe) {
            System.out.println("PremiyaException: " + pe.getMessage());
            return 0;
        } catch (Exception e) {
            System.out.println("Ошибка при расчёте зарплаты (штатный): " + e.getMessage());
            return 0;
        }
    }
}
