<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/includes.jsp"%>
<title><spring:message code="login.title" /></title>
</head>
<body>
	<%@ include file="/WEB-INF/views/header.jsp"%>
	<div class="container">
		<ul class="nav nav-pills nav-stacked">
			<li class="active"><a href="#">channel</a></li>
			<c:forEach items="${ChannelList }" var="channel">
				<li><a href="<c:url value='/room' />">${channel.channelName } (${channel.userCount }people)</a></li>
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