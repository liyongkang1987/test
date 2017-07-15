package test;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Demo2 {

	private static final Set<String> EXCLUDE_PARAM_KEY = new HashSet() {
	};

	public static void main(String[] args) throws MalformedURLException {

		String queryPath = "http://localhost:8080/event/eventmanager/sendEventMsg.do?aa=123&bb=234";
		URL url = new URL(queryPath);
		String requestPath = url.getPath();
		requestPath = requestPath.endsWith("/") ? requestPath.substring(0, requestPath.length() - 1) : requestPath;
		System.out.println("url.getHost():	" + url.getHost());
		System.out.println("url.getProtocol():	" + url.getProtocol());
		System.out.println("url.getPort():	" + url.getPort());
		System.out.println("url.getQuery():	" + url.getQuery());
		System.out.println("url.getFile():	" + url.getFile());
		System.out.println("url.getUserInfo():	" + url.getUserInfo());
		System.out.println("url.getPath():	" + url.getPath());
		System.out.println(requestPath);

		LinkedHashMap<String, String> queryMap = createQueryMap(url.getQuery());
		System.out.println(queryMap);
		String queryString = assembleQueryString(queryMap);
		System.out.println(queryString);

	}

	public static LinkedHashMap<String, String> createQueryMap(String queryString) {
		LinkedHashMap<String, String> queryMap = new LinkedHashMap();
		if (queryString != null && queryString.length() > 0) {
			String[] queryParams = queryString.split("&");
			for (String queryParam : queryParams) {
				String[] queryEntry = queryParam.split("=");
				if (queryEntry.length == 2) {

					if (!EXCLUDE_PARAM_KEY.contains(queryEntry[0]))
						try {
							queryMap.put(queryEntry[0], URLDecoder.decode(queryEntry[1], "UTF-8"));
						} catch (UnsupportedEncodingException e) {

						}
				}
			}
		}
		return queryMap;
	}

	public static String assembleQueryString(LinkedHashMap<String, String> queryMap) {
		List<String> queryList = new ArrayList();
		for (Map.Entry<String, String> entry : queryMap.entrySet()) {
			queryList.add((String) entry.getKey() + (String) entry.getValue());
		}
		String[] queryTable = (String[]) queryList.toArray(new String[0]);
		Arrays.sort(queryTable);
		StringBuffer buffer = new StringBuffer();
		for (String queryElement : queryList) {
			buffer.append(queryElement);
		}
		return buffer.toString();
	}
}
