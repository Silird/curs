package Listeners.MainFrameListeners.MouseListeners;

import javax.swing.*;
import java.awt.event.*;

/**
 * Обработчик события наведения мышки на иконку редактирования
 */

public class MouseEditListener implements MouseListener {
    private JButton editBut;

    /**
     * Конструктор
     * @param editB
     */
    public MouseEditListener(JButton editB) {
        editBut = editB;
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
        editBut.setIcon(new ImageIcon(getClass().getResource("/pictures/edit_active.png")));
    }

    /**
     * При отведении мышки отобразить стандартную иконку
     * @param e
     */
    public void mouseExited(MouseEvent e) {
        editBut.setIcon(new ImageIcon(getClass().getResource("/pictures/edit.png")));
    }
}
