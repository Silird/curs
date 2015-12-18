package Listeners.MouseListeners;

import javax.swing.*;
import java.awt.event.*;

/**
 * Обработчик события наведения мышки на иконку отмены
 */

public class MouseUndoListener implements MouseListener {
    private JButton undoBut;

    /**
     * Конструктор
     * @param undoB
     */
    public MouseUndoListener(JButton undoB) {
        undoBut = undoB;
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
        undoBut.setIcon(new ImageIcon(getClass().getResource("/pictures/undo_active.png")));
    }

    /**
     * При отведении мышки отобразить стандартную иконку
     * @param e
     */
    public void mouseExited(MouseEvent e) {
        undoBut.setIcon(new ImageIcon(getClass().getResource("/pictures/undo.png")));
    }
}
