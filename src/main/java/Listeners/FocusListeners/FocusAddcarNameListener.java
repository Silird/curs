package Listeners.FocusListeners;

import javax.swing.*;
import java.awt.event.*;

/**
 * Обработчик события фокуса поля для ввода названия книги при добавлении в таблицу
 */

public class FocusAddcarNameListener implements FocusListener {
    private JTextField carName;

    /**
     * Конструктор
     * @param c
     */
    public FocusAddcarNameListener(JTextField c) {
        carName = c;
    }

    /**
     * Если при попадании в фокус введена стандартная строка, то стереть её
     * @param e
     */
    public void focusGained(FocusEvent e) {
        if (carName.getText().equals("Марка машины")) {
            carName.setText("");
        }
    }

    /**
     * Если при исчезновении фокуса введена пустая строка, то ввести стандартную
     * @param e
     */
    public void focusLost(FocusEvent e) {
        if (carName.getText().equals("")) {
            carName.setText("Марка машины");
        }
    }
}
