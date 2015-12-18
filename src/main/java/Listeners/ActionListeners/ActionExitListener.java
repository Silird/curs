package Listeners.ActionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Действие по нжатию на кнопку выхода
 */

public class ActionExitListener implements ActionListener {

    /**
     * Выход из программы
     * @param e
     */
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
}
