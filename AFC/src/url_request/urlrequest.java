package url_request;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Map;



public class urlrequest {
	public static void main(String[] args) throws Exception {
		URL danbee = new URL("https://danbee.ai/chatflow/engine.do");
		Map<String, Object> map = new LinkedHashMap<>();
		map.put("chatbotId", "fefd2465-02bb-48fc-9bff-0592b6c7029d");
		
		StringBuilder postData = new StringBuilder();
		for (Map.Entry<String,Object> maps : map.entrySet()) {
			if(postData.length() != 0) postData.append('&');
			postData.append(URLEncoder.encode(maps.getKey(), "UTF-8"));
			postData.append('=');
			postData.append(URLEncoder.encode(String.valueOf(maps.getValue()), "UTF-8"));
		}
		byte[] postDataBytes = postData.toString().getBytes("UTF-8");
		
				
		HttpURLConnection http = (HttpURLConnection)danbee.openConnection();	
		http.setRequestMethod("POST");
		http.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
		http.setRequestProperty("chatbot_id",  "fefd2465-02bb-48fc-9bff-0592b6c7029d");
		http.setDoOutput(true);
		http.getOutputStream().write(postDataBytes);
		
		BufferedReader in = new BufferedReader(
				new InputStreamReader(http.getInputStream()));
		String inputLine;
		
		while((inputLine = in.readLine()) !=null)
			System.out.println(inputLine);
		in.close();
	}

}
