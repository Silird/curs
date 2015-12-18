package Listeners.MouseListeners;

import javax.swing.*;
import java.awt.event.*;

/**
 * Обработчик события наведения мышки на иконку фильтра
 */

public class MouseFilterListener implements MouseListener {
    private JButton filterBut;

    public MouseFilterListener(JButton filterB) {
        filterBut = filterB;
    }

    /**
     * Конструктор
     * @param e
     */
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
        filterBut.setIcon(new ImageIcon(getClass().getResource("/pictures/filter_active.png")));
    }

    /**
     * При отведении мышки отобразить стандартную иконку
     * @param e
     */
    public void mouseExited(MouseEvent e) {
        filterBut.setIcon(new ImageIcon(getClass().getResource("/pictures/filter.png")));
    }
}
