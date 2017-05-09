package ua.fedorenkoigor.notepad;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JTextPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.Box;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.Component;

public class Notepad extends JFrame {
	public Notepad() {
		getContentPane().setLayout(new BorderLayout(0, 0));
	}

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		int fontSize = 20;
		String font = "Arial";

		JFrame frame = new JFrame("Wordpad");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 600);
		frame.getContentPane().setLayout(new BorderLayout());

		JScrollPane scrollPane = new JScrollPane();
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

		JTextPane textPane = new JTextPane();
		scrollPane.setViewportView(textPane);
		textPane.setFont(new Font(font, Font.PLAIN, fontSize));

		JMenuBar menuBar = new JMenuBar();
		scrollPane.setColumnHeaderView(menuBar);

		JMenu menuFile = new JMenu("File");
		menuBar.add(menuFile);

		JMenuItem menuItemNew = new JMenuItem("New");
		menuFile.add(menuItemNew);

		JMenuItem menuItemOpen = new JMenuItem("Open...");
		menuFile.add(menuItemOpen);

		JMenuItem menuItemSave = new JMenuItem("Save");
		menuFile.add(menuItemSave);

		JMenuItem menuItemSaveAs = new JMenuItem("Save As...");
		menuFile.add(menuItemSaveAs);

		JMenuItem menuItemExit = new JMenuItem("Exit");
		menuFile.add(menuItemExit);
		menuItemExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent paramActionEvent) {
				System.exit(0);

			}
		});

		JMenu menuEdit = new JMenu("Edit");
		menuBar.add(menuEdit);

		JMenuItem menuItemCancel = new JMenuItem("Cancel");
		menuEdit.add(menuItemCancel);

		JSeparator separatorCancel = new JSeparator();
		menuEdit.add(separatorCancel);

		JMenuItem menuItemCut = new JMenuItem("Cut");
		menuEdit.add(menuItemCut);

		JMenuItem menuItemCopy = new JMenuItem("Copy");
		menuEdit.add(menuItemCopy);

		JMenuItem menuItemPaste = new JMenuItem("Paste");
		menuEdit.add(menuItemPaste);

		JMenuItem menuItemDelete = new JMenuItem("Delete");
		menuEdit.add(menuItemDelete);

		JSeparator separatorDelete = new JSeparator();
		menuEdit.add(separatorDelete);

		JMenuItem menuItemFind = new JMenuItem("Find...");
		menuEdit.add(menuItemFind);

		JMenuItem menuItemFindNext = new JMenuItem("Find next");
		menuEdit.add(menuItemFindNext);

		JMenuItem menuItemChange = new JMenuItem("Change...");
		menuEdit.add(menuItemChange);

		JMenuItem menuItemGoto = new JMenuItem("Goto...");
		menuEdit.add(menuItemGoto);

		JSeparator separatorGoto = new JSeparator();
		menuEdit.add(separatorGoto);

		JMenuItem menuItemSelectAll = new JMenuItem("Select All");
		menuEdit.add(menuItemSelectAll);

		JMenuItem menuItemTimeAndDate = new JMenuItem("Time and Date");
		menuEdit.add(menuItemTimeAndDate);

		JMenu menuFormat = new JMenu("Format");
		menuBar.add(menuFormat);

		JMenuItem menuItemDivisionByWords = new JMenuItem("Division by words");
		menuFormat.add(menuItemDivisionByWords);

		JMenu menuFont = new JMenu("Font...");
		menuFont.setHorizontalAlignment(SwingConstants.LEFT);
		menuFont.setBackground(Color.LIGHT_GRAY);
		menuFormat.add(menuFont);

		Box boxFontType = Box.createHorizontalBox();
		boxFontType.setBorder(new EmptyBorder(0, 5, 0, 0));
		menuFont.add(boxFontType);

		JLabel fontTypeLabel = new JLabel("Font ");
		fontTypeLabel.setAlignmentX(5.5f);
		boxFontType.add(fontTypeLabel);
		fontTypeLabel.setHorizontalAlignment(SwingConstants.RIGHT);

		Component horizontalStrutFont = Box.createHorizontalStrut(20);
		boxFontType.add(horizontalStrutFont);

		JComboBox comboBoxFontType = new JComboBox();
		fontTypeLabel.setLabelFor(comboBoxFontType);
		boxFontType.add(comboBoxFontType);
		comboBoxFontType.setModel(new DefaultComboBoxModel(new String[] { "Arial", "Times New Roman", "Courier" }));
		comboBoxFontType.setSelectedIndex(0);
		comboBoxFontType.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent itemEvent) {
				String state = comboBoxFontType.getSelectedItem().toString();
				System.out.println(state);

				/*
				 * String fontName = (String) thisBox.getSelectedItem();
				 * System.out.println("selected: "+fontName);
				 * textPane.setFont(new Font(fontName, Font.PLAIN, fontSize));
				 * int selected = thisBox.getSelectedIndex();
				 * comboBoxFontType.setSelectedIndex(selected);
				 * frame.revalidate();
				 */
			}
		});

		Box boxFontSize = Box.createHorizontalBox();
		menuFont.add(boxFontSize);

		JLabel labelFontWeight = new JLabel("Font weight");
		boxFontSize.add(labelFontWeight);
		labelFontWeight.setHorizontalAlignment(SwingConstants.CENTER);

		Component horizontalStrutFontWeight = Box.createHorizontalStrut(20);
		boxFontSize.add(horizontalStrutFontWeight);

		JSpinner fontWeightSpinner = new JSpinner();
		labelFontWeight.setLabelFor(fontWeightSpinner);
		boxFontSize.add(fontWeightSpinner);
		fontWeightSpinner.setToolTipText("");
		fontWeightSpinner.setModel(
				new SpinnerListModel(new Integer[] { 8, 9, 10, 11, 12, 14, 16, 18, 20, 22, 24, 26, 28, 36, 48, 72 }));
		fontWeightSpinner.setValue(20);
		fontWeightSpinner.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent arg0) {
				int fontSize = (Integer) fontWeightSpinner.getValue();
				textPane.setFont(new Font(font, Font.PLAIN, fontSize));
			}
		});
		Box boxFontWeight = Box.createHorizontalBox();
		menuFont.add(boxFontWeight);

		JLabel labelFontStyle = new JLabel("Font Style");
		boxFontWeight.add(labelFontStyle);

		Component horizontalStrutFontStyle = Box.createHorizontalStrut(20);
		boxFontWeight.add(horizontalStrutFontStyle);

		JSpinner fontStyleSpinner = new JSpinner();
		labelFontStyle.setLabelFor(fontStyleSpinner);
		boxFontWeight.add(fontStyleSpinner);
		fontStyleSpinner.setModel(new SpinnerListModel(new String[] { "normal", "italic", "bold" }));
		fontStyleSpinner.setValue("normal");
		fontStyleSpinner.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent arg0) {
				Object fontStyle = fontStyleSpinner.getValue();
				System.out.println(fontStyle);
				if (fontStyle.equals("normal")) {
					textPane.setFont(new Font(font, Font.PLAIN, fontSize));
				} else if (fontStyle.equals("italic")) {
					textPane.setFont(new Font(font, Font.ITALIC, fontSize));
				} else {
					textPane.setFont(new Font(font, Font.BOLD, fontSize));
				}
			}
		});
		JMenu menuAppearence = new JMenu("Appearence");
		menuBar.add(menuAppearence);

		JMenuItem menuItemStatusLine = new JMenuItem("Show status line");
		menuAppearence.add(menuItemStatusLine);

		JMenu menuHelp = new JMenu("Help");
		menuBar.add(menuHelp);

		JMenuItem menuItemShowHelp = new JMenuItem("Show Help");
		menuHelp.add(menuItemShowHelp);

		JSeparator separator = new JSeparator();
		menuHelp.add(separator);

		JMenuItem menuItemAbout = new JMenuItem("About");
		menuHelp.add(menuItemAbout);

		frame.setVisible(true);
	}

}
