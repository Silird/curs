package Frames;

import Listeners.RecordFrameListeners.ActionRecordCancelListener;
import util.WorkMasters;
import util.WorkRecords;

import javax.swing.*;
import java.awt.*;

public class RecordFrame extends JDialog {
    //Базы данных
    private WorkMasters masters;
    private WorkRecords records;
    //Интерфейс
    private JPanel buttonPanel;
    private JButton addBut, cancelBut;
    //Панельки ввода
    private JPanel enterPanel, clientPanel, clientLeftPanel, carPanel, carLeftPanel, KODPanel,
            breackingPanel, breackingLeftPanel;
    private JLabel clientLabel, carLabel, breackingLabel;
    private JTextField clientField, carField, breackingField;
    private JComboBox KODBox;

    public RecordFrame(JFrame owner, WorkMasters m, WorkRecords r) {
        super(owner);
        masters = m;
        records = r;
        Show(owner);
    }

    public void Show(JFrame owner) {
        FrameInit(owner);
        EnterPanelInit(); //Посередине
        ButtonsInit(); //Внизу
        ListenersInit();
        setVisible(true);
    }

    private void FrameInit(JFrame owner) {
        setTitle("Запись клиента");
        setSize(500, 250);
        setResizable(false);
        setLocationRelativeTo(owner);
        setModalityType(ModalityType.TOOLKIT_MODAL);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
    }

    private void EnterPanelInit() {
        clientLabel = new JLabel("Имя клиента");
        clientField = new JTextField(20);
        clientLeftPanel = new JPanel();
        clientLeftPanel.add(clientLabel);
        clientLeftPanel.add(clientField);
        clientPanel = new JPanel();
        clientPanel.add(clientLeftPanel, BorderLayout.WEST);

        carLabel = new JLabel("Марка машины");
        carField = new JTextField(20);
        carLeftPanel = new JPanel();
        carLeftPanel.add(carLabel);
        carLeftPanel.add(carField);
        carPanel = new JPanel();
        carPanel.add(carLeftPanel, BorderLayout.WEST);

        KODBox = new JComboBox(new String[] {"Вид неисправности", "Покраска", "Кузовной ремонт", "Ремонт подвески",
                "Ремонт двигателя", "Развал-схождение", "Прочее"});
        KODPanel = new JPanel();
        KODPanel.add(KODBox);

        breackingLabel = new JLabel("Описание неисправности");
        breackingField = new JTextField(20);
        breackingLeftPanel = new JPanel();
        breackingLeftPanel.add(breackingLabel);
        breackingLeftPanel.add(breackingField);
        breackingPanel = new JPanel();
        breackingPanel.add(breackingLeftPanel, BorderLayout.WEST);

        enterPanel = new JPanel();
        enterPanel.setLayout(new BoxLayout(enterPanel, BoxLayout.Y_AXIS));
        enterPanel.add(clientPanel);
        enterPanel.add(carPanel);
        enterPanel.add(KODPanel);
        enterPanel.add(breackingPanel);

        add(enterPanel, BorderLayout.CENTER);
    }

    private void ButtonsInit() {
        addBut = new JButton("Добавить");
        addBut.setToolTipText("Добавить новую заявку");
        cancelBut = new JButton("Отмена");
        cancelBut.setToolTipText("Выход без сохранения изменений");

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        buttonPanel.add(addBut);
        buttonPanel.add(cancelBut);

        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void ListenersInit() {
        cancelBut.addActionListener(new ActionRecordCancelListener(RecordFrame.this));
    }
}
