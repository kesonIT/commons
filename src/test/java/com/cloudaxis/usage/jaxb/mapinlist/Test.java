/***************************************************************************
 *
 * This document contains confidential and proprietary information 
 * subject to non-disclosure agreements with CloudAxis. This 
 * information shall not be distributed or copied without written 
 * permission from the CloudAxis.
 *
 ***************************************************************************/

package com.cloudaxis.usage.jaxb.mapinlist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
public class Test extends Common {

	public static void main(String[] args) throws JAXBException {
		new Test().run();
	}

	private void run() throws JAXBException {

		List<Map<String, String>> mapList = new ArrayList<Map<String, String>>();

		Map<String, String> generalInfo = new HashMap<String, String>();
		generalInfo.put("id", "10010");
		generalInfo.put("name", "Keson");
		generalInfo.put("Title", "Software engineer");

		Map<String, String> skills = new HashMap<String, String>();
		skills.put("Phostoshop", "Good");
		skills.put("Javascript", "Good");
		skills.put("WebService", "Good");
		// skills.put("Web Service", "Good"); //EXCEPTION
		skills.put("SQL", "Very good");

		mapList.add(generalInfo);
		mapList.add(skills);

		MapInList mapInList = new MapInList();
		mapInList.setMapList(mapList);

		String result = XMLParser.marshal(mapInList);
		System.out.println(result);
	}

}
