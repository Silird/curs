package Frames.MainFrame;

import Frames.MyTable;
import Listeners.MainFrameListeners.ActionListeners.*;
import Listeners.MainFrameListeners.MouseListeners.*;
import SaveLoad.Load;
import util.WorkMasters;
import util.WorkRecords;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * Конструктор формы
 */
public class MainFrame extends JFrame {
    //Таблица
    protected DefaultTableModel clientModel, masterModel, adminModel;
    protected JScrollPane clientScroll, masterScroll, adminScroll;
    protected MyTable clientTable, masterTable, adminTable;
    protected JTabbedPane tables;
    //Тулбар
    protected JButton createBut, openBut, saveBut, printBut, exitBut;
    protected JToolBar toolBar;
    //Диалоги сохранения-загрузки
    protected FileDialog save, load;
    //Интерфейс
    private JButton addMasterBut, removeMasterBut;
    private JPanel interfacePanel;

    //База
    private WorkMasters wm;
    private WorkRecords wr;

    /**
     * Инициализация всех элементов и отображение формы на экране
     */
    public void Show() {
        FrameInit();
        ToolBarInit(); //Наверх формы
        TableInit();  //Посередине формы
        SaveLoadDialogInit();
        InterfaceInit();  //Вниз формы
        BaseInit();
        ListenersInit();

        setVisible(true);
    }

    /**
     * Инициализация главной формы
     */
    private void FrameInit() {
        setTitle("Автомастерская");
        setSize(700, 300);
        setMinimumSize(new Dimension(700, 300));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Инициализация тулбара
     */
    private void ToolBarInit() {
        createBut = new JButton(new ImageIcon(getClass().getResource("/pictures/create.png")));
        createBut.setToolTipText("Создать новый список клиентов");

        openBut = new JButton(new ImageIcon(getClass().getResource("/pictures/open.png")));
        openBut.setToolTipText("Открыть список клиентов");

        saveBut = new JButton(new ImageIcon(getClass().getResource("/pictures/save.png")));
        saveBut.setToolTipText("Сохранить список клиентов");

        printBut = new JButton(new ImageIcon(getClass().getResource("/pictures/print.png")));
        printBut.setToolTipText("Распечатать список клиентов");

        exitBut = new JButton(new ImageIcon(getClass().getResource("/pictures/exit.png")));
        exitBut.setToolTipText("Выход");

        toolBar = new JToolBar("Панель инструментов");
        toolBar.add(createBut);
        toolBar.add(openBut);
        toolBar.add(saveBut);
        toolBar.add(printBut);
        toolBar.add(exitBut);

        add(toolBar, BorderLayout.NORTH); //тулбар
    }

    /**
     * Инициализация таблицы
     */
    private void TableInit() {
        String columns[] = {"Клиент", "Марка машины", "Вид работы", "Готовность"};
        clientModel = new DefaultTableModel(null, columns);
        clientTable = new MyTable(clientModel);
        clientScroll = new JScrollPane(clientTable);

        String columns1[] = {"Клиент", "Мастер", "Вид работы", "Описание неисправности"};
        adminModel = new DefaultTableModel(null, columns);
        adminTable = new MyTable(adminModel);
        adminScroll = new JScrollPane(adminTable);

        String columns2[] = {"Имя мастера", "Специализация", "Доп. специализация №1",
                "Доп. специализация №1", "Загруженность", "Max загруженность"};
        masterModel = new DefaultTableModel(null, columns2);
        masterTable = new MyTable(masterModel);
        masterScroll = new JScrollPane(masterTable);

        tables = new JTabbedPane();
        tables.addTab("Основная информация", clientScroll);
        tables.addTab("Дополнительная информация", adminScroll);
        tables.addTab("Мастера", masterScroll);

        add(tables, BorderLayout.CENTER); //Таблицы
    }

    /**
     * Инициализация save- и load-диалогов
     */
    private void SaveLoadDialogInit() {
        save = new FileDialog(MainFrame.this, "Сохранение таблицы", FileDialog.SAVE);
        save.setFile("*.xml");
        save.setDirectory("D:\\Work\\Java\\Универ\\curs\\Сохранённые таблицы");

        load = new FileDialog(MainFrame.this, "Загрузка таблицы", FileDialog.LOAD);
        load.setFile("*.xml");
        load.setDirectory("D:\\Work\\Java\\Универ\\curs\\Сохранённые таблицы");
    }

    /**
     * Инициализация интерфейса
     */
    private void InterfaceInit() {
        interfacePanel = new JPanel();
        interfacePanel.setLayout(new BoxLayout(interfacePanel, BoxLayout.X_AXIS));

        addMasterBut = new JButton("Добавить мастера");

        removeMasterBut = new JButton("Удалить мастера");

        interfacePanel.add(addMasterBut);
        interfacePanel.add(removeMasterBut);

        add(interfacePanel, BorderLayout.SOUTH);
    }

    private void BaseInit() {
        Load loadb = new Load();
        wm = new WorkMasters(masterModel);
        wr = new WorkRecords(clientModel, adminModel);
        loadb.LoadXML("D:\\Work\\Java\\Универ\\curs\\Сохранённые таблицы\\saved.xml", wm);
    }


    /**
     * Привязка слушателей к объектам
     */
    private void ListenersInit() {
        //ActionListeners
        //Тулбар
        exitBut.addActionListener(new ActionExitListener(wm));
        saveBut.addActionListener(new ActionSaveListener(MainFrame.this, save, clientModel));
        openBut.addActionListener(new ActionLoadListener(MainFrame.this, load, clientModel));
        createBut.addActionListener(new ActionCreateListener(wm, wr));
        //Интерфейс
        addMasterBut.addActionListener(new ActionAddMasterListener(MainFrame.this, wm));
        removeMasterBut.addActionListener(new ActionRemoveMasterListener(MainFrame.this, tables, masterTable, wm));

        //MouseListeners
        //Тулбар
        saveBut.addMouseListener(new MouseSaveListener(saveBut));                           // (\(\
        openBut.addMouseListener(new MouseOpenListener(openBut));                           // (>'•')
        printBut.addMouseListener(new MousePrintListener(printBut));                        // (~(")(")
        exitBut.addMouseListener(new MouseExitListener(exitBut));
        createBut.addMouseListener(new MouseCreateListener(createBut));
    }
}
