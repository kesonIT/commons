package com.cloudaxis.usage.jaxb.maptolist;

import java.util.Collection;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class BrochureAdapter extends XmlAdapter<Courses, Brochure> {
	@Override
	public Brochure unmarshal(Courses value) {
		Brochure b = new Brochure();
		for (Course c : value.carray)
			b.courses.put(c.id, c);
		return b;
	}

	@Override
	public Courses marshal(Brochure b) {
		Courses courses = new Courses();
		Collection<Course> c = b.courses.values();
		courses.carray = c.toArray(new Course[c.size()]);
		return courses;
	}
}