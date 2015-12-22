package util;

import util.Exceptions.AlreadyDoneException;
import util.Exceptions.CantDoItException;
import util.Exceptions.CarNotReadyExeption;
import util.Exceptions.DoubleClientException;

import javax.swing.table.DefaultTableModel;

/**
 * База данных записей и модель таблицы, связанная работа
 */
public class WorkRecords {
    Records records;
    DefaultTableModel clientModel, adminModel;

    public WorkRecords(DefaultTableModel cm, DefaultTableModel am) {
        clientModel = cm;
        adminModel = am;
        records = new Records();
        RefreshModels();
    }

    /**
     * Обновление связанных моделей
     */
    private void RefreshModels() {
        String tmp1[][], tmp2[][];
        int i, rows;
        tmp1 = records.GiveClientStrings();
        tmp2 = records.GiveAdminStrings();
        rows = clientModel.getRowCount();
        for (i = 0; i < rows; i++) {
            clientModel.removeRow(0);
            adminModel.removeRow(0);
        }
        if (tmp1 == null) {
            return;
        }
        for (i = 0; i < tmp1.length; i++) {
            clientModel.addRow(tmp1[i]);
            adminModel.addRow(tmp2[i]);
        }
    }

    /**
     * Добавление новой записи
     * @param cl
     * @param c
     * @param br
     * @param kod
     * @param masters
     * @throws DoubleClientException если уже есть
     * @throws CantDoItException если никто не может взять
     */
    public void add(String cl, String c, String br, int kod, WorkMasters masters) throws DoubleClientException, CantDoItException {
        records.add(new Record(cl, c, br, kod, masters));
        RefreshModels();
        masters.RefreshModel();
    }

    /**
     * Добавление новой записи
     * @param cl
     * @param c
     * @param br
     * @param kod
     * @param m
     * @param r
     * @throws DoubleClientException если уже есть
     */
    public void add(String cl, String c, String br, int kod, Master m, boolean r) throws DoubleClientException {
        records.add(new Record(cl, c, br, kod, m, r));
        RefreshModels();
    }

    /**
     * Удаление базы данных
     */
    public void Remove() {
        records.Remove();
        RefreshModels();
    }

    /**
     * Удаление элемента под данным номером стори в таблице
     * @param row
     * @throws CarNotReadyExeption машина ещё не готова
     */
    public void Remove(int row) throws CarNotReadyExeption {
        records.Remove(clientModel.getValueAt(row, 0).toString());
        RefreshModels();
    }

    /**
     * Установить готовность
     * @param row
     * @param masters
     * @throws AlreadyDoneException уже готова
     */
    public void setReady(int row, WorkMasters masters) throws AlreadyDoneException {
        records.setReady(clientModel.getValueAt(row, 0).toString());
        RefreshModels();
        masters.RefreshModel();
    }

    /**
     * Вывод массива строк для основной таблицы
     * @return
     */
    public String[][] GiveClientStrings() {
        return records.GiveClientStrings();
    }

    /**
     * Вывод массива строк для дополнительной таблицы
     * @return
     */
    public String[][] GiveAdminStrings() {
        return records.GiveAdminStrings();
    }

    /**
     * Вывод массива строк для сохранений в файл
     * код работы и готовность в виде чисел
     * @return
     */
    public String[][] GiveSaveStrings() {
        return records.GiveSaveStrings();
    }
}
