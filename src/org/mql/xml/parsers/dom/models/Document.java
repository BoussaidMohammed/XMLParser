package org.mql.xml.parsers.dom.models;

import java.util.List;
import java.util.Vector;

public class Document {
	private int id;
	private List<Title> titles;
	private double price;
	private List<Author> authors;
	
	public Document() {
		titles = new Vector<>();
		authors = new Vector<>();
	}

	public Document(int id, String title, double price) {
		super();
		this.id = id;
		this.price = price;
		this.titles = new Vector<>();
		this.titles.add(new Title("fr", title));
	}

	public void addTitle(Title title) {
		titles.add(title);
	}

	public void addAuthor(Author author) {
		authors.add(author);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Title> getTitles() {
		return titles;
	}

	public void setTitles(List<Title> titles) {
		this.titles = titles;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

	public String toString() {
		StringBuffer sb = new StringBuffer("Document N° " + id + " : \n");
		sb.append(" - Titre : " + titles + "\n");
		sb.append(" - Prix : " + price + "\n");
		sb.append(" - Auteurs : \n");
		for (Author author : authors) {
			sb.append("\t" + author + "\n");
		}
		return sb.toString();
	}
}
