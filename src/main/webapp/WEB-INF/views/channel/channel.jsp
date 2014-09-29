<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/includes.jsp"%>
<title><spring:message code="login.title" /></title>
</head>
<body>
<%@ include file="/WEB-INF/views/header.jsp" %>
    <div class="container">
      <form class="form-signin" role="form" name="loginForm" action="<c:url value='/doLogin' />" method="post">
        <h2 class="form-signin-heading">channel</h2>
		<dl>
		    <dd><a href="<c:url value='/room' />">channel 1</a></dd>
		    <dd><a href="<c:url value='/room' />">channel 2</a></dd>
		    <dd><a href="<c:url value='/room' />">channel 3</a></dd>
		    <dd><a href="<c:url value='/room' />">channel 4</a></dd>
		</dl>
        <br />
        <!-- 
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
         -->
      </form>
    </div> <!-- /container -->
</body>
</html>