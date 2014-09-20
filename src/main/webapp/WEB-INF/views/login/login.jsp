<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>login page</title>
<link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<script src="/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript">
	function exit() {
		var url = 'http://localhost:8080/chat-room/login';
		window.location.href = url;
	};
</script>
</head>
<body>
	你好:<%=request.getAttribute("loginUser")%>,现在时间是<%=new Date()%>
	<input type="button" value="退出" onclick="exit()">
</body>
</html>