<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/includes.jsp"%>
<title><spring:message code="login.title" /></title>
</head>
<body>
    <div class="container">
    	<c:if test="${not empty error}">
			<div class="error">${error}</div>
		</c:if>
      <form class="form-signin" role="form" name="loginForm" action="<c:url value='/doLogin' />" method="post">
        <h2 class="form-signin-heading">Please sign in</h2>
        <input name="username" type="text" class="form-control" placeholder="User Name" required="" autofocus="" autocomplete="off">
        <input name="password" type="password" class="form-control" placeholder="Password" required="">
        <!-- 
        <label class="checkbox">
          <input type="checkbox" value="remember-me"> Remember me
        </label>
         -->
        <input class="btn btn-lg btn-primary btn-block" type="submit" value="Sign in" >
        <br />
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
      </form>
    </div> <!-- /container -->
</body>
</html>