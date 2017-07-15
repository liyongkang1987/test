package test;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.yonyou.iuap.event.BusinessEvent;

//import net.sf.json.JSONObject;

public class Demo8 {

	public static void main(String[] args) {

		BusinessEvent businessEvent = new BusinessEvent("USER", "ADD_AFTER", null);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("tenantId", "lnald25w");
		map.put("duration", 90);
		map.put("orderType", 1);
		map.put("buyTime", "2016-07-13 09:53:37");
		map.put("userId", "566e9d45-3743-47c6-8dfb-bbe86e0eab08");
		map.put("resCode", "boss");
		map.put("endDate", "2016-10-11 09:53:37");
		map.put("resId", 10);
		map.put("tenantCode", "asdas123");
		businessEvent.setUserObject(JSONObject.parseObject(map.toString()));
		System.out.println(businessEvent);

	}

}
