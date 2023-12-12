package prueba;

public class Textil extends Producto {
    private String composicionTextil;

    public Textil(String codigoBarra, String nombre, double precio, String composicionTextil) {
        super(codigoBarra, nombre, precio);
        this.composicionTextil = composicionTextil;
    }

    public String getComposicionTextil() {
        return composicionTextil;
    }

    @Override
    public double calcularPrecio() {
        return getPrecio();
    }
}

