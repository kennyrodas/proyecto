<%@ include file="/WEB-INF/views/include.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html class="no-js">
<head>
<title><fmt:message key="title" /></title>
<%@ include file="/WEB-INF/views/inc.js.jsp"%>

</head>
<body class="login-page">
	<!--[if lt IE 7]>
            <p class="chromeframe">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> or <a href="http://www.google.com/chromeframe/?redirect=true">activate Google Chrome Frame</a> to improve your experience.</p>
        <![endif]-->

	<!-- <c:if test="not empty ${error}"> -->
	<div class="alert alert-error">
		<button data-dismiss="alert" class="close">�</button>
		<h4>Error!</h4>
		<p>
			<c:out value="${error}"></c:out>
		</p>
	</div>
	<!-- </c:if> -->

	<!-- BEGIN Main Content -->
	<div class="login-wrapper">
		<!-- BEGIN Login Form -->
		<form id="form-login" action="inicio.htm" method="post">
			<h3>Accede a tu cuenta</h3>
			<label style="color: red;"><c:out value="${error}"></c:out></label>
			<hr />
			<div class="control-group">
				<div class="controls">
					<input type="text" placeholder="Usuario" name="usuario"
						class="input-block-level" />
				</div>
			</div>
			<div class="control-group">
				<div class="controls">
					<input type="password" placeholder="Password" name="clave"
						class="input-block-level" />
				</div>
			</div>
			<div class="control-group">
				<div class="controls">
					<button type="submit" class="btn btn-primary input-block-level">Entrar</button>
				</div>
			</div>
			<hr />
			<p class="clearfix">
				<a href="#" class="goto-forgot pull-left">Olvid&oacute; su
					contrase&ntilde;a</a> <a href="registrarse.htm"
					class="goto-register pull-right">Registrarse</a>
			</p>
		</form>
		<!-- END Login Form -->

		<!-- BEGIN Forgot Password Form -->
		<form id="form-forgot" action="index.html" method="get" class="hide">
			<h3>Get back your password</h3>
			<hr />
			<div class="control-group">
				<div class="controls">
					<input type="text" placeholder="Email" class="input-block-level" />
				</div>
			</div>
			<div class="control-group">
				<div class="controls">
					<button type="submit" class="btn btn-primary input-block-level">Recover</button>
				</div>
			</div>
			<hr />
			<p class="clearfix">
				<a href="#" class="goto-login pull-left">? Back to login form</a>
			</p>
		</form>
		<!-- END Forgot Password Form -->


	</div>
	<!-- END Main Content -->

	<!--basic scripts-->
	<script
		src="//ajax.googleapis.com/ajax/libs/jquery/1.10.1/jquery.min.js"></script>
	<script>window.jQuery || document.write('<script src="assets/jquery/jquery-1.10.1.min.js"><\/script>')</script>
	<script src="assets/bootstrap/bootstrap.min.js"></script>

	<script type="text/javascript">
            function goToForm(form)
            {
                $('.login-wrapper > form:visible').fadeOut(500, function(){
                    $('#form-' + form).fadeIn(500);
                });
            }
            $(function() {
                $('.goto-login').click(function(){
                    goToForm('login');
                });
                $('.goto-forgot').click(function(){
                    goToForm('forgot');
                });
            });
        </script>
</body>
</html>