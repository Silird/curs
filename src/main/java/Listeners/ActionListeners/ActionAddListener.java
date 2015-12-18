package Listeners.ActionListeners;

import frame.MyComboBox;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Обработка события нажатия на кнопку Добавления элемента в таблицу
 */

public class ActionAddListener implements ActionListener {
    protected JFrame carsList;
    protected DefaultTableModel model;
    protected JTextField clientName, carName, date;
    protected JCheckBox ready;
    protected MyComboBox cCombo;

    /**
     * Конструктор
     * @param cList
     * @param m
     * @param clientN
     * @param carN
     * @param d
     * @param r
     * @param cC
     */
    public ActionAddListener(JFrame cList, DefaultTableModel m, JTextField clientN, JTextField carN, JTextField d,
                              JCheckBox r, MyComboBox cC) {
        carsList = cList;
        model = m;
        clientName = clientN;
        carName = carN;
        date = d;
        ready = r;
        cCombo = cC;
    }

    /**
     * Исключительная ситуация, когда пользователь не ввёл автора
     */
    private class NullclientNameException extends Exception {
        public NullclientNameException() {
            super("Ошибка: Не выбран клиент");
        }
    }

    /**
     * Исключительная ситуация, когда пользователь не ввёл название книги
     */
    private class NullcarNameException extends Exception {
        public NullcarNameException() {
            super("Ошибка: Не выбрана марка машины");
        }
    }

    /**
     * Исключительная ситуация, когда пользователь не ввёл дату
     */
    private class NullDateException extends Exception {
        public NullDateException() {
            super("Ошибка: Не выбрана дата");
        }
    }

    /**
     * Исключительная ситуация, когда пользователь пытается добавить существующую книгу
     */
    private class DoubleBookException extends Exception {
        public DoubleBookException() {
            super("Ошибка: Данная запись уже есть в базе данных");
        }
    }

    /**
     * Исключительная ситуация, когда пользователь пытается добавить существующую книгу,
     * у которой в наличии стоит "Нет"
     */
    private class DoubleBookCException extends Exception {
        public DoubleBookCException() {
            super("Ошибка: Данные об этой записи уже есть в базе данных, отредактируйте строку готовности");
        }
    }

    /**
     * Добавление в таблицу нового элемента
     * @param e
     */
    public void actionPerformed(ActionEvent e) {
        String checkText;
        int check;
        try {
            if (clientName.getText().equals("Клиент")) {
                throw new NullclientNameException();
            }
            if (carName.getText().equals("Марка машины")) {
                throw new NullcarNameException();
            }
            if (date.getText().equals("Дата")) {
                throw new NullDateException();
            }
            if (ready.isSelected()) {
                checkText = "Готово";
            }
            else {
                checkText = "Не готово";
            }
            check = checkTable(model, clientName.getText(), carName.getText(), date.getText());
            if (check == 1) {
                throw new DoubleBookCException();
            }
            if (check == 2) {
                throw new DoubleBookException();
            }
            model.addRow(new String[]{clientName.getText(), carName.getText(), date.getText(), checkText});
            clientName.setText("Клиент");
            carName.setText("Марка машины");
            date.setText("Дата");
            ready.setSelected(false);
            cCombo.refresh(model);
        }
        catch (NullclientNameException ex) {
            JOptionPane.showMessageDialog(carsList, ex.getMessage());
        }
        catch (NullcarNameException ex) {
            JOptionPane.showMessageDialog(carsList, ex.getMessage());
        }
        catch (NullDateException ex) {
            JOptionPane.showMessageDialog(carsList, ex.getMessage());
        }
        catch (DoubleBookException ex) {
            JOptionPane.showMessageDialog(carsList, ex.getMessage());
        }
        catch (DoubleBookCException ex) {
            JOptionPane.showMessageDialog(carsList, ex.getMessage());
        }
    }

    private int checkTable(DefaultTableModel model, String aN, String bN, String dS) {
        int check, i, count;
        check = 0;
        count = model.getRowCount();
        for (i = 0; ((i < count) && (check == 0)); i++) {
            if ((model.getValueAt(i, 0).toString(). equals(aN)) &&
                    (model.getValueAt(i, 1).toString().equals(bN)) &&
                    (model.getValueAt(i, 2).toString().equals(bN))) {
                if (model.getValueAt(i, 3).toString().equals("Не готово")) {
                    check = 1;
                }
                else {
                    check = 2;
                }
            }
        }
        return check;
    }
}
