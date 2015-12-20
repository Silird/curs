package MainFrame;

import Listeners.MainFrameListeners.ActionListeners.*;
import Listeners.MainFrameListeners.FocusListeners.*;
import Listeners.MainFrameListeners.MouseListeners.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * Конструктор формы
 */
public class MyFrame {
    //Форма
    protected JFrame carsList;
    //Таблица
    protected DefaultTableModel model;
    protected JScrollPane scroll;
    protected ClientTable cars;
    protected JTabbedPane tables;
    //Тулбар
    protected JButton createBut, openBut, saveBut, printBut, exitBut;
    protected JToolBar toolBar;
    //Фильтр
    /*
    protected MyComboBox client;
    protected JTextField dateTake;
    protected JButton filterBut;
    protected JPanel filterPanel, clientPanel, carPanel, datePanel, checkPanel;
    protected JCheckBox clientcheck, carcheck, datecheck, Checkcheck;
    protected JComboBox comboCheck;
    protected JLabel filterLabel;
    protected JPanel eastPanel;
    */
    //Диалоги сохранения-загрузки
    protected FileDialog save, load;
    //Интерфейс
    /*
    protected JTextField clientName, carName, date;
    protected JLabel addLabel;
    protected JCheckBox checkcar;
    protected JButton addBut, removeBut, editBut, checkEditBut, undoBut;
    protected JPanel southPanel, addLabelPanel, addPanel;
    */

    /**
     * Инициализация всех элементов и отображение формы на экране
     */
    public void show() {
        FrameInit();
        ToolBarInit(); //Наверх формы
        TableInit();  //Посередине формы
        //FilterInit();  //Справа формы
        SaveLoadDialogInit();
        //InterfaceInit();  //Вниз формы
        ListenersInit();

        carsList.setVisible(true);
    }

    /**
     * Инициализация главной формы
     */
    private void FrameInit() {
        carsList = new JFrame("Автомастерская");
        carsList.setSize(700, 300);
        carsList.setMinimumSize(new Dimension(700, 300));
        carsList.setLocationRelativeTo(null);
        carsList.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

        carsList.add(toolBar, BorderLayout.NORTH); //тулбар
    }

    /**
     * Инициализация таблицы
     */
    private void TableInit() {
        String columns[] = {"Клиент", "Марка машины", "Дата сдачи", "Готовность"};
        String data[][] = {{"Салимов Анушервон", "Bugatti Veyron", "20.08.2015", "Готово"},
                {"Быков Андрей", "Москвич 412", "25.08.2015", "Не готово"}};
        model = new DefaultTableModel(data, columns);
        cars = new ClientTable(model);

        scroll = new JScrollPane(cars);

        tables = new JTabbedPane();
        tables.addTab("Основная информация", scroll);

        carsList.add(tables, BorderLayout.CENTER); //Таблицы
    }

    /**
     * Инициализация поля фильтра
     */
    /*
    private void FilterInit() {
        client = new MyComboBox(model);
        clientcheck = new JCheckBox();
        clientPanel = new JPanel();
        clientPanel.setLayout(new BoxLayout(clientPanel, BoxLayout.X_AXIS));
        clientPanel.add(clientcheck);
        clientPanel.add(client);

        carName = new JTextField("Марка машины");
        carName.setColumns(12);
        carcheck = new JCheckBox();
        carPanel = new JPanel();
        carPanel.setLayout(new BoxLayout(carPanel, BoxLayout.X_AXIS));
        carPanel.add(carcheck);
        carPanel.add(carName);

        dateTake = new JTextField("Дата");
        dateTake.setColumns(12);
        datecheck = new JCheckBox();
        datePanel = new JPanel();
        datePanel.setLayout(new BoxLayout(datePanel, BoxLayout.X_AXIS));
        datePanel.add(datecheck);
        datePanel.add(dateTake);

        comboCheck = new JComboBox(new String[] {"Готовность", "Готово", "Не готово"});
        Checkcheck = new JCheckBox();
        checkPanel = new JPanel();
        checkPanel.setLayout(new BoxLayout(checkPanel, BoxLayout.X_AXIS));
        checkPanel.add(Checkcheck);
        checkPanel.add(comboCheck);

        filterLabel = new JLabel("Поиск");
        filterBut = new JButton(new ImageIcon(getClass().getResource("/pictures/filter.png")));
        filterPanel = new JPanel();
        filterPanel.setLayout(new BoxLayout(filterPanel, BoxLayout.Y_AXIS));
        filterPanel.add(filterLabel);
        filterPanel.add(clientPanel);
        filterPanel.add(carPanel);
        filterPanel.add(datePanel);
        filterPanel.add(checkPanel);
        filterPanel.add(new JLabel(" "));
        filterPanel.add(filterBut);
        eastPanel = new JPanel();
        eastPanel.add(filterPanel, BorderLayout.NORTH);

        carsList.add(eastPanel, BorderLayout.EAST); //Фильтр
    }
    */

