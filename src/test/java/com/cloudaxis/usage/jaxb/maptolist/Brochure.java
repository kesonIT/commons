package com.cloudaxis.usage.jaxb.maptolist;

import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

//@XmlRootElement
@XmlJavaTypeAdapter(BrochureAdapter.class)
// @XmlRootElement(name="courses")
public class Brochure {
	public Map<String, Course> courses;

	public Brochure() {
		courses = new HashMap<String, Course>();
	}
}
