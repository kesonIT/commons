package com.cloudaxis.usage.jaxb.maptolist;

import javax.xml.bind.annotation.XmlElement;

public class Courses {
	@XmlElement(name = "course")
	public Course[] carray;
}
