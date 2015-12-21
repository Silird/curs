package Listeners.MainFrameListeners.ActionListeners;

import SaveLoad.Save;
import util.WorkMasters;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Действие по нжатию на кнопку выхода
 */

public class ActionExitListener implements ActionListener {
    private WorkMasters masters;

    public ActionExitListener(WorkMasters m) {
        masters = m;
    }

    /**
     * Выход из программы
     * @param e
     */
    public void actionPerformed(ActionEvent e) {
        Save save;
        save = new Save();
        save.SaveXML("D:\\Work\\Java\\Универ\\curs\\Сохранённые таблицы\\saved.xml", masters);
        System.exit(0);
    }
}
