<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#"><spring:message code="app.name" /></a>
        </div>
        <div class="collapse navbar-collapse">
			<ul class="nav navbar-nav">
				<li class="active"><a href="#">Home</a></li>
				<!-- 
				<li><a href="#about">About</a></li>
				<li><a href="#contact">Contact</a></li>
				 -->
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<sec:authorize ifNotGranted="ROLE_USER">
				<li>
					<a href="<c:url value='/login' />">Login</a>
				</li>
				<li>
					<a href="<c:url value='/regist' />">Register</a>
				</li>
				</sec:authorize>
				<sec:authorize ifAnyGranted="ROLE_USER">
				<li>
					<a><sec:authentication property="principal.username" /> </a>
				</li>
				<li>
					<a href="javascript:formSubmit()"> Logout</a>
				</li>
				</sec:authorize>
			</ul>
			</div><!--/.nav-collapse -->
      </div>
    </div>
     <div class="container">

      <div class="starter-template">
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
		</sec:authorize>
	 </div>

    </div><!-- /.container -->