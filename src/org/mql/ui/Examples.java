package org.mql.ui;

import javax.swing.JFrame;

import org.mql.annotations.FormeEngine;
import org.mql.components.Form;
import org.mql.models.Document;

public class Examples extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		new Examples();
	}
	
	public Examples() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		exp1();
		setVisible(true);
		pack();
	}

	private void exp1() {
		FormeEngine engine = new FormeEngine(Document.class);
		Form form = engine.getForme();
		setContentPane(form);
	}
}
