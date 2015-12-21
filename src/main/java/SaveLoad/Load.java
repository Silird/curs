package SaveLoad;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class Load {

    public void LoadXML(String fileName, DefaultTableModel model) {
        int i;
        try {
            int rows = model.getRowCount();
            for (i = 0; i < rows; i++) {
                model.removeRow(0);
            }
            DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = dBuilder.parse(new File(fileName));
            NodeList nlCars = doc.getElementsByTagName("car");
            for (i = 0; i < nlCars.getLength(); i++) {
                Node elem = nlCars.item(i);
                NamedNodeMap attrs = elem.getAttributes();
                String client = attrs.getNamedItem("client").getNodeValue();
                String carName = attrs.getNamedItem("carname").getNodeValue();
                String date = attrs.getNamedItem("date").getNodeValue();
                String ready = attrs.getNamedItem("ready").getNodeValue();
                model.addRow(new String[] {client, carName, date, ready});
            }
        }
        catch (SAXException ex) {
            ex.printStackTrace();
        }
        catch (IOException ex) {
            ex.printStackTrace();;
        }
        catch (ParserConfigurationException ex) {
            ex.printStackTrace();;
        }
    }
}
