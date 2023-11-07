import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PareNoelASCIILambdes {
    public static void main(String[] args) throws IOException {
        // Leer el contenido del archivo "santako.txt" como un String
        String content = new String(Files.readAllBytes(Paths.get("UF5/santako.txt")));

        // Patrón para detectar a los personajes
        Pattern pattern = Pattern.compile("\\*<]:-DOo|>:o\\)|<]:-D");

        // Inicializar contadores para los personajes
        int pareNoelCount = 0;
        int renCount = 0;
        int folletCount = 0;

        // Crear un matcher para buscar coincidencias en el contenido
        Matcher matcher = pattern.matcher(content);

        // Contar las apariciones de los personajes
        while (matcher.find()) {
            String character = matcher.group();
            switch (character) {
                case "*<]:-DOo":
                    pareNoelCount++;
                    break;
                case ">:o)":
                    renCount++;
                    break;
                case "<]:-D":
                    folletCount++;
                    break;
            }
        }

        // Mostrar el recuento de personajes
        if (pareNoelCount > 0) {
            System.out.println("Pare Noel (" + pareNoelCount + ")");
        }
        if (renCount > 0) {
            System.out.println("Ren (" + renCount + ")");
        }
        if (folletCount > 0) {
            System.out.println("Follet (" + folletCount + ")");
        }
    }
}
