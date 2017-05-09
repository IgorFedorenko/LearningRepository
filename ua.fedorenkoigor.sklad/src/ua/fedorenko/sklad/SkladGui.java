package ua.fedorenko.sklad;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JSplitPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.FlowLayout;
import java.awt.GridLayout;



public class SkladGui  {
	private static final ButtonGroup buttonGroup = new ButtonGroup();
	private static JTextField textField;
	private static JTextField textField_1;
	private static JTextField itemName;
	private static JTextField textFieldNewWarehouse;
	private static JTextField textFieldEnterNewWarehouse;
	private static JTextField labelNewSupplierName;
	private static JTextField newSupplierNameField;
	private static JTextField labelNewSupplierAddress;
	private static JTextField newSupplierAddressField;
	private static JTextField textField_2;
	private static JTextField textField_3;
	private static JTextField textField_4;
	private static JTextField textField_5;
	private static JTextField textField_6;
	
	public static void main(String[] args) {
		OperationsHandler operationHandler = new OperationsHandler();
		operationHandler.addWarehouse("3-я улица строителей, дом 8");
		Warehouse warehouseOne=operationHandler.getWarehouse("3-я улица строителей, дом 8");
		warehouseOne.addGoods("Картошка",500,"кг");
		operationHandler.updateWarehouse(warehouseOne);
		JFrame frame = new JFrame("Склады и поставщики");
		frame.setSize(800, 680);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Накладная", null, panel, null);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.NORTH);
		
		JSplitPane splitPane = new JSplitPane();
		
		JPanel panel_5 = new JPanel();
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addComponent(splitPane, GroupLayout.PREFERRED_SIZE, 429, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_5, GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addComponent(splitPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addComponent(panel_5, GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
		);
		
		JSplitPane splitPane_1 = new JSplitPane();
		splitPane_1.setOrientation(JSplitPane.VERTICAL_SPLIT);
		panel_5.add(splitPane_1);
		
		JRadioButton radioButton = new JRadioButton("Поставщик-Склад");
		buttonGroup.add(radioButton);
		radioButton.setVerticalAlignment(SwingConstants.TOP);
		splitPane_1.setLeftComponent(radioButton);
		
		JRadioButton radioButton_1 = new JRadioButton("Склад-Склад");
		buttonGroup.add(radioButton_1);
		radioButton_1.setVerticalAlignment(SwingConstants.TOP);
		splitPane_1.setRightComponent(radioButton_1);
		
		JPanel panel_3 = new JPanel();
		splitPane.setLeftComponent(panel_3);
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.Y_AXIS));
		
		JLabel senderLabel = new JLabel("Отправитель");
		panel_3.add(senderLabel);
		
		Component verticalGlue = Box.createVerticalGlue();
		panel_3.add(verticalGlue);
		
		JLabel receiverLabel = new JLabel("Получатель");
		panel_3.add(receiverLabel);
		
		Component verticalGlue_1 = Box.createVerticalGlue();
		panel_3.add(verticalGlue_1);
		
		JLabel basisLabel = new JLabel("Основание");
		panel_3.add(basisLabel);
		
		Component verticalGlue_2 = Box.createVerticalGlue();
		panel_3.add(verticalGlue_2);
		
		JLabel AttorneyLabel = new JLabel("Доверенность");
		panel_3.add(AttorneyLabel);
		
		JPanel panel_4 = new JPanel();
		splitPane.setRightComponent(panel_4);
		panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.Y_AXIS));
		
		JComboBox comboBox = new JComboBox();
		panel_4.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		panel_4.add(comboBox_1);
		
		textField = new JTextField();
		panel_4.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		panel_4.add(textField_1);
		textField_1.setColumns(10);
		panel_2.setLayout(gl_panel_2);
		
		JPanel panel_6 = new JPanel();
		panel.add(panel_6, BorderLayout.EAST);
		panel_6.setLayout(new BoxLayout(panel_6, BoxLayout.Y_AXIS));
		
		JLabel label_2 = new JLabel("Подбор товара");
		panel_6.add(label_2);
		
		Component verticalGlue_3 = Box.createVerticalGlue();
		panel_6.add(verticalGlue_3);
		
		itemName = new JTextField();
		itemName.setText("Item");
		panel_6.add(itemName);
		itemName.setColumns(10);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		panel_6.add(verticalStrut);
		
		JButton button = new JButton("Поиск");
		panel_6.add(button);
		
		Component verticalGlue_4 = Box.createVerticalGlue();
		panel_6.add(verticalGlue_4);
		
		JList list = new JList();
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"1", "2", "3", "4", "5"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		panel_6.add(list);
		
		JPanel panel_7 = new JPanel();
		panel.add(panel_7, BorderLayout.CENTER);
		panel_7.setLayout(new BoxLayout(panel_7, BoxLayout.Y_AXIS));
		
		JPanel panel_9 = new JPanel();
		panel_7.add(panel_9);
		panel_9.setLayout(new BoxLayout(panel_9, BoxLayout.X_AXIS));
		
		Component horizontalGlue_5 = Box.createHorizontalGlue();
		panel_9.add(horizontalGlue_5);
		
		JLabel label_3 = new JLabel("Наименование");
		panel_9.add(label_3);
		
		Component horizontalGlue = Box.createHorizontalGlue();
		panel_9.add(horizontalGlue);
		
		JLabel lblNewLabel_2 = new JLabel("ед. изм.");
		panel_9.add(lblNewLabel_2);
		
		Component horizontalGlue_1 = Box.createHorizontalGlue();
		panel_9.add(horizontalGlue_1);
		
		JLabel label_4 = new JLabel("Кол-во");
		panel_9.add(label_4);
		
		Component horizontalGlue_4 = Box.createHorizontalGlue();
		panel_9.add(horizontalGlue_4);
		
		JLabel label_5 = new JLabel("Цена");
		panel_9.add(label_5);
		
		Component horizontalGlue_3 = Box.createHorizontalGlue();
		panel_9.add(horizontalGlue_3);
		
		JLabel lblNewLabel_3 = new JLabel("Сумма");
		panel_9.add(lblNewLabel_3);
		
		Component horizontalGlue_2 = Box.createHorizontalGlue();
		panel_9.add(horizontalGlue_2);
		
		JPanel goodsPanel = new JPanel();
		panel_7.add(goodsPanel);
		goodsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panel_11 = new JPanel();
		goodsPanel.add(panel_11);
		panel_11.setLayout(new BoxLayout(panel_11, BoxLayout.X_AXIS));
		
		textField_2 = new JTextField();
		textField_2.setColumns(25);
		panel_11.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		panel_11.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(15);
		panel_11.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(15);
		panel_11.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(15);
		panel_11.add(textField_6);
		
		JPanel panel_8 = new JPanel();
		panel_7.add(panel_8);
		
		Component verticalGlue_5 = Box.createVerticalGlue();
		panel_8.add(verticalGlue_5);
		
		JPanel panelOfAddingBtns = new JPanel();
		panel_7.add(panelOfAddingBtns);
		
		JButton addItemBtn = new JButton("Добавить товар");
		addItemBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				goodsPanel.add(panel_11);

			}
		});
		panelOfAddingBtns.add(addItemBtn);
		
		JButton sendNewOrderBtn = new JButton("Отправить накладную");
		panelOfAddingBtns.add(sendNewOrderBtn);
		
		JPanel panelWarehouses = new JPanel();
		tabbedPane.addTab("Склады", null, panelWarehouses, null);
		panelWarehouses.setLayout(new BoxLayout(panelWarehouses, BoxLayout.Y_AXIS));
		
		JPanel panelOfWarehouseAdding = new JPanel();
		panelWarehouses.add(panelOfWarehouseAdding);
		
		textFieldNewWarehouse = new JTextField();
		textFieldNewWarehouse.setText("Введите адрес нового склада");
		textFieldNewWarehouse.setEnabled(false);
		textFieldNewWarehouse.setEditable(false);
		panelOfWarehouseAdding.add(textFieldNewWarehouse);
		textFieldNewWarehouse.setColumns(20);
		
		textFieldEnterNewWarehouse = new JTextField();
		panelOfWarehouseAdding.add(textFieldEnterNewWarehouse);
		textFieldEnterNewWarehouse.setColumns(30);
		
		JButton addNewWarehouseBtn = new JButton("Добавить склад");
		addNewWarehouseBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String addressOfNewWarehouse = textFieldEnterNewWarehouse.getText();
				operationHandler.addWarehouse(addressOfNewWarehouse);
			}
		});
		panelOfWarehouseAdding.add(addNewWarehouseBtn);
		
		JTextArea textAreaOfWarehouses = new JTextArea();
		textAreaOfWarehouses.setEditable(false);
		panelWarehouses.add(textAreaOfWarehouses);
		
		JPanel panelSupplier = new JPanel();
		tabbedPane.addTab("Поставщики", null, panelSupplier, null);
		panelSupplier.setLayout(new BorderLayout(0, 0));
		
		JPanel panelAddingNewSupplier = new JPanel();
		panelSupplier.add(panelAddingNewSupplier, BorderLayout.NORTH);
		panelAddingNewSupplier.setLayout(new BoxLayout(panelAddingNewSupplier, BoxLayout.Y_AXIS));
		
		JSplitPane splitPaneNameSupplier = new JSplitPane();
		panelAddingNewSupplier.add(splitPaneNameSupplier);
		
		labelNewSupplierName = new JTextField();
		labelNewSupplierName.setText("Введите наименование нового поставщика");
		labelNewSupplierName.setEnabled(false);
		labelNewSupplierName.setEditable(false);
		labelNewSupplierName.setColumns(30);
		splitPaneNameSupplier.setLeftComponent(labelNewSupplierName);
		
		newSupplierNameField = new JTextField();
		newSupplierNameField.setColumns(30);
		splitPaneNameSupplier.setRightComponent(newSupplierNameField);
		
		JSplitPane splitPaneAddressSupplier = new JSplitPane();
		panelAddingNewSupplier.add(splitPaneAddressSupplier);
		
		labelNewSupplierAddress = new JTextField();
		labelNewSupplierAddress.setText("Введите адрес нового поставщика");
		labelNewSupplierAddress.setEnabled(false);
		labelNewSupplierAddress.setEditable(false);
		labelNewSupplierAddress.setColumns(30);
		splitPaneAddressSupplier.setLeftComponent(labelNewSupplierAddress);
		
		newSupplierAddressField = new JTextField();
		newSupplierAddressField.setColumns(30);
		splitPaneAddressSupplier.setRightComponent(newSupplierAddressField);
		
		JButton AddNewSupplierBtn = new JButton("Добавить поставщика");
		panelAddingNewSupplier.add(AddNewSupplierBtn);
		
		JPanel panelListOfSuppliers = new JPanel();
		panelSupplier.add(panelListOfSuppliers, BorderLayout.CENTER);
		panelListOfSuppliers.setLayout(new BoxLayout(panelListOfSuppliers, BoxLayout.X_AXIS));
		
		JList listOfSuppliers = new JList();
		listOfSuppliers.setEnabled(false);
		panelListOfSuppliers.add(listOfSuppliers);
		
		JPanel panelFooterOfSuppliers = new JPanel();
		panelSupplier.add(panelFooterOfSuppliers, BorderLayout.SOUTH);
		
		frame.setVisible(true);
	}
}
