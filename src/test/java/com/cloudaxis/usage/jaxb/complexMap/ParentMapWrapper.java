package com.cloudaxis.usage.jaxb.complexMap;

import java.util.List;

import javax.xml.bind.annotation.XmlAnyElement;

class ParentMapWrapper {
	@XmlAnyElement
	List elements;
}