package Listeners.ActionListeners;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Обработка события нажатия на кнопку отмены редактирования элемента из таблицу
 */

public class ActionUndoListener implements ActionListener {
    protected JFrame bookList;
    protected JTable books;
    protected DefaultTableModel model;
    protected JButton addBut, checkEditBut, editBut, undoBut, removeBut;
    protected JTextField aName, bName, date;
    protected JCheckBox checkBook;

    /**
     * Конструктор
     * @param bList
     * @param m
     * @param b
     * @param addB
     * @param checkB
     * @param editB
     * @param undoB
     * @param removeB
     * @param aN
     * @param bN
     * @param d
     * @param cB
     */
    public ActionUndoListener(JFrame bList, DefaultTableModel m, JTable b, JButton addB, JButton checkB,
                               JButton editB, JButton undoB, JButton removeB, JTextField aN,
                               JTextField bN, JTextField d, JCheckBox cB) {
        bookList = bList;
        model = m;
        books = b;
        addBut = addB;
        checkEditBut = checkB;
        editBut = editB;
        undoBut = undoB;
        removeBut = removeB;
        aName = aN;
        bName = bN;
        date = d;
        checkBook = cB;
    }

    /**
     * Отмена редактирования элемента таблицы
     * @param e
     */
    public void actionPerformed(ActionEvent e) {
        addBut.setVisible(true);
        checkEditBut.setVisible(false);
        editBut.setEnabled(true);
        undoBut.setVisible(false);
        removeBut.setVisible(true);
        aName.setText("Клиент");
        bName.setText("Марка машины");
        date.setText("Дата");
        checkBook.setSelected(false);
        books.setEnabled(true);
    }
}
