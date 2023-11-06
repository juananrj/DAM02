package NF3;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Attr;
import org.w3c.dom.DOMException;
import org.w3c.dom.Text;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerException;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.util.ArrayList;
import java.util.List;

public class AlumnesDOM1 {

    public static void main(String[] args) {
        List<Alumne> alumnes = new ArrayList<>();
        alumnes.add(new Alumne("12345678A", "Juan", "Pérez", "Gómez", "Barcelona", "Matemáticas, Física", 25));
        alumnes.add(new Alumne("87654321B", "María", "López", "Sánchez", "Madrid", "Historia, Literatura", 22));

        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            // Crear el documento XML
            Document doc = docBuilder.newDocument();

            // Crear el elemento raíz "Alumnes"
            Element rootElement = doc.createElement("Alumnes");
            doc.appendChild(rootElement);

            for (Alumne alumne : alumnes) {
                // Crear el elemento "Alumne"
                Element alumneElement = doc.createElement("Alumne");
                rootElement.appendChild(alumneElement);

                // Crear el atributo "Edat" y asignarle el valor como un int
                Attr edatAttr = doc.createAttribute("Edat");
                edatAttr.setValue(String.valueOf(alumne.getEdat()));
                alumneElement.setAttributeNode(edatAttr);

                // Crear y agregar los elementos correspondientes a cada atributo
                agregarElemento(doc, alumneElement, "DNI", alumne.getDni());
                agregarElemento(doc, alumneElement, "Nom", alumne.getNom());
                agregarElemento(doc, alumneElement, "Cognom1", alumne.getCognom1());
                agregarElemento(doc, alumneElement, "Cognom2", alumne.getCognom2());
                agregarElemento(doc, alumneElement, "Ciutat", alumne.getCiutat());
                agregarElemento(doc, alumneElement, "Assignatures", alumne.getAssignatures());
            }

            // Guardar el documento XML en un archivo
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new java.io.File("alumnes.xml"));

            transformer.transform(source, result);

            System.out.println("Arxiu XML creat amb èxit.");

        } catch (ParserConfigurationException | TransformerException | DOMException e) {
            e.printStackTrace();
        }
    }

    private static void agregarElemento(Document doc, Element padre, String nombreElemento, String valor) {
        Element elemento = doc.createElement(nombreElemento);
        Text texto = doc.createTextNode(valor);
        elemento.appendChild(texto);
        padre.appendChild(elemento);
    }
}

class Alumne {
    private String dni;
    private String nom;
    private String cognom1;
    private String cognom2;
    private String ciutat;
    private String assignatures;
    private int edat;

    public Alumne(String dni, String nom, String cognom1, String cognom2, String ciutat, String assignatures, int edat) {
        this.dni = dni;
        this.nom = nom;
        this.cognom1 = cognom1;
        this.cognom2 = cognom2;
        this.ciutat = ciutat;
        this.assignatures = assignatures;
        this.edat = edat;
    }

    public String getDni() {
        return dni;
    }

    public String getNom() {
        return nom;
    }

    public String getCognom1() {
        return cognom1;
    }

    public String getCognom2() {
        return cognom2;
    }

    public String getCiutat() {
        return ciutat;
    }

    public String getAssignatures() {
        return assignatures;
    }

    public int getEdat() {
        return edat;
    }
}
