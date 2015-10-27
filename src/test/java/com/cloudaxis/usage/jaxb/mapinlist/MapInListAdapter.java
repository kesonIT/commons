package com.cloudaxis.usage.jaxb.mapinlist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class MapInListAdapter extends XmlAdapter<Object, List<Map<String, String>>> {

	@Override
	public Object marshal(List<Map<String, String>> rows) throws Exception {
		DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		Document document = builder.newDocument();
		Element nodeL1 = document.createElement("rows");

		for (Map<String, String> row : rows) {
			Element nodeL2 = document.createElement("row");

			Iterator<java.util.Map.Entry<String, String>> itera = row.entrySet().iterator();
			while (itera.hasNext()) {
				Entry<String, String> entry = itera.next();
				String key = entry.getKey();
				String value = entry.getValue();
				if (key == null || key.equals("")) {
					continue;
				}
				if (value == null) {
					value = "";
				}
				Element nodeL3 = document.createElement(key);
				nodeL3.setTextContent(value);
				nodeL2.appendChild(nodeL3);
			}
			nodeL1.appendChild(nodeL2);
		}
		document.appendChild(nodeL1);
		return nodeL1;
	}

	@Override
	public List<Map<String, String>> unmarshal(Object datas) throws Exception {
		// TODO Auto-generated method stub
		if (datas == null) {
			return null;
		}
		NodeList rowlist = ((Element) datas).getChildNodes();
		if (rowlist == null) {
			return null;
		}
		int rowCount = rowlist.getLength();
		if (rowCount == 0) {
			return null;
		}

		List<Map<String, String>> result = new ArrayList<Map<String, String>>();
		for (int i = 0; i < rowCount; i++) {
			Node rowNode = rowlist.item(i);
			if (!"detail".equals(rowNode.getNodeName())) {
				continue;
			}

			NodeList detailList = rowNode.getChildNodes();
			if (detailList == null) {
				continue;
			}
			int detailCount = detailList.getLength();
			if (detailCount == 0) {
				continue;
			}

			Map<String, String> detailMap = new HashMap<String, String>();
			for (int j = 0; j < detailCount; j++) {
				Node detailNode = detailList.item(j);
				String key = detailNode.getNodeName();
				String value = detailNode.getTextContent();
				if (key == null || "".equals(key)) {
					continue;
				}
				detailMap.put(key, value);
			}
			result.add(detailMap);
		}
		return result;
	}

}