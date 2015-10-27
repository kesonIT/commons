package com.cloudaxis.usage.jaxb.xmlSchemaType;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class String2StrBufAdaptor extends XmlAdapter<String, StringBuffer> {
	@Override
	public String marshal(StringBuffer strbuf) {
		return strbuf.toString();
	}

	@Override
	public StringBuffer unmarshal(String string) {
		return new StringBuffer(string);
	}
}