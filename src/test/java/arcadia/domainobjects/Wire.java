package arcadia.domainobjects;

import java.util.List;

public class Wire {
    private String connectorName;
    private static List<WireProperties> wirePropertiesList;
    public String getConnectorName() {
        return connectorName;
    }
    public void setConnectorName(String connectorName) {
        this.connectorName = connectorName;
    }
    public static List<WireProperties> getWirePropertiesList() {
        return wirePropertiesList;
    }
    public void setWirePropertiesList(List<WireProperties> wirePropertiesList) {
        this.wirePropertiesList = wirePropertiesList;
    }

}
