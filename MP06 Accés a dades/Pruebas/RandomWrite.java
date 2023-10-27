package Pruebas;

import java.io.RandomAccessFile;

public class RandomWrite {
    public static void main(String[] args) {
        // Array amb els noms dels departaments
        String[] nomsDepartaments = {"Informatica", "Matematiques", "Llengues", "Biologia", "FOL"};

        try {
            // Creem un fitxer de sortida

            RandomAccessFile ras = new RandomAccessFile("Salidas/departaments.bin", "rw");

            // Escrivim les dades dels departaments al fitxer
            for (int i = 0; i < nomsDepartaments.length; i++) {
                int codi = (i + 1) * 10;
                String nom = nomsDepartaments[i];

                StringBuffer stb = new StringBuffer(nom);
                stb.setLength(10);

                // Escrivim el codi i el nom al fitxer
                ras.writeInt(codi);
                ras.writeChars(stb.toString());

            }

            // Tanquem el fitxer
            ras.close();
            System.out.println("Fitxer de departaments creat amb èxit.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
