package test;

import java.util.Arrays;

public class Demo7 {

	public static void main(String[] args) {

		byte[] bt = new byte[10];
		for (int i = 0; i < 10; i++) {
			bt[i] = (byte) i;
		}
		System.out.println(Arrays.toString(bt));
		String btStr = new String(bt);
		System.out.println(btStr);

		String h = "hello";
		byte[] bt2 = h.getBytes();
		System.out.println(Arrays.toString(bt2));
		String h2 = new String(bt2);
		System.out.println(h2);
	}

}
