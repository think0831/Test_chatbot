import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class Foo {
    public static void main(String[] args) throws Exception {
    	Foo test = new Foo();
    	test.postRequest();
    }
    
    public void postRequest() throws Exception {
    	URL url = new URL("https://danbee.ai/chatflow/engine.do");
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
        conn.setDoOutput(true);
        
        byte[] data = makeJson("6b7703c0-7ce1-48f5-b60b-3719c9cd8c76", "ÆÝµå°¡¹¹¾ß");
        
        OutputStream out = conn.getOutputStream();
        
        out.write(data);
        
        System.out.println(conn.getResponseCode());
        
        Thread.sleep(1000);
        
        Reader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));

        for (int c; (c = in.read()) >= 0;)
            System.out.print((char)c);
    }
    
    public byte[] makeJson(String botId, String sent) throws UnsupportedEncodingException {
    	Gson gson = new Gson();
    	
    	Map<String, String> map = new HashMap<>();
    	map.put("chatbot_id", botId);
    	map.put("input_sentence", sent);
    	
    	gson.toJson(map);
    	JsonObject jsonObject = new JsonObject();
    	jsonObject.addProperty("chatbot_id", botId);
    	jsonObject.addProperty("input_sentence", sent);
    	jsonObject.addProperty("chatbot_id", botId);
    	jsonObject.addProperty("input_sentence", sent);
    	jsonObject.addProperty("chatbot_id", botId);
    	jsonObject.addProperty("input_sentence", sent);
    	
    	System.out.println(jsonObject.toString());
    	
    	return jsonObject.toString().getBytes("UTF-8");
    }
}