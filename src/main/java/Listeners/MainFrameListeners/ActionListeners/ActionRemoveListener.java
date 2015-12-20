package Listeners.MainFrameListeners.ActionListeners;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Обработка события нажатия на кнопку удаления элемента из таблицу
 */

public class ActionRemoveListener implements ActionListener {
    protected JFrame carsList;
    protected DefaultTableModel model;
    protected JTable cars;

    /**
     * Конструктор
     * @param cList
     * @param m
     * @param c
     */
    public ActionRemoveListener(JFrame cList, DefaultTableModel m, JTable c) {
        carsList = cList;
        model = m;
        cars= c;
    }

    /**
     * Исключительная ситуация, когда не выбрана строка для удаления
     */
    private class NullSelectedException extends Exception {
        public NullSelectedException() {
            super("Ошибка: Не выбрана строка таблицы для удаления");
        }
    }

    /**
     * Удаление выбраных строчек таблицы
     * @param e
     */
    public void actionPerformed(ActionEvent e) {
        int deliting[], i, begin;
        try {
            deliting = cars.getSelectedRows();
            if (deliting == null) {
                throw new NullSelectedException();
            }
            for (i = cars.getSelectedRowCount(); i > 0; i--) {
                model.removeRow(deliting[i - 1]);
            }
        }
        catch (NullSelectedException ex) {
            JOptionPane.showMessageDialog(carsList, ex.getMessage());
        }
    }
}
