package Listeners.ActionListeners;

import frame.MyComboBox;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Обработка события нажатия на кнопку принятия редактирования элемента из таблицу
 */

public class ActionAcceptListener implements ActionListener {
    protected JFrame carsList;
    protected DefaultTableModel model;
    protected JTable cars;
    protected JButton addBut, checkEditBut, editBut, undoBut, removeBut;
    protected JTextField clientName, carName, date;
    protected JCheckBox ready;
    protected MyComboBox cCombo;

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
     * @param readyB
     * @param cC
     */
    public ActionAcceptListener(JFrame cList, DefaultTableModel m, JTable c, JButton addB, JButton checkB,
                               JButton editB, JButton undoB, JButton removeB, JTextField clientN,
                               JTextField carN, JTextField d, JCheckBox readyB, MyComboBox cC) {
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
        ready = readyB;
        cCombo = cC;
    }

    /**
     * Исключительная ситуация, когда пользователь не ввёл автора
     */
    private class NullaNameException extends Exception {
        public NullaNameException() {
            super("Ошибка: Не выбран автор");
        }
    }

    /**
     * Исключительная ситуация, когда пользователь не ввёл название книги
     */
    private class NullbNameException extends Exception {
        public NullbNameException() {
            super("Ошибка: Не выбрано название книги");
        }
    }

    /**
     * Исключительная ситуация, когда пользователь пытается добавить существующую книгу
     */
    private class DoubleBookException extends Exception {
        public DoubleBookException() {
            super("Ошибка: Данная книге уже есть в базе данных");
        }
    }

    /**
     * Исключительная ситуация, когда пользователь пытается добавить существующую книгу,
     * у которой в наличии стоит "Нет"
     */
    private class DoubleBookCException extends Exception {
        public DoubleBookCException() {
            super("Ошибка: Данные об этой книге уже есть в базе данных, отредактируйте строку наличие");
        }
    }

    /**
     * Принятие редактирования элемента таблицы
     * @param e
     */
    public void actionPerformed(ActionEvent e) {
        int currentrow, check;
        try {
            if (clientName.getText().equals("Клиент")) {
                throw new NullaNameException();
            }
            if (carName.getText().equals("Марка машины")) {
                throw new NullbNameException();
            }
            currentrow = cars.getSelectedRow();
            check = checkTable(model, clientName.getText(), carName.getText(), date.getText(), ready.isSelected());
            if (check == 1) {
                throw new DoubleBookCException();
            }
            if (check == 2) {
                throw new DoubleBookException();
            }
            model.setValueAt(clientName.getText(), currentrow, 0);
            model.setValueAt(carName.getText(), currentrow, 1);
            model.setValueAt(date.getText(), currentrow, 2);
            if (ready.isSelected()) {
                model.setValueAt("Готово", currentrow, 3);
            }
            else {
                model.setValueAt("Не готово", currentrow, 3);
            }
            addBut.setVisible(true);
            checkEditBut.setVisible(false);
            editBut.setEnabled(true);
            undoBut.setVisible(false);
            removeBut.setVisible(true);
            clientName.setText("Клиент");
            carName.setText("Марка машины");
            ready.setSelected(false);
            cars.setEnabled(true);
            cCombo.refresh(model);
        }
        catch (NullaNameException ex) {
            JOptionPane.showMessageDialog(carsList, ex.getMessage());
        }
        catch (NullbNameException ex) {
            JOptionPane.showMessageDialog(carsList, ex.getMessage());
        }
        catch (DoubleBookException ex) {
            JOptionPane.showMessageDialog(carsList, ex.getMessage());
        }
        catch (DoubleBookCException ex) {
            JOptionPane.showMessageDialog(carsList, ex.getMessage());
        }
    }

    /**
     * Проверка на содержании в таблице model комбинации автор(aN) и название книги(bN)
     * Sel показывает статус наличия книги
     * @param model
     * @param clientN
     * @param carN
     * @param Sel
     * @return
     */
    private int checkTable(DefaultTableModel model, String clientN, String carN, String dateS, boolean Sel) {
        int check, i, count;
        check = 0;
        count = model.getRowCount();
        for (i = 0; ((i < count) && (check == 0)); i++) {
            if ((model.getValueAt(i, 0).toString(). equals(clientN) &&
                    (model.getValueAt(i, 1).toString().equals(carN)) &&
                    (model.getValueAt(i, 2).toString().equals(dateS)))) {
                if ((model.getValueAt(i, 3).toString().equals("Не готово") && (!Sel))) {
                    check = 1;
                }
                else if ((model.getValueAt(i, 3).toString().equals("Готово") && (Sel))) {
                    check = 2;
                }
            }
        }
        return check;
    }
}
