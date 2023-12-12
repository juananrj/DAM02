package prueba;

import java.time.LocalDate;

public class Alimentacion extends Producto {
    private LocalDate fechaCaducidad;

    public Alimentacion(String codigoBarra, String nombre, double precio, LocalDate fechaCaducidad) {
        super(codigoBarra, nombre, precio);
        this.fechaCaducidad = fechaCaducidad;
    }

    public LocalDate getFechaCaducidad() {
        return fechaCaducidad;
    }

    @Override
    public double calcularPrecio() {
        LocalDate fechaActual = LocalDate.now();
        int diasRestantes = fechaCaducidad.compareTo(fechaActual) + 1;
        return getPrecio() - (getPrecio() * (1.0 / diasRestantes)) + (getPrecio() * 0.1);
    }
}

