package NF3;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerException;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EmpleatsDOM1 {

    public static void main(String[] args) {
        List<Empleat> empleats = crearEmpleatsFicticis();

        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            // Crear el documento XML
            Document doc = docBuilder.newDocument();

            // Crear el elemento raíz "Empleats"
            Element rootElement = doc.createElement("Empleats");
            doc.appendChild(rootElement);

            for (Empleat empleat : empleats) {
                // Crear el elemento "Empleat"
                Element empleatElement = doc.createElement("Empleat");
                rootElement.appendChild(empleatElement);

                // Crear y agregar los elementos correspondientes a cada atributo
                agregarElemento(doc, empleatElement, "ID", String.valueOf(empleat.getId()));
                agregarElemento(doc, empleatElement, "Cognom", empleat.getCognom());
                agregarElemento(doc, empleatElement, "Departament", empleat.getDepartament());
                agregarElemento(doc, empleatElement, "Sou", String.valueOf(empleat.getSou()));
            }

            // Guardar el documento XML en un archivo
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("empleats.xml"));

            transformer.transform(source, result);

            System.out.println("Arxiu XML creat amb èxit.");

        } catch (ParserConfigurationException | TransformerException e) {
            e.printStackTrace();
        }
    }

    private static void agregarElemento(Document doc, Element padre, String nombreElemento, String valor) {
        Element elemento = doc.createElement(nombreElemento);
        Text texto = doc.createTextNode(valor);
        elemento.appendChild(texto);
        padre.appendChild(elemento);
    }

    private static List<Empleat> crearEmpleatsFicticis() {
        List<Empleat> empleats = new ArrayList<>();
        empleats.add(new Empleat(1, "Gómez", "Recursos Humanos", 35000.0));
        empleats.add(new Empleat(2, "López", "Contabilidad", 42000.0));
        empleats.add(new Empleat(3, "Martínez", "Ventas", 48000.0));
        empleats.add(new Empleat(4, "Rodríguez", "Tecnología", 55000.0));
        return empleats;
    }
}

class Empleat {
    private int id;
    private String cognom;
    private String departament;
    private double sou;

    public Empleat(int id, String cognom, String departament, double sou) {
        this.id = id;
        this.cognom = cognom;
        this.departament = departament;
        this.sou = sou;
    }

    public int getId() {
        return id;
    }

    public String getCognom() {
        return cognom;
    }

    public String getDepartament() {
        return departament;
    }

    public double getSou() {
        return sou;
    }
}
