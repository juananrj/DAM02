package NF3;


import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class AlumnesSAX {
    public static void main(String[] args) {
        try {
            SAXParser saxParser = SAXParserFactory.newInstance().newSAXParser();

            DefaultHandler handler = new DefaultHandler() {
                private String nombre = null, edad = null;

                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes) {
                    if (qName.equals("Alumne")) {
                        edad = attributes.getValue("Edat");
                    }
                }

                @Override
                public void characters(char[] ch, int start, int length) {
                    String value = new String(ch, start, length).trim();
                    if (!value.isEmpty()) {
                        nombre = value;
                    }
                }

                @Override
                public void endElement(String uri, String localName, String qName) {
                    if (qName.equals("Alumne")) {
                        System.out.println("Alumno:\nNombre: " + nombre + "\nEdad: " + edad + "\n");
                        nombre = edad = null;
                    }
                }
            };

            saxParser.parse("UF1/NF3/alumnes.xml", handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
