package phonebook;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import javax.swing.JTabbedPane;
import javax.swing.BoxLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSplitPane;

import javax.swing.JButton;

import javax.swing.JFormattedTextField;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

public class PhoneBook extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField newPersonName;

	private JTextField forSearchName;
	private JFormattedTextField textField_1;
	private JTextField newPersonDescription;

	private ArrayList<PhonePane> phonePanes = new ArrayList<PhonePane>();
	private PhoneBookDirector phoneDir = new PhoneBookDirector();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PhoneBook frame = new PhoneBook();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	/**
	 * Create the frame.
	 * 
	 * @param string
	 */
	public PhoneBook() {
		super("Phone Book");

		setBounds(100, 100, 609, 352);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				phoneDir.exit(phoneDir);

				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab(
				"\u0414\u043E\u0431\u0430\u0432\u043B\u0435\u043D\u0438\u0435 \u043A\u043E\u043D\u0442\u0430\u043A\u0442\u0430",
				null, panel_1, null);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));

		JSplitPane splitPane = new JSplitPane();
		panel_1.add(splitPane);

		JLabel label = new JLabel(
				"\u0412\u0432\u0435\u0434\u0438 \u0438\u043C\u044F \u043A\u043E\u043D\u0442\u0430\u043A\u0442\u0430");
		splitPane.setLeftComponent(label);

		newPersonName = new JTextField();
		splitPane.setRightComponent(newPersonName);
		newPersonName.setColumns(10);

		JSplitPane splitPane_14 = new JSplitPane();
		panel_1.add(splitPane_14);

		JLabel label_4 = new JLabel(
				"\u0412\u0432\u0435\u0434\u0438\u0442\u0435 \u043E\u043F\u0438\u0441\u0430\u043D\u0438\u0435 ");
		splitPane_14.setLeftComponent(label_4);

		newPersonDescription = new JTextField();
		splitPane_14.setRightComponent(newPersonDescription);
		newPersonDescription.setColumns(10);

		JPanel panel_3 = new JPanel();
		JSplitPane splitPane_9 = new JSplitPane();
		panel_1.add(splitPane_9);

		JButton button = new JButton(
				"\u0417\u0430\u043F\u0438\u0441\u0430\u0442\u044C \u043A\u043E\u043D\u0442\u0430\u043A\u0442");
		splitPane_9.setRightComponent(button);
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (!newPersonName.getText().equals("")) {
					Person person = new Person(newPersonName.getText(), newPersonDescription.getText());

					for (PhonePane phonePane : phonePanes) {
						Phone phone = new Phone(phonePane.newNumber.getText(), phonePane.phoneType);
						person.addPhone(phone);
					}

					phoneDir.addNewPerson(person);
					System.out.println(person);
					panel_3.removeAll();
					phonePanes.clear();
					newPersonName.setText("");
					newPersonDescription.setText("");
					repaint();
				}

			}
		});

		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.Y_AXIS));
		JButton button_1 = new JButton("\u0415\u0449\u0435 \u043D\u043E\u043C\u0435\u0440");
		splitPane_9.setLeftComponent(button_1);
		button_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				PhonePane pane = new PhonePane();
				phonePanes.add(pane);
				panel_3.add(pane);
				revalidate();

			}
		});

		JSplitPane splitPane_1 = new JSplitPane();
		panel_1.add(splitPane_1);

		JLabel label_1 = new JLabel("\u0442\u0438\u043F \u043D\u043E\u043C\u0435\u0440\u0430");
		splitPane_1.setLeftComponent(label_1);

		JLabel lblNewLabel = new JLabel("\u043D\u043E\u043C\u0435\u0440");
		splitPane_1.setRightComponent(lblNewLabel);

		panel_1.add(panel_3);
		Component verticalStrut = Box.createVerticalStrut(500);
		panel_1.add(verticalStrut);

		JPanel panel = new JPanel();
		tabbedPane.addTab("\u043F\u043E\u0438\u0441\u043A \u043A\u043E\u043D\u0442\u0430\u043A\u0442\u0430", null,
				panel, null);
		panel.setLayout(new BorderLayout(0, 0));

		JPanel panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.NORTH);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.Y_AXIS));

		JSplitPane splitPane_11 = new JSplitPane();
		panel_2.add(splitPane_11);

		JLabel label_2 = new JLabel(
				"\u0412\u0432\u0435\u0434\u0438 \u0438\u043C\u044F \u0434\u043B\u044F \u043F\u043E\u0438\u0441\u043A\u0430");
		splitPane_11.setLeftComponent(label_2);

		JSplitPane splitPane_13 = new JSplitPane();
		splitPane_11.setRightComponent(splitPane_13);

		forSearchName = new JTextField();
		forSearchName.setHorizontalAlignment(SwingConstants.CENTER);
		splitPane_13.setLeftComponent(forSearchName);
		forSearchName.setColumns(20);
		JPanel panel_4 = new JPanel();
		JButton searchByName = new JButton("\u043D\u0430\u0439\u0442\u0438");
		splitPane_13.setRightComponent(searchByName);
		searchByName.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				panel_4.removeAll();

				ArrayList<Person> searchPersons = phoneDir.getPersonByName(forSearchName.getText());

				for (Person person : searchPersons) {
					ContactPane contact = new ContactPane(person);
					panel_4.add(contact);

				}
				Component verticalStrut_1 = Box.createVerticalStrut(200);
				panel_4.add(verticalStrut_1);
				repaint();
			}
		});

		JSplitPane splitPane_12 = new JSplitPane();
		panel_2.add(splitPane_12);

		JLabel label_3 = new JLabel(
				"\u0412\u0432\u0435\u0434\u0438 \u043D\u043E\u043C\u0435\u0440 \u0434\u043B\u044F \u043F\u043E\u0438\u0441\u043A\u0430 ");
		splitPane_12.setLeftComponent(label_3);

		JSplitPane forSearchNumber = new JSplitPane();
		splitPane_12.setRightComponent(forSearchNumber);
		MaskFormatter formatter = null;
		try {
			formatter = new MaskFormatter("+38-(###)-###-##-##");
			formatter.setValidCharacters("0123456789");
		} catch (java.text.ParseException exc) {
			System.err.println("formatter is bad: " + exc.getMessage());
		}

		textField_1 = new JFormattedTextField(formatter);
		textField_1.setFocusLostBehavior(JFormattedTextField.COMMIT);
		forSearchNumber.setLeftComponent(textField_1);
		textField_1.setColumns(20);

		JButton searchByNumber = new JButton("\u041D\u0430\u0439\u0442\u0438");
		forSearchNumber.setRightComponent(searchByNumber);
		searchByNumber.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panel_4.removeAll();

				ArrayList<Person> searchPersons = phoneDir.getPersonByNumber(textField_1.getText());

				for (Person person : searchPersons) {
					ContactPane contact = new ContactPane(person);
					panel_4.add(contact);

				}
				Component verticalStrut_1 = Box.createVerticalStrut(200);
				panel_4.add(verticalStrut_1);
				repaint();

			}
		});

		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);

		scrollPane.setViewportView(panel_4);
		panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.Y_AXIS));

	}

}
