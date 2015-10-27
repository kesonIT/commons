/***************************************************************************
 *
 * This document contains confidential and proprietary information 
 * subject to non-disclosure agreements with CloudAxis. This 
 * information shall not be distributed or copied without written 
 * permission from the CloudAxis.
 *
 ***************************************************************************/

package com.cloudaxis.jaxb;

import static com.cloudaxis.helper.LogHelper.getExceptionDetail;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/***************************************************************************
 * <PRE>
 * 
 *  Creation Date   : Oct 22, 2015
 * 
 *  Author          : steven
 * 
 *  Purpose         : XML parser
 * 
 * 
 *  History         : first
 * 
 * </PRE>
 ***************************************************************************/
public final class XMLParser {
	private static final Logger LOGGER = LoggerFactory.getLogger(XMLParser.class);

	private XMLParser() {
	}

	/**
	 * @param xml
	 * @param clazz
	 * @return unmarshal the String xml to Object
	 * @throws JAXBException
	 */
	public static Object unmarshal(String xml, Class<?> clazz) throws JAXBException {
		try {
			StringReader reader = new StringReader(xml);
			return getUnmarshaller(clazz).unmarshal(reader);
		} catch (JAXBException e) {
			LOGGER.error(getExceptionDetail("Failed to unmarshal file %s", e, xml));
			throw e;
		}
	}

	/**
	 * @param file
	 * @param clazz
	 * @return unmarshal the XML File to Object
	 * @throws FileNotFoundException
	 * @throws JAXBException
	 */
	public static Object unmarshal(File file, Class<?> clazz) throws FileNotFoundException, JAXBException {
		try {
			FileInputStream xml = new FileInputStream(file);
			return getUnmarshaller(clazz).unmarshal(xml);
		} catch (FileNotFoundException e) {
			LOGGER.error(getExceptionDetail("File %s not exist", e, file.getAbsoluteFile()));
			throw e;
		} catch (JAXBException e) {
			LOGGER.error(getExceptionDetail("Failed to unmarshal file %s", e, file.getAbsolutePath()));
			throw e;
		}
	}

	/**
	 * @param object
	 * @param file
	 * @return marshal Object to XML File
	 * @throws JAXBException
	 */
	public static boolean marshal(Object object, File file) throws JAXBException {
		try {
			getMarshaller(object).marshal(object, file);
			return true;
		} catch (JAXBException e) {
			LOGGER.error(getExceptionDetail("Failed to marshal object %s to file %s", e, object.getClass().getName(),
					file.getAbsolutePath()));
			throw e;
		}
	}

	/**
	 * @param object
	 * @return marshal Object to XML String
	 * @throws JAXBException
	 */
	public static String marshal(Object object) throws JAXBException {
		try {
			StringWriter writer = new StringWriter();
			getMarshaller(object).marshal(object, writer);
			return writer.toString();
		} catch (JAXBException e) {
			throw e;
		}
	}

	/**
	 * Get unmarshaller
	 * 
	 * @param clazz
	 * @return
	 * @throws JAXBException
	 */
	private static Unmarshaller getUnmarshaller(Class<?> clazz) throws JAXBException {
		return JAXBContext.newInstance(clazz).createUnmarshaller();
	}

	/**
	 * Get marshaller
	 * 
	 * @param object
	 * @return
	 * @throws JAXBException
	 */
	private static Marshaller getMarshaller(Object object) throws JAXBException {
		JAXBContext jc = JAXBContext.newInstance(object.getClass(), com.cloudaxis.usage.jaxb.complexMap.User.class,
				com.cloudaxis.usage.jaxb.complexMap.MapEntity.class, ArrayList.class);
		Marshaller marshaller = jc.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		return marshaller;
	}
}
