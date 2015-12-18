package Listeners.MouseListeners;

import javax.swing.*;
import java.awt.event.*;

/**
 * Обработчик события наведения мышки на иконку распечатки
 */

public class MouseSaveListener implements MouseListener {
    private JButton saveBut;

    /**
     * Конструктор
     * @param saveB
     */
    public MouseSaveListener(JButton saveB) {
        saveBut = saveB;
    }

    public void mouseClicked(MouseEvent e) {

    }

    public void mousePressed(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {
        saveBut.setIcon(new ImageIcon(getClass().getResource("/pictures/save_active.png")));
    }

    public void mouseExited(MouseEvent e) {
        saveBut.setIcon(new ImageIcon(getClass().getResource("/pictures/save.png")));
    }
}
