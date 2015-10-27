package com.cloudaxis.usage.jaxb.maptolist;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "training")
public class Training {
	@XmlElement(name = "courses")
	public Brochure brochure;

	public Training() {
	}

	public Training(Brochure b) {
		brochure = b;
	}
}
