package SaveLoad;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import util.DoubleMasterException;
import util.WorkMasters;

import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class Load {

    public void LoadXML(String fileName, WorkMasters masters) {
        int i;
        try {
            /*
            int rows = model.getRowCount();
            for (i = 0; i < rows; i++) {
                model.removeRow(0);
            }
            */
            masters.Remove();
            DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = dBuilder.parse(new File(fileName));
            NodeList nlMaster = doc.getElementsByTagName("master");
            for (i = 0; i < nlMaster.getLength(); i++) {
                Node elem = nlMaster.item(i);
                NamedNodeMap attrs = elem.getAttributes();
                masters.add(attrs.getNamedItem("name").getNodeValue(),
                        new int[] {Integer.valueOf(attrs.getNamedItem("KOD1").getNodeValue()),
                                Integer.valueOf(attrs.getNamedItem("KOD2").getNodeValue()),
                                Integer.valueOf(attrs.getNamedItem("KOD3").getNodeValue())},
                        Integer.valueOf(attrs.getNamedItem("emp").getNodeValue()),
                        Integer.valueOf(attrs.getNamedItem("empMax").getNodeValue()));
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
        catch (DoubleMasterException ex) {
        }
    }
}
