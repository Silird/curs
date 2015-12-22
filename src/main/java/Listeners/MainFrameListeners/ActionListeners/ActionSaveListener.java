package Listeners.MainFrameListeners.ActionListeners;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;

import SaveLoad.Save;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import util.WorkMasters;
import util.WorkRecords;

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
    private JFrame carsList;
    private FileDialog save;
    private WorkMasters masters;
    private WorkRecords records;

    /**
     * Конструктор
     *
     * @param cList
     * @param s
     * @param m
     */
    public ActionSaveListener(JFrame cList, FileDialog s, WorkMasters m, WorkRecords r) {
        carsList = cList;
        save = s;
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

    public void actionPerformed(ActionEvent e) {
        save.setVisible(true);
        String fileName = save.getDirectory() + save.getFile();
        try {
            if (save.getFile() == null) {
                throw new NullFileException();
            }
            Save save = new Save();
            save.SaveXML(fileName, masters, records);
        }
        catch (NullFileException ex) {
            JOptionPane.showMessageDialog(carsList, ex.getMessage());
        }
        save.setFile("*.xml");
    }
}
