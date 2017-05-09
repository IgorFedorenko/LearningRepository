package ua.fedorenko.playerstatistics;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.DropMode;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import javax.swing.JFormattedTextField;
import java.awt.Component;
import javax.swing.JToolBar;
import javax.swing.RepaintManager;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Box;
import javax.swing.JSeparator;
import javax.swing.JEditorPane;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JSplitPane;

public class Start {
	private static JTextField registrResult;
	private static JTextField addRatingResult;
	private static JTextArea statisticResulttextField;
	private static JTextField textField;
	private static JTextField newGameTextField;
	private static ArrayList<String> newGamerGames = new ArrayList<String>();
	private static String newGamerNik = "";
	private static String gamerForAddRating = "";
	private static String gameForAddRating = "";

	private static String gamerForOneRating = "";
	private static String gameForOneRating = "";
	private static String gameForTop10 = "";
	private static String newGameName = "";

	public static void main(String[] args) {
		GameDirector gameDir = new GameDirector();
		JFrame frame = new JFrame("Регистрация и статистика игроков");
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		frame.setSize(800, 680);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JComboBox selectGameTop10ComboBox = new JComboBox();
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		frame.getContentPane().add(tabbedPane, BorderLayout.NORTH);
		JPanel registration = new JPanel();
		JButton oneGamerOnOneGameRatingbutton = new JButton("\u043F\u043E\u043A\u0430\u0437\u0430\u0442\u044C");

		tabbedPane.addTab(
				"\u0420\u0435\u0433\u0438\u0441\u0442\u0440\u0430\u0446\u0438\u044F \u0438\u0433\u0440\u043E\u043A\u043E\u0432",
				null, registration, null);
		tabbedPane.setEnabledAt(0, true);
		JButton addRatingButton = new JButton("\u0434\u043E\u0431\u0430\u0432\u0438\u0442\u044C");
		addRatingButton.setEnabled(false);
		
		JComboBox gameComboBox = new JComboBox();

		gameComboBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox box = (JComboBox) e.getSource();
				gameForAddRating = (String) box.getSelectedItem();
				addRatingButton.setEnabled(true);
			}

		});

		JComboBox gamersComboBox = new JComboBox();
		gamersComboBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox box = (JComboBox) e.getSource();
				gamerForAddRating = (String) box.getSelectedItem();
				gameComboBox.setModel(new DefaultComboBoxModel(gameDir.getGamerGames(gamerForAddRating)));
				gameForAddRating = "";
				addRatingButton.setEnabled(false);
			}

		});

		JComboBox selectGameForOneRatingComboBox = new JComboBox();
		selectGameForOneRatingComboBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox box = (JComboBox) e.getSource();
				gameForOneRating = (String) box.getSelectedItem();
				oneGamerOnOneGameRatingbutton.setEnabled(true);

			}

		});
		
		

		JComboBox selectGamerForOneRatingComboBox = new JComboBox();
		selectGamerForOneRatingComboBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox box = (JComboBox) e.getSource();
				gamerForOneRating = (String) box.getSelectedItem();
				selectGameForOneRatingComboBox
						.setModel(new DefaultComboBoxModel(gameDir.getGamerGames(gamerForOneRating)));
				oneGamerOnOneGameRatingbutton.setEnabled(false);
			}

		});

		JLabel label = new JLabel(
				"\u0414\u043B\u044F \u0440\u0435\u0433\u0438\u0441\u0442\u0440\u0430\u0446\u0438\u0438 \u043D\u043E\u0432\u043E\u0433\u043E \u0438\u0433\u0440\u043E\u043A\u0430 \u0432\u0432\u0435\u0434\u0438\u0442\u0435 \"\u043D\u0438\u043A\":");
		label.setHorizontalAlignment(SwingConstants.LEFT);

		JFormattedTextField nicInput = new JFormattedTextField();
		nicInput.setHorizontalAlignment(SwingConstants.LEFT);
		nicInput.setColumns(2);

		JLabel label_8 = new JLabel(
				"\u0432\u044B\u0431\u0435\u0440\u0438 \u0438\u0433\u0440\u044B \u0432 \u043A\u043E\u0442\u043E\u0440\u044B\u0435 \u0438\u0433\u0440\u0430\u0435\u0442 \u0438\u0433\u0440\u043E\u043A (\u0443\u0434\u0435\u0440\u0436\u0438\u0432\u0430\u044F CTRL):");

		JButton buttonRegistrate = new JButton(
				"\u0437\u0430\u0440\u0435\u0433\u0438\u0441\u0442\u0440\u0438\u0440\u043E\u0432\u0430\u0442\u044C");

		registrResult = new JTextField();
		registrResult.setEditable(false);
		registrResult.setColumns(10);

		buttonRegistrate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent paramActionEvent) {
				try {
					newGamerNik = nicInput.getText();

					String result = gameDir.addNewGamer(newGamerNik, newGamerGames);
					registrResult.setText(result);
					gamersComboBox.setModel(new DefaultComboBoxModel(gameDir.getAllGamers()));
					selectGamerForOneRatingComboBox.setModel(new DefaultComboBoxModel(gameDir.getAllGamers()));

				} catch (NullPointerException e) {
					registrResult.setText("Введите ник!");
				}

			}
		});

		registration.setLayout(new BoxLayout(registration, BoxLayout.Y_AXIS));
		registration.add(label);
		registration.add(nicInput);
		registration.add(label_8);

		JScrollPane scrollPane_1 = new JScrollPane();
		registration.add(scrollPane_1);

		JList<String> gameList = new JList<String>();
		scrollPane_1.setViewportView(gameList);
		gameList.setVisibleRowCount(4);
		gameList.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent event) {
				List<String> element = gameList.getSelectedValuesList();
				newGamerGames = (ArrayList<String>) element;

			}
		});
		gameList.setModel(new AbstractListModel() {

			private static final long serialVersionUID = 1L;
			String[] values = gameDir.getAllGames();

			public int getSize() {
				return values.length;
			}

			public Object getElementAt(int index) {
				return values[index];
			}
		});
		registration.add(buttonRegistrate);
		registration.add(registrResult);

		JPanel gameAdd = new JPanel();
		tabbedPane.addTab("\u0414\u043E\u0431\u0430\u0432\u043B\u0435\u043D\u0438\u0435 \u0438\u0433\u0440", null,
				gameAdd, null);
		tabbedPane.setEnabledAt(1, true);
		gameAdd.setLayout(new BoxLayout(gameAdd, BoxLayout.Y_AXIS));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		gameAdd.add(scrollPane);

		JList AllGamelist = new JList();
		AllGamelist.setEnabled(false);
		AllGamelist.setModel(new AbstractListModel() {
			String[] values = gameDir.getAllGames();

			public int getSize() {
				return values.length;
			}

			public Object getElementAt(int index) {
				return values[index];
			}
		});
		scrollPane.setViewportView(AllGamelist);

		JPanel panel = new JPanel();
		scrollPane.setColumnHeaderView(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

		textField = new JTextField();
		textField.setEditable(false);
		textField.setText(
				"\u0412\u0432\u0435\u0434\u0438\u0442\u0435 \u0438\u043C\u044F \u043D\u043E\u0432\u043E\u0439 \u0438\u0433\u0440\u044B:");
		panel.add(textField);
		textField.setColumns(10);

		newGameTextField = new JTextField();
		panel.add(newGameTextField);
		newGameTextField.setColumns(10);
		JButton addNewGame = new JButton("\u0414\u043E\u0431\u0430\u0432\u0438\u0442\u044C");
		addNewGame.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent e) {
				newGameName=newGameTextField.getText();
				gameDir.addNewGame(newGameName);
				System.out.println(newGameName);
				AbstractListModel model = new AbstractListModel() {
					String[] values = gameDir.getAllGames();

					public int getSize() {
						return values.length;
					}

					public Object getElementAt(int index) {
						return values[index];
					}
				};
				AllGamelist.setModel(model);
				gameList.setModel(model);
				selectGameTop10ComboBox.setModel(new DefaultComboBoxModel(gameDir.getAllGames()));
				
			}
		});
		panel.add(addNewGame);
		JPanel addRating = new JPanel();
		FlowLayout fl_addRating = (FlowLayout) addRating.getLayout();
		fl_addRating.setAlignment(FlowLayout.LEFT);
		frame.getContentPane().add(addRating, BorderLayout.SOUTH);

		JLabel label_1 = new JLabel(
				"\u0414\u043E\u0431\u0430\u0432\u0438\u0442\u044C \u0440\u0435\u0439\u0442\u0438\u043D\u0433 \u0418\u0433\u0440\u043E\u043A\u0443:");
		addRating.add(label_1);

		gamersComboBox.setModel(new DefaultComboBoxModel(gameDir.getAllGamers()));
		addRating.add(gamersComboBox);

		JLabel label_2 = new JLabel("\u0432 \u0438\u0433\u0440\u0435:");
		addRating.add(label_2);

		gameComboBox.setModel(new DefaultComboBoxModel(gameDir.getGamerGames(gamerForAddRating)));
		addRating.add(gameComboBox);

		addRating.add(addRatingButton);
		addRatingButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent paramActionEvent) {
				try {
					if (gameForAddRating !="" && gamerForAddRating !=""){
					gameDir.setGamesGamersRating(gameForAddRating, gamerForAddRating, 1);
					addRatingResult
							.setText("Игроку " + gamerForAddRating + " добавлен рейтинг в игре " + gameForAddRating);
						
					}else{
						addRatingResult.setText("выбери игрока или игруб Блеать!");
					}
					} catch (NullPointerException e) {
					addRatingResult.setText("выбери игрока!");
				}

			}
		});

		addRatingResult = new JTextField();
		addRatingResult.setEditable(false);
		addRating.add(addRatingResult);
		addRatingResult.setColumns(25);

		JPanel panelStatistic = new JPanel();
		frame.getContentPane().add(panelStatistic, BorderLayout.WEST);
		panelStatistic.setLayout(new BoxLayout(panelStatistic, BoxLayout.Y_AXIS));

	
		Component verticalGlue = Box.createVerticalGlue();
		panelStatistic.add(verticalGlue);

		JSeparator separator_3 = new JSeparator();
		panelStatistic.add(separator_3);

		JLabel label_3 = new JLabel("Игры в которые играют все игроки:");
		panelStatistic.add(label_3);

		JButton showGameListbutton = new JButton("\u043F\u043E\u043A\u0430\u0437\u0430\u0442\u044C");
		panelStatistic.add(showGameListbutton);
		showGameListbutton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent paramActionEvent) {
				String[] games = gameDir.getGamesAllGamersPlayed();
				String gamesString = "";
				int i = 1;
				for (String string : games) {
					gamesString += i + ") " + string + "\n";
					i++;
				}

				statisticResulttextField.setText(gamesString);

			}
		});

		Component verticalStrut = Box.createVerticalStrut(20);
		panelStatistic.add(verticalStrut);

		Component verticalGlue_2 = Box.createVerticalGlue();
		panelStatistic.add(verticalGlue_2);

		JSeparator separator_1 = new JSeparator();
		panelStatistic.add(separator_1);

		JLabel label_4 = new JLabel(
				"10 \u043B\u0443\u0447\u0448\u0438\u0445 \u0438\u0433\u0440\u043E\u043A\u043E\u0432:");
		panelStatistic.add(label_4);

		JButton top10gamersButton = new JButton("\u043F\u043E\u043A\u0430\u0437\u0430\u0442\u044C");
		panelStatistic.add(top10gamersButton);
		top10gamersButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String[] strArr = gameDir.getAllGamesRating();
				String gamersString = "";
				for (int i = strArr.length - 1; i >= 0; i--) {
					if ((strArr.length - i) <= 10) {
						gamersString += (strArr.length - i) + ") " + strArr[i] + "\n";
					}
				}
				statisticResulttextField.setText(gamersString);
			}
		});

		Component verticalStrut_1 = Box.createVerticalStrut(20);
		panelStatistic.add(verticalStrut_1);

		JSeparator separator = new JSeparator();
		panelStatistic.add(separator);

		Component verticalGlue_3 = Box.createVerticalGlue();
		panelStatistic.add(verticalGlue_3);

		JLabel lblNewLabel = new JLabel(
				"10 \u043B\u0443\u0447\u0448\u0438\u0445 \u0438\u0433\u0440\u043E\u043A\u043E\u0432 \u0432 \u0438\u0433\u0440\u0435:");
		panelStatistic.add(lblNewLabel);

		
		
		selectGameTop10ComboBox.setModel(
				new DefaultComboBoxModel(gameDir.getAllGames()));
		panelStatistic.add(selectGameTop10ComboBox);
		selectGameTop10ComboBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox box = (JComboBox) e.getSource();
				gameForTop10 = (String) box.getSelectedItem();

			}

		});

		JButton top10gamersInOneGamebutton = new JButton("\u043F\u043E\u043A\u0430\u0437\u0430\u0442\u044C");
		panelStatistic.add(top10gamersInOneGamebutton);
		top10gamersInOneGamebutton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try{
				String[] strArr=gameDir.getTop10InOneGame(gameForTop10);
				String gamersString = "";
				for (int i = strArr.length - 1; i >= 0; i--) {
					if ((strArr.length - i) <= 10) {
						gamersString += (strArr.length - i) + ") " + strArr[i] + "\n";
					}
				}
				statisticResulttextField.setText(gamersString);
				}
				catch (NullPointerException nullErr){
					statisticResulttextField.setText("В эту игру никто не хочет играть");
				}
			}
		});

		Component verticalStrut_2 = Box.createVerticalStrut(20);
		panelStatistic.add(verticalStrut_2);

		Component verticalGlue_4 = Box.createVerticalGlue();
		panelStatistic.add(verticalGlue_4);

		JSeparator separator_2 = new JSeparator();
		panelStatistic.add(separator_2);

		JLabel label_5 = new JLabel("\u0420\u0435\u0439\u0442\u0438\u043D\u0433 \u0418\u0433\u0440\u043E\u043A\u0430:");
		panelStatistic.add(label_5);

		selectGamerForOneRatingComboBox.setModel(new DefaultComboBoxModel(gameDir.getAllGamers()));
		panelStatistic.add(selectGamerForOneRatingComboBox);

		JLabel label_6 = new JLabel("\u0432 \u0438\u0433\u0440\u0435:");
		panelStatistic.add(label_6);

		panelStatistic.add(selectGameForOneRatingComboBox);

		panelStatistic.add(oneGamerOnOneGameRatingbutton);
		oneGamerOnOneGameRatingbutton.setEnabled(false);
		oneGamerOnOneGameRatingbutton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int rating = gameDir.getGamerInOneGameRating(gameForOneRating, gamerForOneRating);
				statisticResulttextField.setText(
						"рейтинг игрока " + gamerForOneRating + " в игре " + gameForOneRating + " - " + rating);
			}
		});
		Component verticalGlue_1 = Box.createVerticalGlue();
		panelStatistic.add(verticalGlue_1);

		JPanel statisticResultPanel = new JPanel();
		frame.getContentPane().add(statisticResultPanel, BorderLayout.CENTER);
		statisticResultPanel.setLayout(new BoxLayout(statisticResultPanel, BoxLayout.Y_AXIS));

		JLabel label_7 = new JLabel(
				"\u0420\u0435\u0437\u0443\u043B\u044C\u0442\u0430\u0442 \u0437\u0430\u043F\u0440\u043E\u0441\u0430:");
		statisticResultPanel.add(label_7);

		statisticResulttextField = new JTextArea();
		statisticResulttextField.setAlignmentY(Component.TOP_ALIGNMENT);

		statisticResulttextField.setEditable(false);
		statisticResultPanel.add(statisticResulttextField);
		statisticResulttextField.setColumns(10);
		frame.setVisible(true);
	}

}
