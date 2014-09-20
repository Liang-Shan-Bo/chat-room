<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>主页</title>
<script language="javascript"
	src="<%=path%>/bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="<%=path%>/bootstrap/jcss/bootstrap.min.css" />
<script type="text/javascript">

	function profile() {
		var id = document.getElementById("id").value;
		var pwd = document.getElementById("pwd").value;
		var url;
		if(id == null || id == "" || pwd == null || pwd == ""){
			url = '<%=path%>/login/';
		}else{
			url = '<%=path%>/login/' + id +'/' + pwd;
			};
		window.location.href = url;
	};
	function regist() {
		var url = '<%=path%>/login/regist';
		window.location.href = url;
	};
	function findpwd() {
		var url = '<%=path%>/login/findpwd.jsp';
		window.location.href = url;
	};
</script>
</head>
<body>
	账号：<input type="text" id="id" /><br /> 
	密码：<input type="password" id="pwd" /><br />
	<input type="button" value="登陆" onclick="profile()" />
	<input type="button" value="注册" onclick="regist()" />
	<input type="button" value="忘记密码" onclick="findpwd()" /><br />
	<label id="loginresult"><%=request.getAttribute("loginResult")%></label>
</body>
</html>