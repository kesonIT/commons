package com.cloudaxis.usage.jaxb.maptolist;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Course {
	@XmlAttribute
	String id;
	@XmlElement
	String name;
	@XmlElement
	Double price;
}