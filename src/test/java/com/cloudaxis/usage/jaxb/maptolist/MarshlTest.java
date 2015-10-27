/***************************************************************************
 *
 * This document contains confidential and proprietary information 
 * subject to non-disclosure agreements with CloudAxis. This 
 * information shall not be distributed or copied without written 
 * permission from the CloudAxis.
 *
 ***************************************************************************/

package com.cloudaxis.usage.jaxb.maptolist;

import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXBException;

import com.cloudaxis.jaxb.XMLParser;
import com.cloudaxis.usage.Common;

/***************************************************************************
 * <PRE>
 * 
 *  Creation Date   : 27 Oct, 2015
 * 
 *  Author          : keson
 * 
 *  Purpose         : TODO
 * 
 * 
 *  History         : TODO
 * 
 * </PRE>
 ***************************************************************************/
public class MarshlTest extends Common {
	public static void main(String[] args) throws JAXBException {
		Course course1 = new Course();
		course1.id = "001";
		course1.name = "chinese";
		course1.price = 1000d;

		Course course2 = new Course();
		course2.id = "002";
		course2.name = "English";
		course2.price = 2000d;

		Brochure brochure = new Brochure();
		Map<String, Course> courses = new HashMap<String, Course>();
		courses.put("Couse1", course1);
		courses.put("Couse2", course2);
		brochure.courses = courses;

		Training training = new Training();
		training.brochure = brochure;

		String result = XMLParser.marshal(training);
		System.out.println(result);
	}

}
