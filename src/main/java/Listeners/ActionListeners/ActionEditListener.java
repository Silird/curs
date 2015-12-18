package Listeners.ActionListeners;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Обработка события нажатия на кнопку редактирования элемента из таблицу
 */

public class ActionEditListener implements ActionListener {
    protected JFrame carsList;
    protected DefaultTableModel model;
    protected JTable cars;
    protected JButton addBut, checkEditBut, editBut, undoBut, removeBut;
    protected JTextField clientName, carName, date;
    protected JCheckBox ready;

    /**
     * Конструктор
     * @param cList
     * @param m
     * @param c
     * @param addB
     * @param checkB
     * @param editB
     * @param undoB
     * @param removeB
     * @param clientN
     * @param carN
     * @param d
     * @param r
     */
    public ActionEditListener(JFrame cList, DefaultTableModel m, JTable c, JButton addB, JButton checkB,
                               JButton editB, JButton undoB, JButton removeB, JTextField clientN,
                               JTextField carN, JTextField d, JCheckBox r) {
        carsList = cList;
        model = m;
        cars = c;
        addBut = addB;
        checkEditBut = checkB;
        editBut = editB;
        undoBut = undoB;
        removeBut = removeB;
        clientName = clientN;
        carName = carN;
        date = d;
        ready = r;
    }

    /**
     * Исключительная ситуация, когда пользователь не выбрал строку таблицы для редактирования
     */
    private class NullSelectedException extends Exception {
        public NullSelectedException() {
            super("Ошибка: Не выбрана строка таблицы для редактирования");
        }
    }

    /**
     * Исключительная ситуация, когда пользователь выбрал несколько строк таблицы для редактирования
     */
    private class MultipleSelectedException extends Exception {
        public MultipleSelectedException() {
            super("Ошибка: Выбрано несколько строк таблицы");
        }
    }

    /**
     * Начало редактирования элемента таблицы
     * @param e
     */
    public void actionPerformed(ActionEvent e) {
        int count, currentrow;
        try {
            count = cars.getSelectedRowCount();
            if (count == 0) {
                throw new NullSelectedException();
            }
            if (count > 1) {
                throw new MultipleSelectedException();
            }
            currentrow = cars.getSelectedRow();
            clientName.setText(model.getValueAt(currentrow, 0).toString());
            carName.setText(model.getValueAt(currentrow, 1).toString());
            date.setText(model.getValueAt(currentrow, 2).toString());
            if (model.getValueAt(currentrow, 3).toString().equals("Готово")) {
                ready.setSelected(true);
            }
            else {
                ready.setSelected(false);
            }
            addBut.setVisible(false);
            checkEditBut.setVisible(true);
            editBut.setEnabled(false);
            undoBut.setVisible(true);
            removeBut.setVisible(false);
            cars.setEnabled(false);
        }
        catch (NullSelectedException ex) {
            JOptionPane.showMessageDialog(carsList, ex.getMessage());
        }
        catch (MultipleSelectedException ex) {
            JOptionPane.showMessageDialog(carsList, ex.getMessage());
        }
    }
}
