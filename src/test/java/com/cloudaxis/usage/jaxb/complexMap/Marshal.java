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
public class Marshal extends Common {

	public static void main(String[] args) throws JAXBException {
		new Marshal().run();
	}

	public void run() throws JAXBException {
		User user = new User();
		user.setId(10086);
		user.setName("Keson");
		File file = new File("src/test/java/com/cloudaxis/usage/output/User.xml");
		LOGGER.info("Marshal object " + user.getClass().getName() + " to file " + file);
		XMLParser.marshal(user, file);
	}

}
