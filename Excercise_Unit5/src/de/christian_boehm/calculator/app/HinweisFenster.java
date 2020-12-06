package de.christian_boehm.calculator.app;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * this universal, convenient modal dialog class is borrowed from 
 * FernUni in Hagen - Course 1618 Introduction into
 * OOP with Java Page: 325, Figure: 12.10
 */

@SuppressWarnings("serial")
public class HinweisFenster extends Dialog {
	private Label lErrorLabel;


	public HinweisFenster(Frame owner) {
		super(owner, true); 
		lErrorLabel = new Label("", Label.CENTER);
		add(lErrorLabel); 
		Button ok = new Button("ok");
		ok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				HinweisFenster.this.setVisible(false);
			}
		});
		add(ok, BorderLayout.SOUTH);
		setSize(200, 100);
		setLocationRelativeTo(owner); 
	}

	public void setText(String s) {
		lErrorLabel.setText(s);
	}
}
