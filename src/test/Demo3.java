package test;

import java.util.HashMap;
import java.util.Map;

public class Demo3 {

	public static void main(String[] args) {

		Map<String, String> map = new HashMap<String, String>();
		map.put("aaa", "111");
		map.put("bbb", "222");
		map.put("ccc", "333");
		map.put("ddd", "444");
		map.put("eee", "555");

		System.out.println(map);
		Map<String, String> map2 = new HashMap<String, String>();
		map2.putAll(map);
		map2.remove("ccc");

		System.out.println(map2);
		System.out.println(map);

	}

}
