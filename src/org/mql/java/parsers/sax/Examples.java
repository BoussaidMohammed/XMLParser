package org.mql.java.parsers.sax;

import javax.swing.JFrame;
import javax.swing.JMenuBar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Examples {
	private Logger logger = LoggerFactory.getLogger(Examples.class);
	
	public Examples() {
		exp1();
	}
	
	void exp1() {
		MenuParser parser = new MenuParser("resources/swing/menu-bar.xml");
		JFrame frame = new JFrame("XML parsing");
		JMenuBar menu = parser.getMenu();
		frame.setJMenuBar(menu);
		frame.setSize(500,300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	public static void main(String[] args) {
		new Examples();
	}
}
