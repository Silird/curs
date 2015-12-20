package Listeners.MainFrameListeners.MouseListeners;

import javax.swing.*;
import java.awt.event.*;

/**
 * Обработчик события наведения мышки на иконку удаления
 */

public class MouseRemoveListener implements MouseListener {
    private JButton removeBut;

    /**
     * Конструктор
     * @param removeB
     */
    public MouseRemoveListener(JButton removeB) {
        removeBut = removeB;
    }

    public void mouseClicked(MouseEvent e) {

    }

    public void mousePressed(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {

    }

    /**
     * При наведении мышки отобразить активную иконку
     * @param e
     */
    public void mouseEntered(MouseEvent e) {
        removeBut.setIcon(new ImageIcon(getClass().getResource("/pictures/remove_active.png")));
    }

    /**
     * При отведении мышки отобразить стандартную иконку
     * @param e
     */
    public void mouseExited(MouseEvent e) {
        removeBut.setIcon(new ImageIcon(getClass().getResource("/pictures/remove.png")));
    }
}
