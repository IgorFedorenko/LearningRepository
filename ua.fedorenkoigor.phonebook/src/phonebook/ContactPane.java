package phonebook;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JSplitPane;
import javax.swing.JTextField;


public class ContactPane extends JSplitPane {

 

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	ContactPane(Person person) {
		
		
		JTextField resultName = new JTextField();
		resultName.setText(person.getName());
		resultName.setEditable(false);
		setLeftComponent(resultName);
		resultName.setColumns(35);

		JButton contactView = new JButton("просмотреть");
		contactView.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
	
				JOptionPane.showMessageDialog(getRootPane(), person, "Подробности", 1 , null);
				
			}
		});
		setRightComponent(contactView);
		repaint();
	}
}
