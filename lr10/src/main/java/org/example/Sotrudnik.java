package org.example;

abstract class Sotrudnik {
    private String fio;
    private String dolzhnost;
    protected double oklad;

    public Sotrudnik(String fio, String dolzhnost, double oklad) throws OkladException {
        if (oklad < 0) throw new OkladException("Невозможно создать сотрудника – указан отрицательный оклад: " + oklad);
        this.fio = fio;
        this.dolzhnost = dolzhnost;
        this.oklad = oklad;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getDolzhnost() {
        return dolzhnost;
    }

    public void setDolzhnost(String d) {
        dolzhnost = d;
    }

    public double getOklad() {
        return oklad;
    }

    public void setOklad(double o) {
        oklad = o;
    }

    public abstract double rasschitatZarplatu();
}
