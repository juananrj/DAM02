package prueba;

public abstract class Producto {
    private String codigoBarra;
    private String nombre;
    private double precio;

    public Producto(String codigoBarra, String nombre, double precio) {
        this.codigoBarra = codigoBarra;
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getCodigoBarra() {
        return codigoBarra;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public abstract double calcularPrecio();
}
