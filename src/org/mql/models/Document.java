package org.mql.models;

import org.mql.annotations.ChoiceField;
import org.mql.annotations.FormAnn;
import org.mql.annotations.TextField;
import org.mql.components.ChoicePanel;
import org.mql.ennumerations.DocumentType;

@FormAnn(title = "Nouveau Document")
public class Document {
	@TextField
	private Integer id;
	@TextField
	private String title;
	@TextField
	private Double price;
	@TextField
	private String publisher;
	@ChoiceField(label = "Type de document", items = {"BOOK","PAPER","JOURNAL","REPORT"})
	private DocumentType type;
	@ChoiceField(label = "Type de document", items = {"BOOK","PAPER","JOURNAL"}, type = ChoicePanel.RADIO)
	private String format;
}
