package org.mql.java.parsers.dom;

import java.util.List;
import java.util.Vector;

import org.mql.xml.parsers.dom.models.Author;
import org.mql.xml.parsers.dom.models.Date;
import org.mql.xml.parsers.dom.models.Document;
import org.mql.xml.parsers.dom.models.Title;

public class BiblioParser {
	public List<Document> parse(String source) {
		XMLNode root = new XMLNode(source);
		List<Document> docs = new Vector<>();
		List<XMLNode> childs = root.getChilds();
		for(XMLNode n: childs) {
			Document d = new Document();
			d.setId(n.getIntAttribute("id"));
			d.setTitles(getTitles(n));
			d.setPrice(n.getChildsMap().get("price").get(0).getDoubleValue());
			d.setAuthors(getAuthors(n));
			docs.add(d);
		}
		return docs;
	}

	private List<Author> getAuthors(XMLNode n) {
		List<Author> authors = new Vector<>();
		XMLNode authorsNode = n.getChildsMap().get("authors").get(0);
		List<XMLNode> authorsNodes = authorsNode.getChilds();
		for(XMLNode author: authorsNodes) {
			Author a = new Author();
			a.setId(author.getIntAttribute("id"));
			a.setName(author.getChildsMap().get("name").get(0).getValue());
			a.setCountry(author.getChildsMap().get("country").get(0).getValue());
			XMLNode birthdayNode = author.getChildsMap().get("birthday").get(0);
			int day = birthdayNode.getIntAttribute("day");
			int month = birthdayNode.getIntAttribute("month");
			int year = birthdayNode.getIntAttribute("year");
			a.setBirthday(new Date(day,month,year));
			authors.add(a);
		}
		return authors;
	}

	private List<Title> getTitles(XMLNode n) {
		List<Title> titles = new Vector<>();
		List<XMLNode> titlesNodes = n.getChildsMap().get("title");
		for(XMLNode t: titlesNodes) {
			Title title = new Title(t.getAttribute("lang"),t.getValue());
			titles.add(title);
		}
		return titles;
	}
	
	public List<String> getComments(String source){
		XMLNode documentNode = new XMLNode(source).getParent();
		return documentNode.getAllComments();
	}
}
