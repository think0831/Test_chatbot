package url_request;

import java.util.Scanner;

import com.google.gson.internal.LinkedTreeMap;

public class Main_func {
	public static void main(String[] args) throws Exception {
		search_request request = new search_request();
		

		
		LinkedTreeMap<String, String> map = new LinkedTreeMap<String, String>();
		map.put("chatbot_id", "fefd2465-02bb-48fc-9bff-0592b6c7029d");
		String response = request.request("펀드 환매", map);

		
		LinkedTreeMap<String, String> map2 = request.search(response);
		request.request("전체 환매", map2);
	}

}
