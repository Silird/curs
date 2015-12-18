package frame;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * Таблица, которую нельзя редактировать напрямую
 */
public class MyTable extends JTable {

    /**
     * Конструктор таблицы, не отличается от JTable
     * m - заданая модель
     * @param m
     */
    public MyTable (DefaultTableModel m) {
        super(m);
    }

    /**
     * Отмена реакции на изменение ячейки[rowIndex][columnIndex] таблицы
     * @param rowIndex
     * @param columnIndex
     * @return
     */
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
}
