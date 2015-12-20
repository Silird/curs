package Listeners.MainFrameListeners.ActionListeners;

import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Обработка события нажатия на кнопку создания
 */

public class ActionCreateListener implements ActionListener {
    protected DefaultTableModel model;

    /**
     * Конструктор
     * @param m
     */
    public ActionCreateListener(DefaultTableModel m) {
        model = m;
    }

    /**
     * Очистка таблицы
     * @param e
     */
    public void actionPerformed(ActionEvent e) {
        int i, rows;
        rows = model.getRowCount();
        for (i = 0; i < rows; i++) {
            model.removeRow(0);
        }
    }
}
