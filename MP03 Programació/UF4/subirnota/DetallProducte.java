package subirnota;
public class DetallProducte {
    private Producte producte;
    private int quantitat;

    public DetallProducte(Producte producte) {
        this.producte = producte;
        this.quantitat = 1;
    }

    public Producte getProducte() {
        return producte;
    }

    public int getQuantitat() {
        return quantitat;
    }

    public void incrementaQuantitat() {
        quantitat++;
    }
}

