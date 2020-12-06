package de.christian_boehm.calculator.app;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ZiffernListener implements ActionListener {
	private TextField tf;

	public ZiffernListener(TextField tf) {
		this.setTf(tf);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String actionText = e.getActionCommand();

		switch (actionText) {
		case "0":
			setTfOutput(tf, actionText);
			break;
		case "1":
			setTfOutput(tf, actionText);
			break;
		case "2":
			setTfOutput(tf, actionText);
			break;
		case "3":
			setTfOutput(tf, actionText);
			break;
		case "4":
			setTfOutput(tf, actionText);
			break;
		case "5":
			setTfOutput(tf, actionText);
			break;
		case "6":
			setTfOutput(tf, actionText);
			break;
		case "7":
			setTfOutput(tf, actionText);
			break;
		case "8":
			setTfOutput(tf, actionText);
			break;
		case "9":
			setTfOutput(tf, actionText);
			break;
		default:
			break;
		}

	}

	private void setTfOutput(TextField tf, String actionText) {
		String textNow = tf.getText();
		textNow += actionText;
		if (textNow.length() <= 10) {
			tf.setText(textNow);
		}

	}

	public TextField getTf() {
		return tf;
	}

	public void setTf(TextField tf) {
		this.tf = tf;
	}

}
