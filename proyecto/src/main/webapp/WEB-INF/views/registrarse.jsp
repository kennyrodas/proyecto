<%@ include file="/WEB-INF/views/inc.header.jsp"%>
<body class="login-page">
	<!--[if lt IE 7]>
	    <p class="chromeframe">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> or <a href="http://www.google.com/chromeframe/?redirect=true">activate Google Chrome Frame</a> to improve your experience.</p>
	<![endif]-->

	<!-- BEGIN Main Content -->
	<div class="login-wrapper">
		<!-- BEGIN Login Form -->
		<form id="form-login" action="#" method="get">
			<h3>Elige el tipo de cuenta</h3>
			<hr />
			<div class="control-group">
				<div class="controls">
					<a href="<c:url value="/registro/individual.htm"/>"><div
							class="btn btn-primary input-block-level">INDIVIDUAL</div></a>
				</div>
			</div>
			<div class="control-group">
				<div class="controls">
					<a href="<c:url value="/registro/empresa.htm"/>"><div
							type="submit" class="btn btn-primary input-block-level">EMPRESARIAL</div></a>
				</div>
			</div>
			<hr />
			<p class="clearfix">
				<a href="<c:url value="/login.htm"/>" class="goto-forgot pull-left">Regresar</a>
			</p>
		</form>
		<!-- END Login Form -->
	</div>
	<!-- END Main Content -->