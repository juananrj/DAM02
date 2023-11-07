package subirnota;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class FuncionesCarro {
    public static void introducirProducto(List<Producte> carroCompra, Scanner scanner) {
        System.out.println("¿Qué tipo de producto quieres añadir?");
        System.out.println("1. Alimentación");
        System.out.println("2. Textil");
        System.out.println("3. Electrónica");
        System.out.println("0. Volver");
        System.out.print("Selecciona una opción: ");

        int opcion = scanner.nextInt();
        scanner.nextLine(); // Limpiar el salto de línea

        switch (opcion) {
            case 1:
                introducirAlimentacion(carroCompra, scanner);
                break;
            case 2:
                introducirTextil(carroCompra, scanner);
                break;
            case 3:
                introducirElectronica(carroCompra, scanner);
                break;
            case 0:
                System.out.println("Volviendo al menú principal.");
                break;
            default:
                System.out.println("Opción no válida. Vuelve a seleccionar.");
                break;
        }
    }

    public static void introducirAlimentacion(List<Producte> carroCompra, Scanner scanner) {
        System.out.print("Nombre del producto de alimentación: ");
        String nombre = scanner.nextLine();
        System.out.print("Precio unitario: ");
        double precio = scanner.nextDouble();
        scanner.nextLine(); // Limpiar el salto de línea
        System.out.print("Código de barras: ");
        String codigoBarras = scanner.nextLine();
        System.out.print("Fecha de caducidad (formato: AAAA-MM-DD): ");
        LocalDate fechaCaducidad = LocalDate.parse(scanner.nextLine());

        Alimentacio alimentacion = new Alimentacio(nombre, precio, codigoBarras, fechaCaducidad);
        carroCompra.add(alimentacion);
        System.out.println("Producto de alimentación añadido al carrito de la compra.");
    }

    public static void introducirTextil(List<Producte> carroCompra, Scanner scanner) {
        System.out.print("Nombre del producto textil: ");
        String nombre = scanner.nextLine();
        System.out.print("Precio unitario: ");
        double precio = scanner.nextDouble();
        scanner.nextLine(); // Limpiar el salto de línea
        System.out.print("Código de barras: ");
        String codigoBarras = scanner.nextLine();
        System.out.print("Composición textil: ");
        String composicionTextil = scanner.nextLine();

        Textil textil = new Textil(nombre, precio, codigoBarras, composicionTextil);
        carroCompra.add(textil);
        System.out.println("Producto textil añadido al carrito de la compra.");
    }

    public static void introducirElectronica(List<Producte> carroCompra, Scanner scanner) {
        System.out.print("Nombre del producto de electrónica: ");
        String nombre = scanner.nextLine();
        System.out.print("Precio unitario: ");
        double precio = scanner.nextDouble();
        scanner.nextLine(); // Limpiar el salto de línea
        System.out.print("Código de barras: ");
        String codigoBarras = scanner.nextLine();
        System.out.print("Días de garantía: ");
        int diasGarantia = scanner.nextInt();

        Electronica electronica = new Electronica(nombre, precio, codigoBarras, diasGarantia);
        carroCompra.add(electronica);
        System.out.println("Producto de electrónica añadido al carrito de la compra.");
    }

    public static void pasarPorCaja(List<Producte> carroCompra, LocalDate dataCompra, String nomSupermercat) {
        Map<String, DetallProducte> detallsProductes = new HashMap<>();

        for (Producte producte : carroCompra) {
            String codiBarres = producte.getCodiBarres();
            if (detallsProductes.containsKey(codiBarres)) {
                // Si ya existe, incrementa la cantidad
                DetallProducte detallProducte = detallsProductes.get(codiBarres);
                detallProducte.incrementaQuantitat();
            } else {
                // Si no existe, crea un nuevo detalle
                DetallProducte detallProducte = new DetallProducte(producte);
                detallsProductes.put(codiBarres, detallProducte);
            }
        }

        System.out.println("Tiquet de compra de " + nomSupermercat);
        System.out.println("Data de la compra: " + dataCompra);
        System.out.println("----------------------------------------------------");
        double totalCompra = 0.0;

        for (DetallProducte detallProducte : detallsProductes.values()) {
            Producte producte = detallProducte.getProducte();
            int quantitat = detallProducte.getQuantitat();
            double preuUnitari = producte.calcularPreu();
            double preuTotal = preuUnitari * quantitat;

            System.out.println("Nom del producte: " + producte.getNom());
            System.out.println("Unitats introduïdes al carro: " + quantitat);
            System.out.println("Preu unitari: " + preuUnitari);
            System.out.println("Preu total: " + preuTotal);
            System.out.println("----------------------------------------------------");

            totalCompra += preuTotal;
        }

        System.out.println("Suma total a pagar: " + totalCompra);
        System.out.println("----------------------------------------------------");
    }

    public static void mostrarCarroCompra(List<Producte> carroCompra) {
        System.out.println("Carro de la compra:");
        for (Producte producte : carroCompra) {
            System.out.println(producte.getNom());
        }
    }
}
// Path: UF4/subirnota/Alimentacio.java
