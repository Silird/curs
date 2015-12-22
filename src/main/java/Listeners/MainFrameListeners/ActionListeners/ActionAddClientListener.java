package Listeners.MainFrameListeners.ActionListeners;

import Frames.MasterFrame;
import Frames.RecordFrame;
import util.WorkMasters;
import util.WorkRecords;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionAddClientListener implements ActionListener {
    private WorkMasters masters;
    private WorkRecords records;
    private JFrame owner;

    public ActionAddClientListener(JFrame o, WorkMasters m, WorkRecords r) {
        owner = o;
        masters = m;
        records = r;
    }

    public void actionPerformed(ActionEvent e) {
        RecordFrame recordframe;
        recordframe = new RecordFrame(owner, masters, records);
    }
}
