package SaveLoad;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import util.WorkMasters;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileOutputStream;
import java.io.IOException;

public class Save {
    public void SaveXML(String fileName, WorkMasters masters) {
        try {
            int i;
            String tmp[][];
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = builder.newDocument();
            tmp = masters.GiveStrings(true);
            if (tmp == null) {
                return;
            }
            Node masterlist = doc.createElement("masterlist");
            doc.appendChild(masterlist);
            for (i = 0; i < tmp.length; i++) {
                Element master = doc.createElement("master");
                masterlist.appendChild(master);
                master.setAttribute("name", tmp[i][0]);
                master.setAttribute("KOD1", tmp[i][1]);
                master.setAttribute("KOD2", tmp[i][2]);
                master.setAttribute("KOD3", tmp[i][3]);
                master.setAttribute("emp", tmp[i][4]);
                master.setAttribute("empMax", tmp[i][5]);
            }
            Transformer trans = TransformerFactory.newInstance().newTransformer();
            trans.setOutputProperty(OutputKeys.INDENT, "yes");
            FileOutputStream fis = new FileOutputStream(fileName);
            trans.transform(new DOMSource(doc), new StreamResult(fis));
        }
        catch (TransformerConfigurationException ex) {
            ex.printStackTrace();
        }
        catch (TransformerException ex) {
            ex.printStackTrace();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        catch (ParserConfigurationException ex) {
            ex.printStackTrace();
        }
    }
}
