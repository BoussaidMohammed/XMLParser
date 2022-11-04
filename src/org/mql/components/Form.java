package org.mql.components;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class Form extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int labelWidth;
	private int labelHeight;
	
	public Form(String title, int labelWidth, int labelHeight) {
		this.labelWidth = labelWidth;
		this.labelHeight = labelHeight;
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBorder(new TitledBorder(new EtchedBorder()," "+ title + " "));
	}
	
	public void addLabeledTextField(String label, int size) {
		add(new LabeledTextField(label, size, labelWidth, labelHeight));
	}

	public void addChoicePanel(String label, int type, String[] items) {
		add(new ChoicePanel(label, type, labelWidth, labelHeight,items));
	}
}
