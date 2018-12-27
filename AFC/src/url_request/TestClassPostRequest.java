package url_request; 

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Scanner;

import com.google.gson.JsonObject;

public class TestClassPostRequest {
	public static void main(String[] args) throws IOException {
		
		// Http요청 파라미터를 JSON으로 넘기기
		// ---------------------------------------
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
		job.addProperty("chatbot_id", "fefd2465-02bb-48fc-9bff-0592b6c7029d");
		job.addProperty("input_sentence", "펀드 환매");
		//job.addProperty("address", "seoul");

		os = conn.getOutputStream();
		os.write(job.toString().getBytes("UTF-8"));
		os.flush();

		// ---------------------------------------
		InputStream is = null;
		ByteArrayOutputStream baos = null;
		StringBuffer response = new StringBuffer();
		int responseCode = conn.getResponseCode();
		BufferedReader br ;
		System.out.println(responseCode);
		
		if (responseCode == HttpURLConnection.HTTP_OK) {
			is = conn.getInputStream();
			br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            String line ="";
			while((line = br.readLine())!=null){
            	response.append(line);
            }
 
 
			System.out.println(  response.toString() );
		}
		 
	}

}
