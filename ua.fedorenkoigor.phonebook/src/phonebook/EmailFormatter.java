package phonebook;

import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFormattedTextField.AbstractFormatter;

public class EmailFormatter extends AbstractFormatter  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	final private Pattern regexp = Pattern
			.compile("^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$");

	@Override
	public Object stringToValue(String string) throws ParseException {
		Matcher matcher = regexp.matcher(string);
		if (matcher.matches())
			return string;
		throw new ParseException("Not an email", 0);
	}

	@Override
	public String valueToString(Object value) {
		return (String) value;
	}

}