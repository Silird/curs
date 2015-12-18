package Listeners.ActionListeners;

import util.MyComboBox;

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
    protected MyComboBox cCombo;

    /**
     * Конструктор
     * @param cList
     * @param m
     * @param c
     * @param cC
     */
    public ActionRemoveListener(JFrame cList, DefaultTableModel m, JTable c, MyComboBox cC) {
        carsList = cList;
        model = m;
        cars= c;
        cCombo = cC;
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
            cCombo.refresh(model);
        }
        catch (NullSelectedException ex) {
            JOptionPane.showMessageDialog(carsList, ex.getMessage());
        }
    }
}
