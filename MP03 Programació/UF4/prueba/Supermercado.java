package prueba;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Supermercado {
    private List<Producto> carroCompra;
    private String nombreSupermercado;

    public Supermercado(String nombreSupermercado) {
        this.carroCompra = new ArrayList<>();
        this.nombreSupermercado = nombreSupermercado;
    }

    public void introducirProducto() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Quin tipus de producte vols afegir?");
        System.out.println("1. Alimentació");
        System.out.println("2. Tèxtil");
        System.out.println("3. Electrònica");
        System.out.println("0. Tornar");

        int opcion = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer del scanner

        switch (opcion) {
            case 1:
                System.out.println("Introdueix el codi de barres:");
                String codigoBarra = scanner.nextLine();
                System.out.println("Introdueix el nom:");
                String nombre = scanner.nextLine();
                System.out.println("Introdueix el preu:");
                double precioAlimentacion = scanner.nextDouble();
                scanner.nextLine(); // Limpiar el buffer del scanner
                System.out.println("Introdueix la data de caducitat (yyyy-mm-dd):");
                String fechaCaducidadStr = scanner.nextLine();
                LocalDate fechaCaducidad = LocalDate.parse(fechaCaducidadStr);

                Alimentacion alimentacion = new Alimentacion(codigoBarra, nombre, precioAlimentacion, fechaCaducidad);
                carroCompra.add(alimentacion);

                System.out.println("Producte d'alimentació afegit correctament.");
                break;

            case 2:
                System.out.println("Introdueix el codi de barres:");
                String codigoBarraTextil = scanner.nextLine();
                System.out.println("Introdueix el nom:");
                String nombreTextil = scanner.nextLine();
                System.out.println("Introdueix el preu:");
                double precioTextil = scanner.nextDouble();
                scanner.nextLine(); // Limpiar el buffer del scanner
                System.out.println("Introdueix la composició tèxtil:");
                String composicionTextil = scanner.nextLine();

                Textil textil = new Textil(codigoBarraTextil, nombreTextil, precioTextil, composicionTextil);
                carroCompra.add(textil);

                System.out.println("Producte tèxtil afegit correctament.");
                break;

            case 3:
                System.out.println("Introdueix el codi de barres:");
                String codigoBarraElectronica = scanner.nextLine();
                System.out.println("Introdueix el nom:");
                String nombreElectronica = scanner.nextLine();
                System.out.println("Introdueix el preu:");
                double precioElectronica = scanner.nextDouble();
                scanner.nextLine(); // Limpiar el buffer del scanner
                System.out.println("Introdueix el nombre de dies de garantia:");
                int diasGarantia = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer del scanner

                Electronica electronica = new Electronica(codigoBarraElectronica, nombreElectronica, precioElectronica, diasGarantia);
                carroCompra.add(electronica);

                System.out.println("Producte d'electrònica afegit correctament.");
                break;


            case 0:
                // Volver al menú principal
                break;
        }
    }
}



