package util;

import util.Exceptions.DoubleMasterException;
import util.Exceptions.MasterEmploedExeption;

import javax.swing.table.DefaultTableModel;

/**
 * Класс объединённой работы  базой данных мастеров и связанной таблицей
 */
public class WorkMasters {
    Masters masters;
    DefaultTableModel model;

    public WorkMasters(DefaultTableModel m) {
        model = m;
        masters = new Masters();
        RefreshModel();
    }

    /**
     * Обновление таблицы
     */
    public void RefreshModel() {
        String tmp[][];
        int i, rows;
        tmp = masters.GiveStrings(false);
        rows = model.getRowCount();
        for (i = 0; i < rows; i++) {
            model.removeRow(0);
        }
        if (tmp == null) {

            return;
        }
        for (i = 0; i < tmp.length; i++) {
            model.addRow(tmp[i]);
        }
    }

    /**
     * Возвращает самого подходящего мастера по данному виду работы
     * @param kod
     * @return
     */
    public Master getMaster(int kod) {
        return masters.getMaster(kod);
    }

    /**
     * Взвращает мастера с заданынм именем
     * @param name
     * @return
     */
    public Master getMaster(String name) {
        return masters.getMaster(name);
    }

    /**
     * Добавление мастера
     * @param n
     * @param kod
     * @param emax
     * @throws DoubleMasterException если мастер уже есть
     */
    public void add(String n, int kod[], int emax) throws DoubleMasterException {
        masters.add(new Master(n, kod, emax));
        RefreshModel();
    }

    /**
     * Добавление мастера
     * @param n
     * @param kod
     * @param e
     * @param emax
     * @throws DoubleMasterException если мастер уже есть
     */
    public void add(String n, int kod[], int e, int emax) throws DoubleMasterException {
        masters.add(new Master(n, kod, e, emax));
        RefreshModel();
    }

    /**
     * Удаление всей таблицы
     */
    public void Remove() {
        masters.Remove();
        RefreshModel();
    }

    /**
     * Удаление элемента из базы данных на заданной строчке таблицы
     * @param row
     * @throws MasterEmploedExeption если мастер ещё занят работой
     */
    public void Remove(int row) throws MasterEmploedExeption {
        masters.Remove(model.getValueAt(row, 0).toString());
        RefreshModel();
    }

    /**
     * Выдача информации о базе данных в читабельнов виде таблицы
     * @param forsave
     * @return
     */
    public String[][] GiveStrings(boolean forsave) {
        return masters.GiveStrings(forsave);
    }
}
