package ua.fedorenkoigor.calculator;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;

public class Calculator {

	private static StringBuilder textString = new StringBuilder("");
	private static StringBuilder numberText = new StringBuilder("");
	private static double numberOne = 0;
	private static double numberTwo = 0;
	private static boolean dotSettled = false;
	private static int action = 0;

	public static void main(String[] args) {
		JFrame frame = new JFrame("Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(280, 250);

		frame.getContentPane().setLayout(new GridLayout(5, 1, 10, 0));

		JTextPane textPane = new JTextPane();
		frame.getContentPane().add(textPane);
		textPane.setEditable(false);
		textPane.setText("0");

		JPanel panel_2 = new JPanel();
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JButton button7 = new JButton("7");
		button7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				numberText.append("7");
				textString.append("7");
				textPane.setText(textString.toString());
			}
		});
		panel_2.add(button7);

		JButton button8 = new JButton("8");
		button8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numberText.append("8");
				textString.append("8");
				textPane.setText(textString.toString());
			}
		});
		panel_2.add(button8);

		JButton button9 = new JButton("9");
		button9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numberText.append("9");
				textString.append("9");
				textPane.setText(textString.toString());
			}
		});
		panel_2.add(button9);

		JButton buttonPosNeg = new JButton("+/-");
		buttonPosNeg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double transformer = Double.parseDouble(numberText.toString());
				if (action == 0) {
					if (transformer != 0) {
						transformer *= -1;
						numberText.delete(0, numberText.length());
						numberText.append(transformer);
						textString.delete(0, textString.length());
						textString.append(numberText.toString());
						textPane.setText(textString.toString());
					}
				}
			}
		});
		panel_2.add(buttonPosNeg);

		JButton buttonC = new JButton("C");
		buttonC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numberText.delete(0, numberText.length());
				numberOne = 0;
				numberTwo = 0;
				textString.delete(0, textString.length());
				textPane.setText("0");
				dotSettled = false;
			}
		});
		panel_2.add(buttonC);

		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1);

		JButton button4 = new JButton("4");
		button4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numberText.append("4");
				textString.append("4");
				textPane.setText(textString.toString());
			}
		});
		panel_1.add(button4);

		JButton button5 = new JButton("5");
		button5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numberText.append("5");
				textString.append("5");
				textPane.setText(textString.toString());
			}
		});
		panel_1.add(button5);

		JButton button6 = new JButton("6");
		button6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numberText.append("6");
				textString.append("6");
				textPane.setText(textString.toString());
			}
		});
		panel_1.add(button6);

		JButton buttonPlus = new JButton("+");
		buttonPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doOperator(textPane, "+");
				action = 1;
			}
		});
		panel_1.add(buttonPlus);

		JButton buttonMinus = new JButton("-");
		buttonMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doOperator(textPane, "-");
				action = 2;
			}
		});
		panel_1.add(buttonMinus);

		JPanel panel_3 = new JPanel();
		frame.getContentPane().add(panel_3);

		JButton button1 = new JButton("1");
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numberText.append("1");
				textString.append("1");
				textPane.setText(textString.toString());
			}
		});
		panel_3.add(button1);

		JButton button2 = new JButton("2");
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numberText.append("2");
				textString.append("2");
				textPane.setText(textString.toString());
			}
		});
		panel_3.add(button2);

		JButton button3 = new JButton("3");
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numberText.append("3");
				textString.append("3");
				textPane.setText(textString.toString());
			}
		});
		panel_3.add(button3);

		JButton buttonMultiply = new JButton("*");
		buttonMultiply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doOperator(textPane, "*");
				action = 3;
			}
		});
		panel_3.add(buttonMultiply);

		JButton buttonDivide = new JButton("/");
		buttonDivide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				doOperator(textPane, "/");
				action = 4;
			}
		});
		panel_3.add(buttonDivide);

		JPanel panel_4 = new JPanel();
		frame.getContentPane().add(panel_4);

		JButton button0 = new JButton("0");
		button0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numberText.append("0");
				textString.append("0");
				textPane.setText(textString.toString());
			}
		});
		panel_4.add(button0);

		JButton buttonDot = new JButton(",");
		buttonDot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!dotSettled) {
					if (numberText.length() == 0) {
						numberText.append("0.");
						textString.append("0.");
					} else {
						numberText.append(".");
						textString.append(".");
					}
					textPane.setText(textString.toString());
					dotSettled = true;
				}
			}
		});
		panel_4.add(buttonDot);

		JButton buttonIs = new JButton("=");
		buttonIs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (action != 0) {
					doOperator(textPane, "");
					makeCalculation(textPane);
				}

			}
		});
		panel_4.add(buttonIs);
		frame.setVisible(true);
	}

	private static void doOperator(JTextPane textPane, String operator) {
		if (action == 0) {
			numberOne = Double.parseDouble(numberText.toString());
			textString.append(operator);
			numberText.delete(0, numberText.length());
			textPane.setText(textString.toString());
			dotSettled = false;
		} else {
			numberTwo = Double.parseDouble(numberText.toString());
			numberText.delete(0, numberText.length());
			textPane.setText(textString.toString());
			dotSettled = false;
		}
	}

	private static void makeCalculation(JTextPane textPane) {
		if (action != 0) {
			textString.delete(0, textString.length());
			switch (action) {
			case 1: {
				double result = numberOne + numberTwo;
				textString.append(result);
				textPane.setText(textString.toString());
				numberText.append(result);
				break;
			}
			case 2: {
				double result = numberOne - numberTwo;
				textString.append(result);
				textPane.setText(textString.toString());
				numberText.append(result);
				break;
			}
			case 3: {
				double result = numberOne * numberTwo;
				textString.append(result);
				textPane.setText(textString.toString());
				numberText.append(result);
				break;
			}
			case 4: {
				if (numberTwo != 0) {
					double result = numberOne / numberTwo;
					textString.append(result);
					numberText.append(result);
					textPane.setText(textString.toString());
				} else {
					textString.append("Can't devide on 0");
					textPane.setText(textString.toString());
					textString.delete(0, textString.length());
				}

				break;
			}
			}

			dotSettled = true;
			action = 0;

		}
	}
}
