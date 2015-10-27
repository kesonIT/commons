package com.cloudaxis.usage.jaxb.complexMap;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class UserMapAdapter extends XmlAdapter<MapEntity, Map> {

	@Override
	public MapEntity marshal(Map map) throws Exception {
		// TODO Auto-generated method stub
		String mapValueType = getMapValueType(map);

		MapEntity parent = new MapEntity();
		MapEntity[] children = new MapEntity[map.size()];
		parent.key = mapValueType + "s";
		parent.value = children;

		Set<String> keyset = map.keySet();
		int index = 0;
		for (Iterator<String> itor = keyset.iterator(); itor.hasNext();) {
			User user = (User) map.get(itor.next());

			MapEntity[] userDetail = new MapEntity[2];

			MapEntity id = new MapEntity();
			id.key = "id";
			id.value = user.getId();
			userDetail[0] = id;

			MapEntity name = new MapEntity();
			name.key = "name";
			name.value = user.getName();
			userDetail[1] = name;

			MapEntity child = new MapEntity();
			child.key = mapValueType;
			child.value = userDetail;

			children[index++] = child;
		}
		return parent;
	}

	/*
	 * @Override public MapEntity marshal(Map map) throws Exception { // TODO Auto-generated method stub String
	 * mapValueType = getMapValueType(map);
	 * 
	 * MapEntity parent = new MapEntity(); MapEntity[] children = new MapEntity[map.size()]; parent.key =
	 * mapValueType+"s"; parent.value = children;
	 * 
	 * Set<String> keyset = map.keySet(); int index =0; for(Iterator<String> itor=keyset.iterator();itor.hasNext();){
	 * User user = (User)map.get(itor.next());
	 * 
	 * 
	 * 
	 * MapEntity[] userDetail = new MapEntity[2];
	 * 
	 * MapEntity id = new MapEntity(); id.key="id"; id.value=user.getId(); userDetail[0] = id;
	 * 
	 * MapEntity name = new MapEntity(); name.key="name"; name.value=user.getName(); userDetail[1] = name;
	 * 
	 * MapEntity child = new MapEntity(); child.key = mapValueType; child.value = userDetail;
	 * 
	 * children[index++] = child; } return parent; }
	 */
	/*
	 * @Override public Map unmarshal(MapEntity[] list) throws Exception { // TODO Auto-generated method stub Map map =
	 * new HashMap(); for(int i=0;i<list.length;i++){ MapEntity item = list[i]; map.put(item.key, item.value); }
	 * 
	 * return map; }
	 */

	public String getMapValueType(Map<String, ?> map) {
		if (map == null || map.size() == 0) {
			return null;
		}
		String key = map.keySet().iterator().next();
		String type = map.get(key).getClass().getSimpleName();
		return type;
	}

	@Override
	public Map<String, User> unmarshal(MapEntity v) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}