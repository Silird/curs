package Listeners.MasterFrameListeners.ActionListeners;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionKOD2Listener implements ActionListener {
    private JDialog mframe;
    private JComboBox KOD1, KOD2;

    public ActionKOD2Listener(JDialog mf, JComboBox k1, JComboBox k2) {
        mframe = mf;
        KOD1 = k1;
        KOD2 = k2;
    }

    public void actionPerformed(ActionEvent e) {
        if (KOD1.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(mframe, "Не выбрана основная специализация");
            KOD2.setSelectedIndex(0);
        }
        else {
            if (KOD2.getSelectedIndex() == KOD1.getSelectedIndex()) {
                JOptionPane.showMessageDialog(mframe, "Выбрана повторяющаяся специализация");
                KOD2.setSelectedIndex(0);
            }
        }
    }
}