    /**
     * Инициализация save- и load-диалогов
     */
    private void SaveLoadDialogInit() {
        save = new FileDialog(carsList, "Сохранение таблицы", FileDialog.SAVE);
        save.setFile("*.xml");
        save.setDirectory("D:\\Work\\Java\\Универ\\curs\\Сохранённые таблицы");

        load = new FileDialog(carsList, "Загрузка таблицы", FileDialog.LOAD);
        load.setFile("*.xml");
        load.setDirectory("D:\\Work\\Java\\Универ\\curs\\Сохранённые таблицы");
    }

    /**
     * Инициализация интерфейса
     */
    /*
    private void InterfaceInit() {
        addPanel = new JPanel();
        addPanel.setLayout(new BoxLayout(addPanel, BoxLayout.X_AXIS));
        addLabel = new JLabel("Работа с таблицей");

        addLabelPanel = new JPanel();
        addLabelPanel.add(addLabel);

        southPanel = new JPanel();
        southPanel.setLayout(new BoxLayout(southPanel, BoxLayout.Y_AXIS));
        southPanel.add(addLabelPanel);

        clientName = new JTextField("Клиент");

        carName = new JTextField("Марка машины");

        date = new JTextField("Дата");

        checkcar = new JCheckBox("Готовность");

        addBut = new JButton(new ImageIcon(getClass().getResource("/pictures/add.png")));
        addBut.setToolTipText("Добавить элемент в таблицу");

        removeBut = new JButton(new ImageIcon(getClass().getResource("/pictures/remove.png")));
        removeBut.setToolTipText("Удалить выбранные строки из таблицы");

        editBut = new JButton(new ImageIcon(getClass().getResource("/pictures/edit.png")));
        editBut.setToolTipText("Редактировать выбранную строку таблицы");

        checkEditBut = new JButton(new ImageIcon(getClass().getResource("/pictures/add.png")));
        checkEditBut.setToolTipText("Принять редактирование");
        checkEditBut.setVisible(false);

        undoBut = new JButton(new ImageIcon(getClass().getResource("/pictures/undo.png")));
        undoBut.setToolTipText("Отменить редактирование");
        undoBut.setVisible(false);

        addPanel.add(clientName);
        addPanel.add(carName);
        addPanel.add(date);
        addPanel.add(checkcar);
        addPanel.add(addBut);
        addPanel.add(checkEditBut);
        addPanel.add(editBut);
        addPanel.add(undoBut);
        addPanel.add(removeBut);

        southPanel.add(addPanel);

        carsList.add(southPanel, BorderLayout.SOUTH); //Интерфейс
    }
    */

    /**
     * Привязка слушателей к объектам
     */
    private void ListenersInit() {
        //ActionListeners
        //Фильтр
        //filterBut.addActionListener(new ActionFilterListener(carsList, carName, client));
        //Тулбар
        exitBut.addActionListener(new ActionExitListener());
        saveBut.addActionListener(new ActionSaveListener(carsList, save, model));
        openBut.addActionListener(new ActionLoadListener(carsList, load, model));
        createBut.addActionListener(new ActionCreateListener(model));
        //Интерфейс
        /*
        addBut.addActionListener(new ActionAddListener(carsList, model, clientName, carName, date, checkcar));
        removeBut.addActionListener(new ActionRemoveListener(carsList, model, cars));
        editBut.addActionListener(new ActionEditListener(carsList, model, cars, addBut, checkEditBut,
                editBut, undoBut, removeBut, clientName, carName, date, checkcar));
        undoBut.addActionListener(new ActionUndoListener(carsList, model, cars, addBut, checkEditBut,
                editBut, undoBut, removeBut, clientName, carName, date, checkcar));
        checkEditBut.addActionListener(new ActionAcceptListener(carsList, model, cars, addBut, checkEditBut,
                editBut, undoBut, removeBut, clientName, carName, date, checkcar));
        */

        //FocusListeners
        //Интерфейс
        /*
        clientName.addFocusListener(new FocusAddclientNameListener(clientName));
        carName.addFocusListener(new FocusAddcarNameListener(carName));
        date.addFocusListener(new FocusAddDateListener(date));
        carName.addFocusListener(new FocusBNameListener(carName));
        */
        //Фильтр
        //dateTake.addFocusListener(new FocusAddDateListener(dateTake));

        //MouseListeners
        //Интерфейс
        /*
        removeBut.addMouseListener(new MouseRemoveListener(removeBut));
        addBut.addMouseListener(new MouseAddListener(addBut));
        editBut.addMouseListener(new MouseEditListener(editBut));
        checkEditBut.addMouseListener(new MouseAddListener(checkEditBut));
        undoBut.addMouseListener(new MouseUndoListener(undoBut));
        */
        //Тулбар
        saveBut.addMouseListener(new MouseSaveListener(saveBut));                           // (\(\
        openBut.addMouseListener(new MouseOpenListener(openBut));                           // (>'•')
        printBut.addMouseListener(new MousePrintListener(printBut));                        // (~(")(")
        exitBut.addMouseListener(new MouseExitListener(exitBut));
        createBut.addMouseListener(new MouseCreateListener(createBut));
        //Фильтр
        //filterBut.addMouseListener(new MouseFilterListener(filterBut));
    }
}