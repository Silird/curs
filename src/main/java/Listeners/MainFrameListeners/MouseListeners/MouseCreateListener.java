package Listeners.MainFrameListeners.MouseListeners;

import javax.swing.*;
import java.awt.event.*;

/**
 * Обработчик события наведения мышки на иконку выхода
 */

public class MouseCreateListener implements MouseListener {
    private JButton createBut;

    /**
     * Конструктор
     * @param createB
     */
    public MouseCreateListener(JButton createB) {
        createBut = createB;
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
        createBut.setIcon(new ImageIcon(getClass().getResource("/pictures/create_active.png")));
    }

    /**
     * При отведении мышки отобразить стандартную иконку
     * @param e
     */
    public void mouseExited(MouseEvent e) {
        createBut.setIcon(new ImageIcon(getClass().getResource("/pictures/create.png")));
    }
}
