
package com.junit;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class EeadXML {
	public static void main(String[] args) {
		try{
			File xmlFile = new File("E:\\info2.xml");
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();	
			Document doc = builder.parse(xmlFile);
			NodeList ma = doc.getElementsByTagName("login");
			System.out.println(ma.item(0).getAttributes().getNamedItem("username"));
			System.out.println(ma.item(0).getAttributes().getNamedItem("passwd"));
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
