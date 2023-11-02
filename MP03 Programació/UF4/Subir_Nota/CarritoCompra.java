package Subir_Nota;

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
            System.out.println("Menú d'opcions:");
            System.out.println("1. Introduir producte");
            System.out.println("2. Passar per caixa");
            System.out.println("3. Mostrar carro de la compra");
            System.out.println("0. Sortir");
            System.out.print("Selecciona una opció: ");

            int opcio = scanner.nextInt();
            scanner.nextLine(); // Limpiar el salto de línea

            switch (opcio) {
                case 1:
                    introduirProducte(carroCompra, scanner);
                    break;
                case 2:
                    passarPerCaixa(carroCompra, dataCompra, nomSupermercat);
                    carroCompra.clear(); // Buidar el carro de la compra
                    break;
                case 3:
                    mostrarCarroCompra(carroCompra);
                    break;
                case 0:
                    System.out.println("Sortint de l'aplicació.");
                    return;
                default:
                    System.out.println("Opció no vàlida. Torna a seleccionar.");
                    break;
            }
        }
    }

    private static void introduirProducte(List<Producte> carroCompra, Scanner scanner) {
        System.out.println("Quin tipus de producte vols afegir?");
        System.out.println("1. Alimentació");
        System.out.println("2. Tèxtil");
        System.out.println("3. Electrònica");
        System.out.println("0. Tornar");
        System.out.print("Selecciona una opció: ");

        int opcio = scanner.nextInt();
        scanner.nextLine(); // Limpiar el salto de línea

        switch (opcio) {
            case 1:
                introduirAlimentacio(carroCompra, scanner);
                break;
            case 2:
                introduirTextil(carroCompra, scanner);
                break;
            case 3:
                introduirElectronica(carroCompra, scanner);
                break;
            case 0:
                System.out.println("Tornant al menú principal.");
                break;
            default:
                System.out.println("Opció no vàlida. Torna a seleccionar.");
                break;
        }
    }

    private static void introduirAlimentacio(List<Producte> carroCompra, Scanner scanner) {
        System.out.print("Nom del producte d'alimentació: ");
        String nom = scanner.nextLine();
        System.out.print("Preu unitari: ");
        double preu = scanner.nextDouble();
        scanner.nextLine(); // Limpiar el salto de línea
        System.out.print("Codi de barres: ");
        String codiBarres = scanner.nextLine();
        System.out.print("Data de caducitat (format: AAAA-MM-DD): ");
        LocalDate dataCaducitat = LocalDate.parse(scanner.nextLine());

        Alimentacio alimentacio = new Alimentacio(nom, preu, codiBarres, dataCaducitat);
        carroCompra.add(alimentacio);
        System.out.println("Producte d'alimentació afegit al carro de la compra.");
    }

    private static void introduirTextil(List<Producte> carroCompra, Scanner scanner) {
        System.out.print("Nom del producte tèxtil: ");
        String nom = scanner.nextLine();
        System.out.print("Preu unitari: ");
        double preu = scanner.nextDouble();
        scanner.nextLine(); // Limpiar el salto de línea
        System.out.print("Codi de barres: ");
        String codiBarres = scanner.nextLine();
        System.out.print("Composició tèxtil: ");
        String composicioTextil = scanner.nextLine();

        Textil tèxtil = new Textil(nom, preu, codiBarres, composicioTextil);
        carroCompra.add(tèxtil);
        System.out.println("Producte tèxtil afegit al carro de la compra.");
    }

    private static void introduirElectronica(List<Producte> carroCompra, Scanner scanner) {
        System.out.print("Nom del producte d'electrònica: ");
        String nom = scanner.nextLine();
        System.out.print("Preu unitari: ");
        double preu = scanner.nextDouble();
        scanner.nextLine(); // Limpiar el salto de línea
        System.out.print("Codi de barres: ");
        String codiBarres = scanner.nextLine();
        System.out.print("Dies de garantia: ");
        int diesGarantia = scanner.nextInt();

        Electronica electronica = new Electronica(nom, preu, codiBarres, diesGarantia);
        carroCompra.add(electronica);
        System.out.println("Producte d'electrònica afegit al carro de la compra.");
    }

    private static void passarPerCaixa(List<Producte> carroCompra, LocalDate dataCompra, String nomSupermercat) {
        Map<String, DetallProducte> detallsProductes = new HashMap<>();

        for (Producte producte : carroCompra) {
            String codiBarres = producte.getCodiBarres();
            if (detallsProductes.containsKey(codiBarres)) {
                // Si ja existeix, incrementa la quantitat
                DetallProducte detallProducte = detallsProductes.get(codiBarres);
                detallProducte.incrementaQuantitat();
            } else {
                // Si no existeix, crea un nou detall
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

    private static void mostrarCarroCompra(List<Producte> carroCompra) {
        System.out.println("Carro de la compra:");
        for (Producte producte : carroCompra) {
            System.out.println(producte.getNom());
        }
    }
}

class Producte {
    private String nom;
    private double preu;
    private String codiBarres;

    public Producte(String nom, double preu, String codiBarres) {
        this.nom = nom;
        this.preu = preu;
        this.codiBarres = codiBarres;
    }

    public String getNom() {
        return nom;
    }

    public double getPreu() {
        return preu;
    }

    public String getCodiBarres() {
        return codiBarres;
    }

    public double calcularPreu() {
        return preu;
    }
}

class Alimentacio extends Producte {
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

class Textil extends Producte {
    private String composicioTextil;

    public Textil(String nom, double preu, String codiBarres, String composicioTextil) {
        super(nom, preu, codiBarres);
        this.composicioTextil = composicioTextil;
    }
}

class Electronica extends Producte {
    private int diesGarantia;

    public Electronica(String nom, double preu, String codiBarres, int diesGarantia) {
        super(nom, preu, codiBarres);
        this.diesGarantia = diesGarantia;
    }

    @Override
    public double calcularPreu() {
        return super.getPreu() + (super.getPreu() * (diesGarantia / 365.0) * 0.1);
    }
}

class DetallProducte {
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
