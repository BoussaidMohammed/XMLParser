package org.mql.java.parsers.sax;

import java.awt.Menu;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MenuParser extends DefaultHandler {
	private Logger logger = LoggerFactory.getLogger(MenuParser.class);
	private JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem item;
	private String iconsFolder;

	public MenuParser(String source) {
		SAXParserFactory factory = SAXParserFactory.newDefaultInstance();
		try {
			SAXParser parser = factory.newSAXParser();
			parser.parse(source, this);
		} catch (Exception e) {
			logger.warn(e.getMessage());
		}
	}

	public void startDocument() throws SAXException {
		logger.info("Start of document");
	}

	public void endDocument() throws SAXException {
		logger.info("End of Document");
	}

	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if (qName.equals("menu-bar")) {
			menuBar = new JMenuBar();
			iconsFolder = attributes.getValue("icons-folder");
			if (!iconsFolder.endsWith("/")) {
				iconsFolder += "/";
			}
		} else if (qName.equals("menu")) {
			menu = new JMenu(attributes.getValue("name"));
			menuBar.add(menu);
		} else if (qName.equals("item")) {
			ImageIcon icon = new ImageIcon(iconsFolder + attributes.getValue("icon"));
			item = new JMenuItem(attributes.getValue("name"), icon);
			menu.add(item);
			if(attributes.getValue("name").equals("Exit")) {
				item.addActionListener(e -> {
					System.exit(0);
				});
			}
		} else if (qName.equals("separator")) {
			menu.addSeparator();
		}
	}

	public void endElement(String uri, String localName, String qName) throws SAXException {
		item = null;
	}

	public void characters(char[] ch, int start, int length) throws SAXException {
		if(item != null) item.setToolTipText(new String(ch,start,length));
	}

	public JMenuBar getMenu() {
		return menuBar;
	}
}
