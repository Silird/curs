package SaveLoad;

import org.w3c.dom.*;
import org.xml.sax.SAXException;
import util.Exceptions.DoubleClientException;
import util.Exceptions.DoubleMasterException;
import util.Master;
import util.WorkMasters;
import util.WorkRecords;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class Load {

    public void LoadXML(String fileName, WorkMasters masters, WorkRecords records) {
        int i;
        try {
            /*
            int rows = model.getRowCount();
            for (i = 0; i < rows; i++) {
                model.removeRow(0);
            }
            */
            masters.Remove();
            records.Remove();
            DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = dBuilder.parse(new File(fileName));
            //NodeList TO = doc.getChildNodes();
            //Element TO = doc.get
            //NodeList nlMaster = TO.getElementsByTagName("masters");
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
            NodeList nlRecords = doc.getElementsByTagName("record");
            for (i = 0; i < nlRecords.getLength(); i++) {
                Node elem = nlRecords.item(i);
                NamedNodeMap attrs = elem.getAttributes();
                Master master = masters.getMaster(attrs.getNamedItem("Master").getNodeValue());
                records.add(attrs.getNamedItem("Client").getNodeValue(), attrs.getNamedItem("Car").getNodeValue(),
                        attrs.getNamedItem("Breacking").getNodeValue(), Integer.valueOf(attrs.getNamedItem("KOD").getNodeValue()),
                        master, Boolean.valueOf(attrs.getNamedItem("Ready").getNodeValue()));
            }
        }
        catch (SAXException ex) {
            ex.printStackTrace();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        catch (ParserConfigurationException ex) {
            ex.printStackTrace();
        }
        catch (DoubleMasterException ex) {
        }
        catch (DoubleClientException ex) {
        }
    }
}
