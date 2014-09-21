<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/includes.jsp"%>
<title>Top</title>
</head>
<body>
	<div class="container">
		<sec:authorize ifNotGranted="ROLE_ADMIN, ROLE_USER">
		<a href="<c:url value='/login' />">login</a>
		</sec:authorize>

		<sec:authorize access="hasRole('ROLE_USER')">
			<!-- For login user -->
			<c:url value="/logout" var="logoutUrl" />
			<form action="${logoutUrl}" method="post" id="logoutForm">
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
			</form>
			<script>
				function formSubmit() {
					document.getElementById("logoutForm").submit();
				}
			</script>
			<c:if test="${pageContext.request.userPrincipal.name != null}">
				hello!<br /> 
				<sec:authentication property="principal.username" /> | <a href="javascript:formSubmit()"> Logout</a>
			</c:if>
		</sec:authorize>

	</div>
	<!-- /container -->
</body>
</html>