package NF3;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class AlumnesSAX {
    public static void main(String[] args) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            DefaultHandler handler = new DefaultHandler() {
                boolean bNom = false;
                boolean bEdat = false;

                @Override
                public void characters(char[] ch, int start, int length) throws SAXException {
                    if (bNom) {
                        System.out.println("Nom: " + new String(ch, start, length));
                        bNom = false;
                    }
                }

                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    if (qName.equalsIgnoreCase("Nom")) {
                        bNom = true;
                    } else if (qName.equalsIgnoreCase("Alumne")) {
                        String edat = attributes.getValue("Edat");
                        System.out.println("Edat: " + edat);
                        bEdat = true;
                    }
                }

            };

            saxParser.parse("alumnes.xml", handler);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
