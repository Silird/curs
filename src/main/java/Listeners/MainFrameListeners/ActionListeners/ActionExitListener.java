package Listeners.MainFrameListeners.ActionListeners;

import SaveLoad.Save;
import util.WorkMasters;
import util.WorkRecords;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Действие по нажатию на кнопку выхода, сохранение базы данных
 */
public class ActionExitListener implements ActionListener {
    private WorkMasters masters;
    private WorkRecords records;

    public ActionExitListener(WorkMasters m, WorkRecords r) {
        masters = m;
        records = r;
    }

    /**
     * Выход из программы
     * @param e
     */
    public void actionPerformed(ActionEvent e) {
        Save save;
        save = new Save();
        save.SaveXML("Сохранённые таблицы\\saved.xml", masters, records);
        System.exit(0);
    }
}
