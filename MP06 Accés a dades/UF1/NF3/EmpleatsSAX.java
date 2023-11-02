package NF3;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class EmpleatsSAX {
    public static void main(String[] args) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            DefaultHandler handler = new DefaultHandler() {
                boolean bID = false;

                boolean bNom = false;
                boolean bCognom = false;
                boolean bDepartament = false;
                boolean bSou = false;

                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    if (qName.equalsIgnoreCase("ID")) {
                        bID = true;
                    } else if (qName.equalsIgnoreCase("Cognom")) {
                        bCognom = true;
                    } else if (qName.equalsIgnoreCase("Departament")) {
                        bDepartament = true;
                    } else if (qName.equalsIgnoreCase("Sou")) {
                        bSou = true;
                    }
                }

                @Override
                public void characters(char[] ch, int start, int length) throws SAXException {
                    if (bID) {
                        System.out.print("ID: " + new String(ch, start, length) + ", ");
                        bID = false;
                    } else if (bCognom) {
                        System.out.print("Cognom: " + new String(ch, start, length) + ", ");
                        bCognom = false;
                    } else if (bDepartament) {
                        System.out.print("Departament: " + new String(ch, start, length) + ", ");
                        bDepartament = false;
                    } else if (bSou) {
                        System.out.println("Sou: " + new String(ch, start, length));
                        bSou = false;
                    }
                }
            };

            saxParser.parse("empleats.xml", handler);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

