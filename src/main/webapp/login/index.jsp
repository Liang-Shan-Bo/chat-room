<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>登陆</title>
<script language="javascript" src="<%=path%>/bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="<%=path%>/bootstrap/jcss/bootstrap.min.css" />
<script type="text/javascript">
	function profile() {
		var name = document.getElementById("name").value;
		var url = '<%=path%>/login/' + name;
		window.location.href = url;
	};
</script>
</head>
<body>
	用户：<input type="text" id="name"/><br/>
	密码：<input type="text" id="pwd"/><br/>
	<input type="button" value="登陆" onclick="profile()"/>
	<br/><%=request.getAttribute("rowCount")%>
</body>
</html>