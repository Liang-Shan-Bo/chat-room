<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/includes.jsp"%>
<title><spring:message code="login.register" /></title>
</head>
<body>
<%@ include file="/WEB-INF/views/header.jsp" %>
    <div class="container"> 
    <c:url value="/doRegist" var="registerAction" />
      <form:form cssClass="form-signin" action="${registerAction }" modelAttribute="registUser" method="post" >
        <h2 class="form-signin-heading">Register</h2>
        <form:input path="username"  name="username" type="text" class="form-control" placeholder="User Name" required=""  />
        <form:errors path="username" cssErrorClass="errors"/>
        <form:input path="password" type="password" class="form-control" placeholder="Password" required="" />
        <form:errors path="password" cssErrorClass="errors"/>
        <form:input path="passwordConfirm" type="password" class="form-control" placeholder="Password Confirm" required="" />
        <form:errors path="passwordConfirm" cssErrorClass="errors"/>
        <input class="btn btn-lg btn-primary btn-block" type="submit" value="Register" >
        <br />
        <!-- 
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
         -->
      </form:form>
    </div> <!-- /container -->
</body>
</html>