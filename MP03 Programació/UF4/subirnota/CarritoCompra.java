package subirnota;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CarritoCompra {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Producte> carroCompra = new ArrayList<>();
        LocalDate dataCompra = LocalDate.now();
        String nomSupermercat = "Supermercat ABC";

        while (true) {
            System.out.println("Menú de opciones:");
            System.out.println("1. Introducir producto");
            System.out.println("2. Pasar por caja");
            System.out.println("3. Mostrar carrito de la compra");
            System.out.println("0. Salir");
            System.out.print("Selecciona una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el salto de línea

            switch (opcion) {
                case 1:
                    FuncionesCarro.introducirProducto(carroCompra, scanner);
                    break;
                case 2:
                    FuncionesCarro.pasarPorCaja(carroCompra, dataCompra, nomSupermercat);
                    carroCompra.clear(); // Vaciar el carrito de la compra
                    break;
                case 3:
                    FuncionesCarro.mostrarCarroCompra(carroCompra);
                    break;
                case 0:
                    System.out.println("Saliendo de la aplicación.");
                    return;
                default:
                    System.out.println("Opción no válida. Vuelve a seleccionar.");
                    break;
            }
        }
    }
}
