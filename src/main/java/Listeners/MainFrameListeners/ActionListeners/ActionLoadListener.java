package Listeners.MainFrameListeners.ActionListeners;

import SaveLoad.Load;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Node;
import util.WorkMasters;
import util.WorkRecords;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

/**
 * Обработка события нажатия на кнопку загрузки
 */
public class ActionLoadListener implements ActionListener {
    protected JFrame carsList;
    protected FileDialog load;
    private WorkMasters masters;
    private WorkRecords records;


    public ActionLoadListener(JFrame cList, FileDialog l, WorkMasters m, WorkRecords r) {
        carsList = cList;
        load = l;
        masters = m;
        records = r;
    }

    /**
     * Исключительная ситуация, когда файл не выбран
     */
    private class NullFileException extends Exception {
        public NullFileException() {
            super("Ошибка выбора файла");
        }
    }

    /**
     * Чтение таблицы из файла
     * @param e
     */
    public void actionPerformed(ActionEvent e) {
        load.setVisible(true);
        String fileName = load.getDirectory() + load.getFile();
        try {
            if (load.getFile() == null) {
                throw new NullFileException();
            }
            //LoadXML(fileName);
            Load load = new Load();
            load.LoadXML(fileName, masters, records);
        }
        catch (NullFileException ex) {
            JOptionPane.showMessageDialog(carsList, ex.getMessage());
        }
        load.setFile("*.xml");
    }

    /*
    public void LoadXML(String fileName) {
        int i;
        try {
            int rows = clientModel.getRowCount();
            for (i = 0; i < rows; i++) {
                clientModel.removeRow(0);
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
                clientModel.addRow(new String[] {client, carName, date, ready});
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
    */
}
