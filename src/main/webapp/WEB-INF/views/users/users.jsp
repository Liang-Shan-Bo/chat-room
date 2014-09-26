<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/includes.jsp"%>
<title><spring:message code="app.name" /></title>
</head>
<body>
<%@ include file="/WEB-INF/views/header.jsp" %>
    <div class="container">
    	<div style="height: 30px;"> </div>
      		<c:forEach items="${users }" var="user">
      	<span>${user.username }</span><br />
      </c:forEach>
    </div> <!-- /container -->
</body>
</html>