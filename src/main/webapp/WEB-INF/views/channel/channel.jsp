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
		<ul class="nav nav-pills nav-stacked">
			<c:forEach items="${ChannelList }" var="channel">
				<li><a href="<c:url value='/room/${channel.channelName }' />">${channel.channelName } (${channel.userCount }people)</a></li>
				<br />
			</c:forEach>
		</ul>
		<br />
		<!-- 
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
         -->
	</div>
	<!-- /container -->
</body>
</html>