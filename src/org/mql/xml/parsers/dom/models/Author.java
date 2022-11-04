package org.mql.xml.parsers.dom.models;

public class Author {
	private int id;
	private String name;
	private String country;
	private Date birthday;
	
	public Author() {
	}

	public Author(int id, String name, String country, Date birthday) {
		super();
		this.id = id;
		this.name = name;
		this.country = country;
		this.birthday = birthday;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String toString() {
		return "Author [id=" + id + ", name=" + name + ", country=" + country + ", birthday=" + birthday + "]";
	}
}
