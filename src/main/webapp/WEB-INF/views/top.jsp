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
	</div>
</body>

</html>