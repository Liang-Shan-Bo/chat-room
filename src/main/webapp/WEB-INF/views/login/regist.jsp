<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>注册</title>
<script language="javascript" src="<%=path%>/bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="<%=path%>/bootstrap/jcss/bootstrap.min.css" />
<script type="text/javascript">

	function regist() {
		var id = document.getElementById("id").value;
		var pwd = document.getElementById("pwd").value;
		var cfmpwd = document.getElementById("cfmpwd").value;
		var name = document.getElementById("name").value;
		if (id == null || id == "" || pwd == null || pwd == "" || cfmpwd == null || cfmpwd == "" || name == null || name == "") {
			document.getElementById("registresult").innerText="不能空啊";
		}else if (pwd != cfmpwd) {
			document.getElementById("registresult").innerText="密码不同";
		}else {
			var url = '<%=path%>/regist/' + id + '/' + pwd + '/' + name;
			window.location.href = url;
		}
	};
	function cancel() {
		var url = '<%=path%>/login/';
		window.location.href = url;
	};
</script>
</head>
<body>
	账号：<input type="text" id="id"/><br/>
	昵称：<input type="text" id="name"/><br/>
	密码：<input type="password" id="pwd"/><br/>
	确认：<input type="password" id="cfmpwd"/><br/>
	<input type="button" value="提交" onclick="regist()"/>
	<input type="button" value="返回" onclick="cancel()"/><br/>
	<label id="registresult"><%=request.getAttribute("registResult")%></label>
</body>
</html>