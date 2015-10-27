package com.cloudaxis.usage.jaxb.xmlSchemaType;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement
public class TextType {
	@XmlElement
	@XmlSchemaType(name = "strbuf")
	@XmlJavaTypeAdapter(String2StrBufAdaptor.class)
	public StringBuffer strbuf;
}
