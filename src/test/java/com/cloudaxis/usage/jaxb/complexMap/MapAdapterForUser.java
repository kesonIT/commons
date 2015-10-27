package com.cloudaxis.usage.jaxb.complexMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.OperationNotSupportedException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.namespace.QName;

import ch.qos.logback.core.joran.action.NewRuleAction;

public class MapAdapterForUser extends XmlAdapter<MapWrapper, Map<String, Object>> {
	@Override
	public MapWrapper marshal(Map<String, Object> m) throws Exception {
		MapWrapper wrapper = new MapWrapper();
		List elements = new ArrayList();
		for (Map.Entry<String, Object> property : m.entrySet()) {

			User user = null;
			Object object = property.getValue();
			if (object instanceof User) {
				user = (User) object;
			}

			if (user != null) {
				System.err.println("1");
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("id", user.getId() + "");
				map.put("name", user.getName());

				elements.add(new JAXBElement<MapWrapper>(new QName("User"), MapWrapper.class, marshal(map)));
			} else {
				System.err.println(22);
				for (Map.Entry<String, Object> prop : m.entrySet()) {
					JAXBElement<String> ele = new JAXBElement<String>(new QName(prop.getKey()), String.class,
							String.valueOf(prop.getValue()));
					elements.add(ele);
				}
				break;
			}

		}
		wrapper.elements = elements;
		return wrapper;
	}

	public MapWrapper marshal_forUser(Map<String, Object> m) throws Exception {
		MapWrapper wrapper = new MapWrapper();
		List elements = new ArrayList();
		for (Map.Entry<String, Object> property : m.entrySet()) {

			User user = null;
			Object object = property.getValue();
			if (object instanceof User) {
				user = (User) object;
			}

			if (user != null) {
				System.err.println("1");
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("id", user.getId() + "");
				map.put("name", user.getName());

				elements.add(new JAXBElement<MapWrapper>(new QName("User"), MapWrapper.class, marshal(map)));
			} else {
				System.err.println(22);
				for (Map.Entry<String, Object> prop : m.entrySet()) {
					JAXBElement<String> ele = new JAXBElement<String>(new QName(prop.getKey()), String.class,
							String.valueOf(prop.getValue()));
					elements.add(ele);
				}
				break;
			}

		}
		wrapper.elements = elements;
		return wrapper;
	}

	// @Override
	public MapWrapper marshal_bak(Map<String, Object> m) throws Exception {
		MapWrapper wrapper = new MapWrapper();
		List elements = new ArrayList();
		for (Map.Entry<String, Object> property : m.entrySet()) {

			if (property.getValue() instanceof Map)
				elements.add(new JAXBElement<MapWrapper>(new QName(getCleanLabel(property.getKey())), MapWrapper.class,
						marshal((Map) property.getValue())));
			else {
				User user = (User) property.getValue();
				JAXBElement<String> element1 = new JAXBElement<String>(new QName("Id"), String.class, user.getId() + "");
				JAXBElement<String> element2 = new JAXBElement<String>(new QName("name"), String.class, user.getName()
						+ "");

				elements.add(element1);
				elements.add(element2);
			}
		}
		wrapper.elements = elements;
		return wrapper;
	}

	@Override
	public Map<String, Object> unmarshal(MapWrapper v) throws Exception {
		// TODO
		throw new OperationNotSupportedException();
	}

	// Return a XML-safe attribute. Might want to add camel case support
	private String getCleanLabel(String attributeLabel) {
		attributeLabel = attributeLabel.replaceAll("[()]", "").replaceAll("[^\\w\\s]", "_").replaceAll(" ", "_");
		return attributeLabel;
	}
}