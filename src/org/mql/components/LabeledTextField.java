package org.mql.components;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LabeledTextField extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8919363435732136302L;

	public LabeledTextField(String label, int size) {
		setLayout(new FlowLayout(FlowLayout.LEFT));
		if(!label.contains(":")) label += ":";
		JLabel l = new JLabel(label); add(l);
		JTextField tf = new JTextField(size); add(tf);
	}
	
	public LabeledTextField(String label, int size, int labelWidth, int labelHeight) {
		this(label,size);
		JLabel l = (JLabel)getComponent(0);
		l.setPreferredSize(new Dimension(labelWidth,labelHeight));
	}
}
