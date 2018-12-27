package url_request;

import java.awt.List;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.gson.JsonObject;
import com.google.gson.internal.LinkedTreeMap;

public class search_request {
	public String request(String sent, LinkedTreeMap<String, String> map) throws Exception {
		
		URL url = new URL("https://danbee.ai/chatflow/engine.do");
		HttpURLConnection conn = null;
		OutputStream os = null;
		conn = (HttpURLConnection) url.openConnection();
		conn.setConnectTimeout(1000);
		conn.setReadTimeout(1000);
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Cache-Control", "no-cache");
		conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
		conn.setRequestProperty("Accept", "application/json;charset=UTF-8");
		conn.setDoOutput(true);
		conn.setDoInput(true);

		JsonObject job = new JsonObject();
		job.addProperty("chatbot_id", map.get("chatbot_id") != null ? map.get("chatbot_id") : "" );
		job.addProperty("input_sentence", sent);
		job.addProperty("user_id", map.get("user_id") != null ? map.get("user_id") : "" );
		job.addProperty("ins_id", map.get("ins_id") != null ? map.get("ins_id") : "" );
		job.addProperty("intent_id", map.get("intent_id") != null ? map.get("intent_id") : "" );
		job.addProperty("node_id", map.get("node_id") != null ? map.get("node_id") : "" );
		job.addProperty("param_id", map.get("param_id") != null ? map.get("param_id") : "" );
		job.addProperty("chatflow_id", map.get("chatflow_id") != null ? map.get("chatflow_id") : "" );
		if (map.get("session_id")!= null)
			job.addProperty("session_id", Long.parseLong((String)map.get("session_id")));
		// job.addProperty("parameters","");
		System.out.println(job.get("input_sentence"));
		os = conn.getOutputStream();
		os.write(job.toString().getBytes("UTF-8"));
		os.flush();
		os.close();

		// ---------------------------------------
		InputStream is = null;
		ByteArrayOutputStream baos = null;
		String response = new String();
		int responseCode = conn.getResponseCode();
		BufferedReader br;
		System.out.println(responseCode);

		if (responseCode == HttpURLConnection.HTTP_OK) {
			is = conn.getInputStream();
			br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			String line = "";
			while ((line = br.readLine()) != null) {
				response = line;
				System.out.println(response);
			}
		}
		return response;
	}

	public LinkedTreeMap<String, String> search(String response) {
		System.out.println(response.getClass());
		JSONParser jsonParser1 = new JSONParser();
		JSONObject jsonObject1;
		String ins_id = null;
		
		
		LinkedTreeMap<String, String> map = new LinkedTreeMap<String, String>();
		
		try {
			jsonObject1 = (JSONObject) jsonParser1.parse(response);
			
			JSONObject  responseSet = ((JSONObject)(jsonObject1.get("responseSet") ))   ;
			JSONObject result = ((JSONObject)responseSet.get("result") );
			//json 형식의 것을 출력할 때는 jsonObject, 그 이외의것을뽑을때
			//최상위 계층인 Object 를 써서 뽑는다.
			//아니면 Stting 을 쓰되 강제 형변환을 해준다.
			
			//결과가  { } 아닌 경우  
			ins_id =  (String) result.get("ins_id") ;
			
			
			map.put("chatbot_id", (String) result.get("chatbot_id"));
			map.put("user_id", (String) result.get("user_id"));
			map.put("ins_id", (String) result.get("ins_id"));
			map.put("intent_id", (String) result.get("intent_id"));
			map.put("node_id", (String) result.get("node_id"));
			map.put("param_id", (String) result.get("param_id"));
			map.put("chatflow_id", (String) result.get("chatflow_id"));
			map.put("session_id", Long.toString((Long)result.get("session_id")));
			//결과가  { } 인 경우
			//JSONObject aa = ((JSONObject)result.get("resultStatus") );
			
			//Object i2 = aa.get("resultCode");
			//System.out.println(i2);
			
		}catch(ParseException e) {
			e.printStackTrace();
		}
		
		return map;	
	}
}