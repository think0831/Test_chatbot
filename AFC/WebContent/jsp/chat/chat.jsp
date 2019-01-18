<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		/*if (session.getAttribute("isLogined") == null)
			response.sendRedirect("/Foo/login.jsp");*/
	%>

 	<fieldset>
        <textarea id="messageWindow" rows="10" cols="50" readonly="true"></textarea>
        <br/>
        <input id="inputMessage" type="text"/>
        <input type="submit" value="send" onclick="send()"/>
    </fieldset>
    
</body>

<script type="text/javascript">
    var textarea = document.getElementById("messageWindow");
    var webSocket = new WebSocket('ws://localhost/chat');
    var inputMessage = document.getElementById('inputMessage');
    webSocket.onerror = function(event) {
      onError(event)
    };
    webSocket.onopen = function(event) {
      onOpen(event)
    };
    webSocket.onmessage = function(event) {
      onMessage(event)
    };
    function onMessage(event) {
		var message = String(event.data).split(';')
    	
		if (message[0] == "join") {
			window.open('http://localhost/jsp/fund/survey.jsp','성향분석','width=800, height=700, toolbar=no, menubar=no, scrollbars=no, resizable=yes');
		}
    	textarea.value += "상대 : " + message[0] + "\n";
    }
    function onOpen(event) {
        textarea.value += "연결 성공\n";
    }
    function onError(event) {
      alert(event.data);
    }
    function send() {
        textarea.value += "나 : " + inputMessage.value + "\n";
        webSocket.send(inputMessage.value);
        inputMessage.value = "";
    }
  </script>

</html>