package org.mql.xml.parsers.dom.models;

public class Title {
	private String lang;
	private String value;
	
	public Title() {
	}

	public Title(String lang, String value) {
		super();
		this.lang = lang;
		this.value = value;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String toString() {
		return value + " (" + lang + ")";
	}
}
