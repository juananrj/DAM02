package Ex1Ex4;
import java.io.File;
import java.util.Scanner;

public class MostraFitxers {
    public static void main(String[] args) {
        System.out.print("Muestra los ficheros del directorio: ");
        Scanner reader = new Scanner(System.in);
        String ruta = reader.nextLine();
        File f = new File(ruta);
        File archivos[] = f.listFiles();
        for (int i = 0; i < archivos.length; i++) {
            System.out.println(archivos[i]);

            if (archivos[i].isDirectory()) {
                System.out.println("D " + archivos[i].getName());
            } else {
                System.out.println(archivos[i].getName() + archivos[i].length());
            }
        }
    }
}
