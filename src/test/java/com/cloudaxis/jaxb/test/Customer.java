/***************************************************************************
 *
 * This document contains confidential and proprietary information 
 * subject to non-disclosure agreements with CloudAxis. This 
 * information shall not be distributed or copied without written 
 * permission from the CloudAxis.
 *
 ***************************************************************************/

package com.cloudaxis.jaxb.test;

/***************************************************************************
 *<PRE>
 * 
 *  Creation Date   : Oct 22, 2015
 * 
 *  Author          : steven
 * 
 *  Purpose         : TODO
 * 
 * 
 *  History         : TODO
 * 
 *</PRE>
 ***************************************************************************/
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Customer")
public class Customer {
	@XmlElement
	String name;
	@XmlElement
	int age;
	@XmlElement
	int id;

}
