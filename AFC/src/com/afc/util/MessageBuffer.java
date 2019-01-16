package com.afc.util;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MessageBuffer {
	
	private LinkedList<String> messageList;
	private final static int MAX = 10;
	
    public MessageBuffer() {
    	this.messageList = new LinkedList<String>();
    }
    
    public void put(String message) {
    	if(messageList.size() >= MAX) {
    		messageList.removeFirst();
    	}
    	
    	messageList.addLast(message);
    }
    
    public String pop(int n) {
    	return messageList.getLast();
    }
    
    public List<String> getMany(int n) {
    	List<String> list = new ArrayList<String>();
    	int size = messageList.size();
    	
    	if(size - n >= 0) {
    		System.out.println(size);
    		for(int i = size-1; i >= size - n; i--) {
        		list.add(messageList.get(i));
        	}
    		
    		return list;
    		
    	} else {
    		return null;
    	}
    }
    
    @Override
    public String toString() {
    	return messageList.toString();
    }
}