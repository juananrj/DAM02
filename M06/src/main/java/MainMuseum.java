import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;

public class MainMuseum {

    Museum simpleMuseum = new Museum();
    simpleMuseum.setName("Cosmocaixa");
    simpleMuseum.setCity("Barcelona");
    simpleMuseum.setChildrenAllowed(true);

    JAXBContext jaxbContext = JAXBContext.newInstance(Museum.class);
    Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

    jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

    jaxbMarshaller.marshal(simpleMuseum, System.out);


}
