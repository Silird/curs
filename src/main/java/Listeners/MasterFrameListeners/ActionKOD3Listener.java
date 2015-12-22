package Listeners.MasterFrameListeners;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Проверка на выбор №1 доп. специализации и на выбор одинаковой
 */
public class ActionKOD3Listener implements ActionListener {
    private JDialog mframe;
    private JComboBox KOD1, KOD2, KOD3;

    public ActionKOD3Listener(JDialog mf, JComboBox k1, JComboBox k2, JComboBox k3) {
        mframe = mf;
        KOD1 = k1;
        KOD2 = k2;
        KOD3 = k3;
    }

    public void actionPerformed(ActionEvent e) {
        if (KOD2.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(mframe, "Не выбрана доп. специализация №1");
            KOD3.setSelectedIndex(0);
        }
        else {
            if ((KOD3.getSelectedIndex() == KOD1.getSelectedIndex()) || (KOD3.getSelectedIndex() == KOD2.getSelectedIndex())) {
                JOptionPane.showMessageDialog(mframe, "Выбрана повторяющаяся специализация");
                KOD3.setSelectedIndex(0);
            }
        }
    }
}
