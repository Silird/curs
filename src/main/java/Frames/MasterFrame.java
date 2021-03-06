package Frames;


import Listeners.MasterFrameListeners.ActionMasterAddListener;
import Listeners.MasterFrameListeners.ActionMasterCancelListener;
import Listeners.MasterFrameListeners.ActionKOD2Listener;
import Listeners.MasterFrameListeners.ActionKOD3Listener;
import util.WorkMasters;

import javax.swing.*;
import java.awt.*;

/**
 * Модальное окно
 */
public class MasterFrame extends JDialog {
    //База мастеров
    private WorkMasters mastersList;
    //Интерфейс
    private JPanel buttonPanel;
    private JButton addBut, cancelBut;
    //Панельки ввода
    private JPanel enterPanel, namePanel, nameLeftPanel, KODPanel, empMaxPanel, empMaxLeftPanel;
    private JLabel nameLabel, empMaxLabel;
    private JTextField nameField, empMaxField;
    private JComboBox KOD1Box, KOD2Box, KOD3Box;

    public MasterFrame(WorkMasters ml, JFrame owner) {
        super(owner);
        mastersList = ml;
        Show(owner);
    }

    /**
     * Отображение формы
     * @param owner
     */
    public void Show(JFrame owner) {
        FrameInit(owner);
        EnterPanelInit(); //Посередине
        ButtonsInit(); //Внизу
        ListenersInit();
        setVisible(true);
    }

    /**
     * Инициализация формы
     * @param owner
     */
    private void FrameInit(JFrame owner) {
        setTitle("Добавление мастера");
        setSize(500, 250);
        setResizable(false);
        setLocationRelativeTo(owner);
        setModalityType(ModalityType.TOOLKIT_MODAL);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
    }

    /**
     * Инициализация панелек ввода данных
     */
    private void EnterPanelInit() {
        nameLabel = new JLabel("Имя мастера");
        nameField = new JTextField(20);
        nameLeftPanel = new JPanel();
        nameLeftPanel.add(nameLabel);
        nameLeftPanel.add(nameField);
        namePanel = new JPanel();
        namePanel.add(nameLeftPanel, BorderLayout.WEST);

        KOD1Box = new JComboBox(new String[] {"Основная специализация", "Покраска", "Кузовной ремонт", "Ремонт подвески",
                "Ремонт двигателя", "Развал-схождение", "Прочее"});
        KOD2Box = new JComboBox(new String[] {"Доп. Специализация №1", "Покраска", "Кузовной ремонт", "Ремонт подвески",
                "Ремонт двигателя", "Развал-схождение", "Прочее"});
        KOD3Box = new JComboBox(new String[] {"Доп. специализация №2", "Покраска", "Кузовной ремонт", "Ремонт подвески",
                "Ремонт двигателя", "Развал-схождение", "Прочее"});
        KODPanel = new JPanel();
        KODPanel.add(KOD1Box);
        KODPanel.add(KOD2Box);
        KODPanel.add(KOD3Box);

        empMaxLabel = new JLabel("Максимальная загруженность");
        empMaxField = new JTextField(20);
        empMaxLeftPanel = new JPanel();
        empMaxLeftPanel.add(empMaxLabel);
        empMaxLeftPanel.add(empMaxField);
        empMaxPanel = new JPanel();
        empMaxPanel.add(empMaxLeftPanel, BorderLayout.WEST);

        enterPanel = new JPanel();
        enterPanel.setLayout(new BoxLayout(enterPanel, BoxLayout.Y_AXIS));
        enterPanel.add(namePanel);
        enterPanel.add(KODPanel);
        enterPanel.add(empMaxPanel);

        add(enterPanel, BorderLayout.CENTER);
    }

    /**
     * Инициализация Кнопок
     */
    private void ButtonsInit() {
        addBut = new JButton("Добавить");
        addBut.setToolTipText("Добавить нового мастера");
        cancelBut = new JButton("Отмена");
        cancelBut.setToolTipText("Выход без сохранения изменений");

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        buttonPanel.add(addBut);
        buttonPanel.add(cancelBut);

        add(buttonPanel, BorderLayout.SOUTH);
    }

    /**
     * Инициализация слушателей
     */
    private void ListenersInit() {
        addBut.addActionListener(new ActionMasterAddListener(MasterFrame.this, nameField, empMaxField,
                KOD1Box, KOD2Box, KOD3Box, mastersList));
        cancelBut.addActionListener(new ActionMasterCancelListener(MasterFrame.this));
        KOD2Box.addActionListener(new ActionKOD2Listener(MasterFrame.this, KOD1Box, KOD2Box));
        KOD3Box.addActionListener(new ActionKOD3Listener(MasterFrame.this, KOD1Box, KOD2Box, KOD3Box));
    }
}
