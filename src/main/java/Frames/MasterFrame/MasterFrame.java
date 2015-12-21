package Frames.MasterFrame;


import Frames.MyTable;
import util.WorkMasters;

import javax.swing.*;
import java.awt.*;

public class MasterFrame extends JDialog {
    //private JFrame masters;
    private WorkMasters mastersList;

    public MasterFrame(WorkMasters ml, JFrame owner) {
        super(owner);
        mastersList = ml;
        Show(owner);
    }

    public void Show(JFrame owner) {
        FrameInit(owner);
        setVisible(true);
    }

    private void FrameInit(JFrame owner) {
        setName("Добавление мастера");
        setSize(500, 200);
        setMaximumSize(new Dimension(500, 200));
        setLocationRelativeTo(owner);
        setModalityType(ModalityType.TOOLKIT_MODAL);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        //setDefaultCloseOperation(JDialog.EXIT_ON_CLOSE);
    }
}
