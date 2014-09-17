<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>登陆</title>
<script type="text/javascript">
	function profile() {
		var name = document.getElementById("name").value;
		var url = 'http://localhost:8080/chat-room/login/' + name;
		window.location.href = url;
	};
</script>
</head>
<body>
	<textarea id="name"></textarea>
	<input type="button" value="登陆" onclick="profile()">
</body>
</html>