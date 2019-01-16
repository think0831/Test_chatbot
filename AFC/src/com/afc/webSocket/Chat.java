package com.afc.webSocket;

import java.io.IOException;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import com.afc.util.MessageBuffer;
import com.google.gson.internal.LinkedTreeMap;

@ServerEndpoint("/chat")
public class Chat {
	
	private final static String yChatBot = "fefd2465-02bb-48fc-9bff-0592b6c7029d";
	private final static String jChatBot = "6b7703c0-7ce1-48f5-b60b-3719c9cd8c76";
	private Session client;
	private Danbee danbee;
	private LinkedTreeMap<String, Object> map;
	private MessageBuffer messageBuffer;

	@OnMessage
	public void onMessage(String message, Session session) throws Exception {
		
		messageBuffer.put(message);
		System.out.println(messageBuffer.toString());
		
		String response = danbee.request(message, map);
		map = danbee.search(response);
		
		System.out.println(map.get("ref_intent_id"));
		
		if(((String)map.get("ref_intent_id")).contains("펀드가입상담")) {
			client.getBasicRemote().sendText(danbee.result(response) + ";" + map.get("node_id"));
		} else if(((String)map.get("ref_intent_id")).contains("펀드해지상담")) {
			client.getBasicRemote().sendText(danbee.result(response) + ";" + map.get("node_id"));
		} else if(((String)map.get("ref_intent_id")).contains("펀드 가입")) {
			client.getBasicRemote().sendText(danbee.result(response) + ";join");
		} else if(((String)map.get("ref_intent_id")).contains("펀드 해지")) {
			client.getBasicRemote().sendText(danbee.result(response) + ";" + map.get("node_id"));
		} else if(((String)map.get("ref_intent_id")).contains("과일")) {
			client.getBasicRemote().sendText(danbee.result(response) + ";" + map.get("node_id"));
		} else if(((String)map.get("ref_intent_id")).contains("question")) {
			client.getBasicRemote().sendText(danbee.result(response) + ";" + map.get("node_id"));
		} else {
			//client.getBasicRemote().sendText("+++++"+message);
			client.getBasicRemote().sendText(danbee.result(response) + ";" + map.get("node_id"));
		}
		
	}

	@OnOpen
	public void onOpen(Session session) {
		// Add session to the connected sessions set
		System.out.println(session);
		client = session;
		messageBuffer = new MessageBuffer();
		
		danbee = new Danbee();
		map = new LinkedTreeMap<String, Object>();
		map.put("chatbot_id", jChatBot);
	}

	@OnClose
	public void onClose(Session session) {
		// Remove session from the connected sessions set
		try {
			client.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String fundAdvice() {
		
		return null;
	}
	
	public String fundInfo() {
		
		return null;
	}
}