import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PareNoelAscii {
    public static void main(String[] args) {
        try {
            String fileName = "santako.txt";
            StringBuilder sb = new StringBuilder();

            // Lee el contenido del fichero
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            br.close();

            String asciiArt = sb.toString();

            // Utiliza expresiones regulares para contar las visitas
            Pattern pareNoelPattern = Pattern.compile("\\*<]:-DOo");
            Pattern renPattern = Pattern.compile(">:o\\)");
            Pattern folletPattern = Pattern.compile("<]:-D");

            Matcher pareNoelMatcher = pareNoelPattern.matcher(asciiArt);
            Matcher renMatcher = renPattern.matcher(asciiArt);
            Matcher folletMatcher = folletPattern.matcher(asciiArt);

            // Comptadors para seguir el número de visitas
            int pareNoelCount = 0;
            int renCount = 0;
            int folletCount = 0;

            // Contar las visitas de Pare Noel
            while (pareNoelMatcher.find()) {
                pareNoelCount++;
            }

            // Contar las visitas de renos
            while (renMatcher.find()) {
                renCount++;
            }

            // Contar las visitas de elfos
            while (folletMatcher.find()) {
                folletCount++;
            }

            // Imprimir las visitas
            System.out.println("Pare Noel (" + pareNoelCount + ")");
            System.out.println("Ren (" + renCount + ")");
            System.out.println("Follet (" + folletCount + ")");
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
