package Listeners.MouseListeners;

import javax.swing.*;
import java.awt.event.*;

/**
 * Обработчик события наведения мышки на иконку добавления записи
 */

public class MouseAddListener implements MouseListener {
    private JButton addBut;

    /**
     * Конструктор
     * @param addB
     */
    public MouseAddListener(JButton addB) {
        addBut = addB;
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
        addBut.setIcon(new ImageIcon(getClass().getResource("/pictures/add_active.png")));
    }

    /**
     * При отведении мышки отобразить стандартную иконку
     * @param e
     */
    public void mouseExited(MouseEvent e) {
        addBut.setIcon(new ImageIcon(getClass().getResource("/pictures/add.png")));
    }
}
