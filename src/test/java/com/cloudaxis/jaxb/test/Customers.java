/***************************************************************************
 *
 * This document contains confidential and proprietary information 
 * subject to non-disclosure agreements with CloudAxis. This 
 * information shall not be distributed or copied without written 
 * permission from the CloudAxis.
 *
 ***************************************************************************/

package com.cloudaxis.jaxb.test;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/***************************************************************************
 * <PRE>
 * 
 *  Creation Date   : Oct 23, 2015
 * 
 *  Author          : steven
 * 
 *  Purpose         : TODO
 * 
 * 
 *  History         : TODO
 * 
 * </PRE>
 ***************************************************************************/
@XmlRootElement(name = "customers")
public class Customers {
	@XmlElement
	List<Customer> customer;

}
