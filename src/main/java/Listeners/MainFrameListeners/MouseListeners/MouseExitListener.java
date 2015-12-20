package Listeners.MainFrameListeners.MouseListeners;

import javax.swing.*;
import java.awt.event.*;

/**
 * Обработчик события наведения мышки на иконку выхода
 */

public class MouseExitListener implements MouseListener {
    private JButton exitBut;

    /**
     * Конструктор
     * @param exitB
     */
    public MouseExitListener(JButton exitB) {
        exitBut = exitB;
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
        exitBut.setIcon(new ImageIcon(getClass().getResource("/pictures/exit_active.png")));
    }

    /**
     * При отведении мышки отобразить стандартную иконку
     * @param e
     */
    public void mouseExited(MouseEvent e) {
        exitBut.setIcon(new ImageIcon(getClass().getResource("/pictures/exit.png")));
    }
}
