package Listeners.MasterFrameListeners;

import util.Exceptions.DoubleMasterException;
import util.WorkMasters;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Событие на сохранении нового местера, если нет такого же
 */
public class ActionMasterAddListener implements ActionListener {
    private JDialog mframe;
    private JTextField nameField, empMaxField;
    private JComboBox KOD1Box, KOD2Box, KOD3Box;
    private WorkMasters mastersList;

    public ActionMasterAddListener(JDialog mf, JTextField nf, JTextField emf, JComboBox k1,
                                   JComboBox k2, JComboBox k3, WorkMasters ml) {
        mframe = mf;
        nameField = nf;
        empMaxField = emf;
        KOD1Box = k1;
        KOD2Box = k2;
        KOD3Box = k3;
        mastersList = ml;
    }

    private class NullNameException extends Exception {
        public NullNameException() {
            super("Не введено имя мастера");
        }
    }

    private class NullKODException extends Exception {
        public NullKODException() {
            super("Не выбрана основная специализация");
        }
    }

    private class NullEmpMaxException extends Exception {
        public NullEmpMaxException() {
            super("Не выбрана максимальная загруженность");
        }
    }

    public void actionPerformed(ActionEvent e) {
        try {
            if (nameField.getText().equals("")) {
                throw new NullNameException();
            }
            if (KOD1Box.getSelectedIndex() == 0) {
                throw new NullKODException();
            }
            if (empMaxField.getText().equals("")) {
                throw  new NullEmpMaxException();
            }
            mastersList.add(nameField.getText(), new int[] {KOD1Box.getSelectedIndex(), KOD2Box.getSelectedIndex(),
                KOD3Box.getSelectedIndex()}, Integer.valueOf(empMaxField.getText()));
            mframe.setVisible(false);
        }
        catch (NullNameException ex) {
            JOptionPane.showMessageDialog(mframe, ex.getMessage());
        }
        catch (NullKODException ex) {
            JOptionPane.showMessageDialog(mframe, ex.getMessage());
        }
        catch (NullEmpMaxException ex) {
            JOptionPane.showMessageDialog(mframe, ex.getMessage());
        }
        catch (DoubleMasterException ex) {
            JOptionPane.showMessageDialog(mframe, ex.getMessage());
        }
    }
}
