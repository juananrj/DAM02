package NF3;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class EmpleatsDOM2 {

    public static void main(String[] args) {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            // Parsear el archivo XML
            Document doc = docBuilder.parse(new File("UF1/NF3/empleats.xml"));

            // Obtener la lista de nodos "Empleat"
            NodeList empleatsList = doc.getElementsByTagName("Empleat");

            for (int i = 0; i < empleatsList.getLength(); i++) {
                Element empleatElement = (Element) empleatsList.item(i);
                int id = Integer.parseInt(empleatElement.getElementsByTagName("ID").item(0).getTextContent());
                String cognom = empleatElement.getElementsByTagName("Cognom").item(0).getTextContent();
                String departament = empleatElement.getElementsByTagName("Departament").item(0).getTextContent();
                double sou = Double.parseDouble(empleatElement.getElementsByTagName("Sou").item(0).getTextContent());

                // Mostrar los datos del empleado
                System.out.println("ID: " + id + ", Cognom: " + cognom + ", Departament: " + departament + ", Sou: " + sou);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

