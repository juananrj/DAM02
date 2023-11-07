package subirnota;

import java.time.LocalDate;

public class Alimentacio extends Producte {
    private LocalDate dataCaducitat;

    public Alimentacio(String nom, double preu, String codiBarres, LocalDate dataCaducitat) {
        super(nom, preu, codiBarres);
        this.dataCaducitat = dataCaducitat;
    }

    @Override
    public double calcularPreu() {
        int diesCaducitat = Math.toIntExact((int) dataCaducitat.toEpochDay() - LocalDate.now().toEpochDay());
        return super.getPreu() - super.getPreu() * (1.0 / (diesCaducitat + 1)) + (super.getPreu() * 0.1);
    }
}

