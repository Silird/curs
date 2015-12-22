package Listeners.MainFrameListeners.ActionListeners;

import Frames.MyTable;
import util.Exceptions.CarNotReadyExeption;
import util.WorkRecords;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Выписывание записи, если машина была готова
 */
public class ActionRemoveRecordListener implements ActionListener {
    private JFrame frame;
    private JTabbedPane tables;
    private MyTable table;
    private WorkRecords records;

    public ActionRemoveRecordListener(JFrame f, JTabbedPane ts, MyTable t, WorkRecords r) {
        frame = f;
        tables = ts;
        table = t;
        records = r;
    }

    private class NotSelectedTableException extends Exception {
        public NotSelectedTableException() {
            super("Не открыта основная таблица");
        }
    }

    private class NotSelectedClientException extends Exception {
        public NotSelectedClientException() {
            super("Не выбрана запись для удаления");
        }
    }

    private class DoubleSelectedClientException extends Exception {
        public DoubleSelectedClientException() {
            super("Выбрано несколько записей");
        }
    }

    public void actionPerformed(ActionEvent e) {
        try {
            if (tables.getSelectedIndex() != 0) {
                throw new NotSelectedTableException();
            }
            if (table.getSelectedRowCount() == 0) {
                throw new NotSelectedClientException();
            }
            if (table.getSelectedRowCount() > 1) {
                throw new DoubleSelectedClientException();
            }
            records.Remove(table.getSelectedRow());
        }
        catch (NotSelectedTableException ex) {
            JOptionPane.showMessageDialog(frame, ex.getMessage());
        }
        catch (NotSelectedClientException ex) {
            JOptionPane.showMessageDialog(frame, ex.getMessage());
        }
        catch (DoubleSelectedClientException ex) {
            JOptionPane.showMessageDialog(frame, ex.getMessage());
        }
        catch (CarNotReadyExeption ex) {
            JOptionPane.showMessageDialog(frame, ex.getMessage());
        }
    }
}
