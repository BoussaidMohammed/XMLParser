package org.mql.java.parsers.dom;

import java.util.List;

import org.mql.xml.parsers.dom.models.Document;

public class Examples {
	
	public Examples() {
		exp2();
	}
	
	void exp1(){
		BiblioParser biblio = new BiblioParser();
		List<Document> docs = biblio.parse("resources/docs/biblio.xml");
		System.out.println(docs);
	}
	
	void exp2(){
		BiblioParser biblio = new BiblioParser();
		List<String> comments = biblio.getComments("resources/docs/biblio.xml");
		System.out.println(comments);
	}
	public static void main(String[] args) {
		new Examples();
	}
}
