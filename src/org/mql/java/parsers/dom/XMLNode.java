package org.mql.java.parsers.dom;

import java.util.Hashtable;
import java.util.List;
import java.util.Vector;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLNode {
	private Node node;
	private Logger logger = LoggerFactory.getLogger(XMLNode.class);
	public XMLNode(String source) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newDefaultInstance();
		try {
			DocumentBuilder document = factory.newDocumentBuilder();
			node = document.parse(source).getFirstChild();
			logger.info(node.getNodeName()+" "+node.getNodeType()+" "+node.getNodeValue());
			while(node.getNodeType() != Node.ELEMENT_NODE) {
				node = node.getNextSibling();
				logger.info(node.getNodeName()+" "+node.getNodeType()+" "+node.getNodeValue());
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public XMLNode(Node n) {
		node = n;
	}
	
	public List<XMLNode> getChilds() {
		NodeList nodes = node.getChildNodes();
		List<XMLNode> childs = new Vector<>();
		for(int i = 0;i < nodes.getLength();i++) {
			Node n = nodes.item(i);
			if(n.getNodeType() == Node.ELEMENT_NODE) {
				childs.add(new XMLNode(n));
				logger.info("--> element founded :"+n.getNodeName());
			}
		}
		return childs;
	}
	
	public Hashtable<String, List<XMLNode>> getChildsMap(){
		Hashtable<String, List<XMLNode>> map = new Hashtable<String, List<XMLNode>>();
		List<XMLNode> childs = getChilds();
		for(XMLNode n : childs) {
			List<XMLNode> nodes = map.get(n.getName());
			if(nodes == null){
				nodes = new Vector<>();
				map.put(n.getName(),nodes);
			}
			nodes.add(n);
		}
		return map;
	}
	
	private String getName() {
		return node.getNodeName();
	}
	public String getAttribute(String name) {
		NamedNodeMap attributes = node.getAttributes();
		Node attribute = attributes.getNamedItem(name);
		if(attribute == null) return "";
		return attribute.getNodeValue();
	}
	
	public int getIntAttribute(String name) {
		return Integer.parseInt(getAttribute(name));
	}
	
	public double getDoubleAttribute(String name) {
		return Double.parseDouble(getAttribute(name));
	}
	
	public String getValue() {
		if(node.getNodeType() != Node.ELEMENT_NODE) return node.getNodeValue();
		return node.getFirstChild().getNodeValue();
	}
	
	public double getDoubleValue() {
		return Double.parseDouble(getValue());
	}
	
	public XMLNode getParent() {
		return new XMLNode(node.getParentNode());
	}
	
	public List<String> getAllComments() {
		List<XMLNode> childs = getAllChilds();
		List<String>  comments = new Vector<>();
		for(XMLNode n : childs) {
			if(n.getType() == Node.COMMENT_NODE)  {
				comments.add(n.getValue());
			}else if(n.getType() == Node.ELEMENT_NODE) {
				comments.addAll(n.getAllComments());
			}
		}
		return comments;
	}
	private List<XMLNode> getAllChilds() {
		NodeList nodes = node.getChildNodes();
		List<XMLNode> childs = new Vector<>();
		for(int i = 0;i < nodes.getLength();i++) {
				childs.add(new XMLNode(nodes.item(i)));
		}
		return childs;
	}
	private short getType() {
		return node.getNodeType();
	}
}
