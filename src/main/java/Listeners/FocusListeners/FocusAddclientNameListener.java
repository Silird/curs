package Listeners.FocusListeners;

import javax.swing.*;
import java.awt.event.*;

/**
 * Обработчик события фокуса поля для ввода имени автора при добавлении в таблицу
 */

public class FocusAddclientNameListener implements FocusListener {
    private JTextField clientName;

    /**
     * Конструктор
     * @param c
     */
    public FocusAddclientNameListener(JTextField c) {
        clientName = c;
    }

    /**
     * Если при попадании в фокус введена стандартная строка, то стереть её
     * @param e
     */
    public void focusGained(FocusEvent e) {
        if (clientName.getText().equals("Клиент")) {
            clientName.setText("");
        }
    }

    /**
     * Если при исчезновении фокуса введена пустая строка, то ввести стандартную
     * @param e
     */
    public void focusLost(FocusEvent e) {
        if (clientName.getText().equals("")) {
            clientName.setText("Клиент");
        }
    }
}
