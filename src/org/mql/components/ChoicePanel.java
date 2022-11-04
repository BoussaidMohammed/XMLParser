package org.mql.components;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class ChoicePanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8919363435732136302L;
	public static final int RADIO = 0, CHECKBOX = 1, COMBOBOX = 2;
	private String[] items;

	public ChoicePanel(String label, int type,String... items) {
		setLayout(new FlowLayout(FlowLayout.LEFT));
		if(!label.contains(":")) label += ":";
		JLabel l = new JLabel(label); add(l);
		this.items = items;
		if(type == RADIO) addRadioField();
		else if (type == CHECKBOX) addCheckBox();
		else addCombobox();
		
	}
	
	private void addCombobox() {
		JComboBox<String> cb = new JComboBox<String>(items);
		add(cb);
	}

	private void addCheckBox() {
		for(String s : items) {
			JCheckBox cb = new JCheckBox(s);
			add(cb);
		}
	}

	private void addRadioField() {
		ButtonGroup gr1 = new ButtonGroup();
		for(String s : items) {
			JRadioButton r = new JRadioButton(s);
			gr1.add(r); add(r);
		}
	}

	public ChoicePanel(String label, int type, int labelWidth, int labelHeight,String...items) {
		this(label,type,items);
		JLabel l = (JLabel)getComponent(0);
		l.setPreferredSize(new Dimension(labelWidth,labelHeight));
	}
}
