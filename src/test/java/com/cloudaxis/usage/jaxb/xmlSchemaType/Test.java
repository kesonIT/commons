/***************************************************************************
 *
 * This document contains confidential and proprietary information 
 * subject to non-disclosure agreements with CloudAxis. This 
 * information shall not be distributed or copied without written 
 * permission from the CloudAxis.
 *
 ***************************************************************************/

package com.cloudaxis.usage.jaxb.xmlSchemaType;

import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlRootElement;

import com.cloudaxis.jaxb.XMLParser;

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
public class Test {
	public static void main(String[] args) throws JAXBException {
		TextType text = new TextType();
		text.strbuf = new StringBuffer("This is the house");
		text.strbuf.append(" that Jack built.");

		String result = XMLParser.marshal(text);
		System.out.println(result);
	}

}
