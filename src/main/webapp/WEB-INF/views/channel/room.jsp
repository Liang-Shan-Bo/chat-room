<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/includes.jsp"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<title><c:out value="${ChannelName }" /></title>
</head>
<body>
<%@ include file="/WEB-INF/views/header.jsp" %>
  
<h2 class="form-signin-heading"><c:out value="${ChannelName }" /></h2>
<textarea cols=200 rows=25>In fact, I do not know to say something, but do not say something they do not feel very professional, said would be tucao</textarea><br/>
<textarea class="form-control" rows="1" placeholder="Do you have anything to say for yourself?"></textarea>
<input type="button" value="submit">
</html>