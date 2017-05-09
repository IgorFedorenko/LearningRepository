package phonebook;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.ParseException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JSplitPane;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JLabel;
import javax.swing.text.AbstractDocument;
import javax.swing.text.DocumentFilter;
import javax.swing.text.MaskFormatter;

public class PhonePane extends JSplitPane {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7868180569945122592L;

	JFormattedTextField newNumber;
	PhoneType phoneType;
	MaskFormatter formatter = null;
	PhonePane() {
		JComboBox numberTypeComboBox_1 = new JComboBox();
		setLeftComponent(numberTypeComboBox_1);

		numberTypeComboBox_1.setModel(new DefaultComboBoxModel<PhoneType>(PhoneType.values()));
		setRightComponent(new JLabel("выбери тип"));
		try {
			formatter = new MaskFormatter("+38-(###)-###-##-##");
			formatter.setValidCharacters("0123456789");
		} catch (java.text.ParseException exc) {
			System.err.println("formatter is bad: " + exc.getMessage());
		}
		
		numberTypeComboBox_1.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent arg0) {
				phoneType = (PhoneType) arg0.getItem();
				if (!phoneType.equals(null)) {
					
					
					if (phoneType.equals(phoneType.Email)){
				
						newNumber = new JFormattedTextField(new EmailFormatter());

						
					}
					
					else newNumber = new JFormattedTextField(formatter);

					
					newNumber.setFocusLostBehavior(JFormattedTextField.COMMIT);
					setRightComponent(newNumber);
					newNumber.setColumns(10);
				}
			repaint();
			}
		
		});
		
		
	}
}
