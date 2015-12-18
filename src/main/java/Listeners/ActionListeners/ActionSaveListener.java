package Listeners.ActionListeners;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Обработчик нажатия кнопки сохранить
 */
public class ActionSaveListener implements ActionListener {
    protected JFrame carsList;
    protected FileDialog save;
    protected DefaultTableModel model;

    /**
     * Конструктор
     *
     * @param cList
     * @param s
     * @param m
     */
    public ActionSaveListener(JFrame cList, FileDialog s, DefaultTableModel m) {
        carsList = cList;
        save = s;
        model = m;
    }

    /**
     * Исключительная ситуация, когда файл не выбран
     */
    private class NullFileException extends Exception {
        public NullFileException() {
            super("Ошибка выбора файла");
        }
    }

    public void actionPerformed(ActionEvent e) {
        int i;
        save.setVisible(true);
        String fileName = save.getDirectory() + save.getFile();
        try {
            if (save.getFile() == null) {
                throw new NullFileException();
            }
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
            JOptionPane.showMessageDialog(carsList, ex.getMessage());
        }
        catch (TransformerException ex) {
            JOptionPane.showMessageDialog(carsList, ex.getMessage());
        }
        catch (IOException ex) {
            JOptionPane.showMessageDialog(carsList, ex.getMessage());
        }
        catch (ParserConfigurationException ex) {
            JOptionPane.showMessageDialog(carsList, ex.getMessage());
        }
        catch (NullFileException ex) {
            JOptionPane.showMessageDialog(carsList, ex.getMessage());
        }
        save.setFile("*.xml");
    }
}
