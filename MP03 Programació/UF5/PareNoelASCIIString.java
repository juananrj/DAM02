import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PareNoelASCIIString {
    public static void main(String[] args) throws IOException {
        // Leer el contenido del archivo "santako.txt" como un String
        String content = new String(Files.readAllBytes(Paths.get("UF5/santako.txt")));

        // Inicializar contadores para los personajes
        int pareNoelCount = 0;
        int renCount = 0;
        int folletCount = 0;

        // Variables auxiliares para el seguimiento de la visita actual
        boolean visitedPareNoel = false;
        boolean visitedRen = false;
        boolean visitedFollet = false;

        // Recorrer el contenido carácter por carácter
        for (char c : content.toCharArray()) {
            // Detectar la visita actual y actualizar los contadores
            if (c == '*') {
                pareNoelCount++;
                visitedPareNoel = true;
            } else if (c == '>') {
                renCount++;
                visitedRen = true;
            } else if (c == '<') {
                folletCount++;
                visitedFollet = true;
            } else if (c == '=') {
                // Si encontramos un '=', significa que la visita actual ha terminado
                // Así que reseteamos las variables de visita
                visitedPareNoel = false;
                visitedRen = false;
                visitedFollet = false;
            }
        }

        // Mostrar el recuento de personajes
        if (visitedPareNoel) {
            System.out.println("Pare Noel (" + pareNoelCount + ")");
        }
        if (visitedRen) {
            System.out.println("Ren (" + renCount + ")");
        }
        if (visitedFollet) {
            System.out.println("Follet (" + folletCount + ")");
        }
    }
}
