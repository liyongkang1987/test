package test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Demo9 {

	public static void main(String[] args) {

		Set<String> set = new HashSet<String>();
		set.add("aaa");
		set.add("bbb");
		set.add("ccc");
		set.add("ddd");
		set.add("eee");
		System.out.println(set);
		String[] xx = new String[set.size()];
		set.toArray(xx);
		System.out.println(Arrays.toString(xx));
	}

	public static String truncat(String str, int len) {
		if (str.length() > len) {
			str = str.substring(0, len);
		}
		return str;
	}

}
