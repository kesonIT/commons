package com.cloudaxis.usage.jaxb.complexMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.OperationNotSupportedException;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.namespace.QName;

public class MapAdapter extends XmlAdapter<MapWrapper, Map<String, Object>> {
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

	@Override
	public Map<String, Object> unmarshal(MapWrapper v) throws Exception {
		throw new OperationNotSupportedException();
	}

}