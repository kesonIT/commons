/***************************************************************************
 *
 * This document contains confidential and proprietary information 
 * subject to non-disclosure agreements with CloudAxis. This 
 * information shall not be distributed or copied without written 
 * permission from the CloudAxis.
 *
 ***************************************************************************/

package com.cloudaxis.usage.jaxb.complexMap;

import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

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
@XmlRootElement
public class UserMap {

	Map<String, User> idUserMap = new HashMap<String, User>();

	// @XmlJavaTypeAdapter(UserMapAdapter.class)
	@XmlJavaTypeAdapter(MapAdapter.class)
	public Map<String, User> getIdUserMap() {
		return idUserMap;
	}

	// public void setUserMap(@XmlJavaTypeAdapter(UserMapAdapter.class) Map<String, User> users) {
	public void setUserMap(@XmlJavaTypeAdapter(MapAdapter.class) Map<String, User> users) {
		idUserMap = users;
	}

}
