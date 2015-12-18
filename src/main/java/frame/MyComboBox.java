package frame;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * Класс для выпадающего списка
 */

public class MyComboBox extends JComboBox {

    /**
     * Конструктор с построением списка используя модель таблицы
     * @param model
     */
    public MyComboBox(DefaultTableModel model) {
        super();
        refresh(model);
    }

    /**
     * Обновление списка сомбобокса по данной модели таблицы
     * @param model
     */
    public void refresh(DefaultTableModel model) {
        int i, rows, count;
        String tmp[], newComboModel[], current;
        removeAllItems();
        rows = model.getRowCount();
        tmp = new String[rows];
        count = 0;
        for (i = 0; i < rows; i++) {
            current = model.getValueAt(i, 0).toString();
            if (!containString(tmp, current, count)) {
                tmp[count] = current;
                count++;
            }
        }
        count++;
        newComboModel = new String[count];
        newComboModel[0] = "Клиент";
        for (i = 1; i < count; i++) {
            newComboModel[i] = tmp[(i - 1)];
        }
        setModel(new DefaultComboBoxModel<String>(newComboModel));
    }

    /**
     * Проверка на содержание в массиве tmp элемента, равного current
     * count - размер данного массива
     * @param tmp
     * @param current
     * @param count
     * @return
     */
    private boolean containString(String tmp[], String current, int count) {
        int i;
        boolean check;
        check = false;
        for (i = 0; ((i < count) && (!check)); i++) {
            if (tmp[i].equals(current)) {
                check = true;
            }
        }
        return check;
    }
}
