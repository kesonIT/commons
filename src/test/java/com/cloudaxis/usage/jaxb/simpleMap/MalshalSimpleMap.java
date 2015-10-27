/***************************************************************************
 *
 * This document contains confidential and proprietary information 
 * subject to non-disclosure agreements with CloudAxis. This 
 * information shall not be distributed or copied without written 
 * permission from the CloudAxis.
 *
 ***************************************************************************/

package com.cloudaxis.usage.jaxb.simpleMap;

import java.io.File;

import javax.xml.bind.JAXBException;

import com.cloudaxis.jaxb.XMLParser;
import com.cloudaxis.usage.Common;
import com.cloudaxis.usage.jaxb.complexMap.User;
import com.cloudaxis.usage.jaxb.complexMap.UserMap;

/***************************************************************************
 * <PRE>
 * 
 *  Creation Date   : 26 Oct, 2015
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
public class MalshalSimpleMap extends Common {

	public static void main(String[] args) throws JAXBException {
		new MalshalSimpleMap().run();
	}

	public void run() throws JAXBException {

		LOGGER.info("run Malshller for map");
		SimpleMap simpleMap = new SimpleMap();

		simpleMap.getMap().put("10000", "Keson");

		simpleMap.getMap().put("10001", "Steven");

		simpleMap.getMap().put("10002", "Uwen");

		File xmlFile = new File("src/test/java/com/cloudaxis/usage/output/SimpleMap.xml");
		XMLParser.marshal(simpleMap, xmlFile);
	}

}
