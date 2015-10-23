/***************************************************************************
 *
 * This document contains confidential and proprietary information 
 * subject to non-disclosure agreements with CloudAxis. This 
 * information shall not be distributed or copied without written 
 * permission from the CloudAxis.
 *
 ***************************************************************************/

package com.cloudaxis.jaxb;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;  
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
public final class XMLParser {
	private XMLParser() {}  
    
	 public static Object unmarshal(String str, Class<?> clazz) {  
	        Object obj = null;  
	        try{
	        	JAXBContext jc = JAXBContext.newInstance(clazz);
	        	 StringReader reader = new StringReader(str);  
	        	 obj = jc.createUnmarshaller().unmarshal(reader);  
	        } catch (JAXBException e) {  
	            throw new RuntimeException("Can't unmarshal the XML file, error message: " + e.getMessage());  
	        }  
	        return obj;  
	    }  
   
	public static Object unmarshal(File file, Class<?> clazz) {  
        Object obj = null;  
        try {  
        	FileInputStream xml = null;
			try {
				xml = new FileInputStream(file);
			} catch (FileNotFoundException e) {
				 throw new RuntimeException("Can't unmarshal the XML file, error message: " + e.getMessage()); 
			}
            JAXBContext jc = JAXBContext.newInstance(clazz);  
            Unmarshaller u = jc.createUnmarshaller();  
            obj = u.unmarshal(xml);  
        } catch (JAXBException e) {  
            throw new RuntimeException("Can't unmarshal the XML file, error message: " + e.getMessage());  
        }  
        return obj;  
    }  
      
   
    public static boolean marshal(Object obj, Class<?> clazz,File file) {  
        try {  
            JAXBContext jc = JAXBContext.newInstance(clazz);  
	        Marshaller m = jc.createMarshaller();  
	        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            m.marshal(obj, file);
        } catch (JAXBException e) {  
            throw new RuntimeException("Can't marshal the XML file, error message: " + e.getMessage());  
        }  
        return true;  
    }  
    
    public static String marshal(Object obj, Class<?> clazz) {  
        String result = null;  
        try {  
            JAXBContext jc = JAXBContext.newInstance(clazz);  
	        Marshaller m = jc.createMarshaller();  
	        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            StringWriter writer = new StringWriter();  
            m.marshal(obj, writer);  
            result = writer.toString();  
        } catch (JAXBException e) {  
            throw new RuntimeException("Can't marshal the XML file, error message: " + e.getMessage());  
        }  
        return result;  
    }  
}
