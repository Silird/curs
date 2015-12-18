package Listeners.ActionListeners;

import javax.swing.*;
import java.awt.event.*;

/**
 * Обработчик события при нажатии на кнопку Поиск
 */
public class ActionFilterListener implements ActionListener {
    protected JFrame carsList;
    protected JTextField carName;
    protected JComboBox client;

    /**
     * Конструктор
     * @param cList
     * @param cName
     * @param c
     */
    public ActionFilterListener(JFrame cList, JTextField cName, JComboBox c) {
        carsList = cList;
        carName = cName;
        client = c;
    }

    /**
     * Исключительная синуация, когда пользователь не ввёл название книги
     */
    private class NullBookException extends Exception {
        public NullBookException() {
            super("Вы не ввели марку машины");
        }
    }

    /**
     * Исключительная синуация, когда пользователь не выбрал автора
     */
    private class NullAuthorException extends Exception {
        public NullAuthorException() {
            super("Вы не выбрали клиента");
        }
    }

    /**
     * Отлов исключительных ситуаций при нажатии на кнопку
     * @param e
     */
    public void actionPerformed(ActionEvent e) {
        try {
            //Search();
            if (client.getSelectedItem().equals("Клиент")) {
                throw new NullAuthorException();
            }
            if (carName.getText().equals("Марка машины")) {
                throw new NullBookException();
            }
        }
        catch (NullAuthorException ex) {
            JOptionPane.showMessageDialog(carsList, ex.getMessage());
        }
        catch (NullBookException ex) {
            JOptionPane.showMessageDialog(carsList, ex.getMessage());
        }
    }
}
