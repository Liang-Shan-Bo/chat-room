<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/includes.jsp"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<title><spring:message code="channel.title" /></title>
</head>
<body>
	<%@ include file="/WEB-INF/views/header.jsp"%>
	<div class="container">
		<h2 class="form-signin-heading"><c:out value="${ChannelName }" /></h2>
		<!-- 
		<textarea cols=200 rows=25>In fact, I do not know to say something, but do not say something they do not feel very professional, said would be tucao</textarea><br/>
		 -->
		<div class="row">
		  	<div class="col-md-8">
				<input type="text" class="form-control" width="80%" placeholder="Do you have anything to say for yourself?" />
			</div>
	  		<div class="col-md-4">
				<input type="button" class="btn btn-primary" value="SEND" />
	  		</div>
		</div>
	</div>
	<!-- /container -->
</body>
</html>