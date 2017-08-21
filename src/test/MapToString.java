package test;

import java.util.HashMap;
import java.util.Map;


public class MapToString {
	public void mapTo(Map map){
	}
	public static void main(String[] args) {
		Map<String,String> map = new HashMap<String,String>();
		map = null;
		new MapToString().mapTo(map);
	}

}
