package prueba;

public class Electronica extends Producto {
    private int diasGarantia;

    public Electronica(String codigoBarra, String nombre, double precio, int diasGarantia) {
        super(codigoBarra, nombre, precio);
        this.diasGarantia = diasGarantia;
    }

    public int getDiasGarantia() {
        return diasGarantia;
    }

    @Override
    public double calcularPrecio() {
        return getPrecio() + (getPrecio() * (diasGarantia / 365.0) * 0.1);
    }
}

