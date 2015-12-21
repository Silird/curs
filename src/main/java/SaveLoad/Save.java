package SaveLoad;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

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
    public void SaveXML(String fileName, DefaultTableModel model) {
        try {
            int i;
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = builder.newDocument();
            Node carslist = doc.createElement("carslist");
            doc.appendChild(carslist);
            for (i = 0; i < model.getRowCount(); i++) {
                Element car = doc.createElement("car");
                carslist.appendChild(car);
                car.setAttribute("client", (String) model.getValueAt(i, 0));
                car.setAttribute("carname", (String) model.getValueAt(i, 1));
                car.setAttribute("date", (String) model.getValueAt(i, 2));
                car.setAttribute("ready", (String) model.getValueAt(i, 3));
            }
            Transformer trans = TransformerFactory.newInstance().newTransformer();
            trans.setOutputProperty(OutputKeys.INDENT, "yes");
            FileOutputStream fis = new FileOutputStream(fileName);
            trans.transform(new DOMSource(doc), new StreamResult(fis));
        }
        catch (TransformerConfigurationException ex) {
            ex.printStackTrace();;
        }
        catch (TransformerException ex) {
            ex.printStackTrace();;
        }
        catch (IOException ex) {
            ex.printStackTrace();;
        }
        catch (ParserConfigurationException ex) {
            ex.printStackTrace();;
        }
    }
}
