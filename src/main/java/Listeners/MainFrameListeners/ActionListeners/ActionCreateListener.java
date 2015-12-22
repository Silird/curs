package Listeners.MainFrameListeners.ActionListeners;

import util.WorkMasters;
import util.WorkRecords;

import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Обработка события нажатия на кнопку создания новой базы данных
 */
public class ActionCreateListener implements ActionListener {
    private WorkMasters masters;
    private WorkRecords records;

    public ActionCreateListener(WorkMasters m, WorkRecords r) {
        masters = m;
        records = r;
    }

    /**
     * Очистка контейнеров
     * @param e
     */
    public void actionPerformed(ActionEvent e) {
        masters.Remove();
        records.Remove();
    }
}
