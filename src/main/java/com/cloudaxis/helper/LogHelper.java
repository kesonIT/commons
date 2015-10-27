/***************************************************************************
 *
 * This document contains confidential and proprietary information 
 * subject to non-disclosure agreements with CloudAxis. This 
 * information shall not be distributed or copied without written 
 * permission from the CloudAxis.
 *
 ***************************************************************************/

package com.cloudaxis.helper;

import com.google.common.base.Throwables;

/***************************************************************************
 * <PRE>
 * 
 *  Creation Date   : 26 Oct, 2015
 * 
 *  Author          : keson
 * 
 *  Purpose         : Helper for Logger
 * 
 * 
 *  History         : TODO
 * 
 * </PRE>
 ***************************************************************************/
public class LogHelper {
	public static String getExceptionDetail(String summary, Exception e, Object... args) {
		summary = String.format(summary, args);
		String details = ", exception detail:" + Throwables.getStackTraceAsString(e);
		return summary + details;
	}

}
