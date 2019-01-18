package com.afc.webSocket;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.gson.JsonObject;
import com.google.gson.internal.LinkedTreeMap;

public class Danbee {
	
	public String request(String sent, LinkedTreeMap<String, Object> map) throws Exception {
		
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
		job.addProperty("chatbot_id", map.get("chatbot_id") != null ? (String) map.get("chatbot_id") : "" );
		job.addProperty("input_sentence", sent);
		job.addProperty("user_id", map.get("user_id") != null ? (String) map.get("user_id") : "" );
		job.addProperty("ins_id", map.get("ins_id") != null ? (String) map.get("ins_id") : "" );
		job.addProperty("intent_id", map.get("intent_id") != null ? (String) map.get("intent_id") : "" );
		job.addProperty("node_id", map.get("node_id") != null ? (String) map.get("node_id") : "" );
		job.addProperty("param_id", map.get("param_id") != null ? (String) map.get("param_id") : "" );
		job.addProperty("chatflow_id", map.get("chatflow_id") != null ? (String) map.get("chatflow_id") : "" );
		if (map.get("session_id")!= null)
			job.addProperty("session_id", Long.parseLong((String)map.get("session_id")));
		// job.addProperty("parameters","");
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
			}
		}
		return response;
	}
	
	public String result(String response) {
		JSONParser jsonParser1 = new JSONParser();
		JSONObject jsonObject1;
		String message = null;
		
		try {
			jsonObject1 = (JSONObject) jsonParser1.parse(response);
			JSONObject  responseSet = ((JSONObject)(jsonObject1.get("responseSet") ))   ;
			JSONObject result = ((JSONObject)responseSet.get("result") );
			List list = ((List)result.get("result"));
			result = (JSONObject)list.get(0);
			
			message = (String)result.get("message");
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return message;
	}

	public LinkedTreeMap<String, Object> search(String response) {
		JSONParser jsonParser1 = new JSONParser();
		JSONObject jsonObject1;
		
		LinkedTreeMap<String, Object> map = new LinkedTreeMap<String, Object>();
		
		try {
			jsonObject1 = (JSONObject) jsonParser1.parse(response);
			
			JSONObject  responseSet = ((JSONObject)(jsonObject1.get("responseSet") ))   ;
			JSONObject result = ((JSONObject)responseSet.get("result") );
			//json ?��?��?�� 것을 출력?�� ?��?�� jsonObject, �? ?��?��?��것을뽑을?��
			//최상?�� 계층?�� Object �? ?��?�� 뽑는?��.
			//?��?���? Stting ?�� ?��?�� 강제 ?���??��?�� ?���??��.
			
			//결과�?  { } ?��?�� 경우  
			
			
			map.put("chatbot_id", (String) result.get("chatbot_id"));
			map.put("user_id", (String) result.get("user_id"));
			map.put("ins_id", (String) result.get("ins_id"));
			map.put("intent_id", (String) result.get("intent_id"));
			map.put("node_id", (String) result.get("node_id"));
			map.put("param_id", (String) result.get("param_id"));
			map.put("chatflow_id", (String) result.get("chatflow_id"));
			map.put("session_id", Long.toString((Long)result.get("session_id")));
			map.put("ref_intent_id", (String)result.get("ref_intent_id"));
			
			JSONObject parametersJson = (JSONObject)result.get("parameters");
			
			LinkedTreeMap<String, Object> parameters = new LinkedTreeMap<String, Object>();
			
			for(Object key : parametersJson.keySet()) {
				String sKey = (String)key;
				parameters.put(sKey, (String)parametersJson.get(sKey));
			}
			
			map.put("parameters", parameters);
			
			//결과�?  { } ?�� 경우
			//JSONObject aa = ((JSONObject)result.get("resultStatus") );
			
			//Object i2 = aa.get("resultCode");
			//System.out.println(i2);
			
		}catch(ParseException e) {
			e.printStackTrace();
		}
		
		return map;	
	}
}
