import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "MUSEUM")

public class Museum {
    String name;

    Museum()
    {

    }

    @XmlElement(name = "MUSEUM_NAME")
    public void setName(String name) {
        this.name = name;
    }
    Boolean childrenAllowed;
    @XmlAttribute(name = "children_allowed")
    public void setChildrenAllowed(Boolean childrenAllowed) {
        this.childrenAllowed = childrenAllowed;
    }
}
