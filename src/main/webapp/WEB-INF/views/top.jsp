<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/includes.jsp"%>
<title>Top</title>
</head>
<body>
<%@ include file="/WEB-INF/views/header.jsp" %>
	<div class="container">
		<sec:authorize ifAnyGranted="ROLE_ADMIN">
			<a href="<c:url value='/users' />">users</a>
		</sec:authorize>
		<br/>
		<sec:authorize ifAnyGranted="ROLE_ADMIN,ROLE_USER">
			<a href="<c:url value='/channel' />">Choose the channel</a>
		</sec:authorize>
	</div>
	<div>
		<a href="<c:url value='/showSM' />">sm</a>
	</div>
</body>

</html>