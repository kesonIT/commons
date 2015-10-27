/***************************************************************************
 *
 * This document contains confidential and proprietary information 
 * subject to non-disclosure agreements with CloudAxis. This 
 * information shall not be distributed or copied without written 
 * permission from the CloudAxis.
 *
 ***************************************************************************/

package com.cloudaxis.usage.jaxb.complexMap;

import java.io.File;

import javax.xml.bind.JAXBException;

import com.cloudaxis.jaxb.XMLParser;
import com.cloudaxis.usage.Common;

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
public class Test extends Common {

	public static void main(String[] args) throws JAXBException {
		new Test().run();
	}

	public void run() throws JAXBException {

		LOGGER.info("run Malshller for map");
		UserMap userInfo = new UserMap();

		User user1 = new User();
		user1.setId(10000);
		user1.setName("Keson");
		userInfo.getIdUserMap().put("10000", user1);

		User user2 = new User();
		user2.setId(10001);
		user2.setName("Steven");
		userInfo.getIdUserMap().put("10001", user2);

		User user3 = new User();
		user3.setId(10002);
		user3.setName("Uwen");
		userInfo.getIdUserMap().put("10002", user3);

		File xmlFile = new File("src/test/java/com/cloudaxis/usage/output/UserMap.xml");
		XMLParser.marshal(userInfo, xmlFile);

		String result = XMLParser.marshal(userInfo);
		System.out.println(result);
	}

}
