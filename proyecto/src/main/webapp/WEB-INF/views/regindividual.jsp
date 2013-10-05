<%@ include file="/WEB-INF/views/inc.header.jsp"%>

<!--[if lt IE 7]>
    <p class="chromeframe">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> or <a href="http://www.google.com/chromeframe/?redirect=true">activate Google Chrome Frame</a> to improve your experience.</p>
<![endif]-->

<!-- BEGIN Container -->
<div class="container-fluid" id="main-container">

	<div id="sidebar" class="nav-collapse">

		<!-- BEGIN Sidebar Collapse Button -->
		<div id="sidebar-collapse" class="visible-desktop">
			<i class="icon-double-angle-left"></i>
		</div>
		<!-- END Sidebar Collapse Button -->
	</div>

	<!-- BEGIN Content -->
	<div id="main-content">

		<!-- BEGIN Page Title -->
		<div class="page-title">
			<div>
				<h1>
					<i class="icon-file-alt"></i> Registro
				</h1>
				<h4>Coloque sus datos correctamente para registrarse.</h4>
			</div>
		</div>
		<!-- END Page Title -->

		<!-- BEGIN Breadcrumb -->
		<div id="breadcrumbs">
			<ul class="breadcrumb">
				<li><i class="icon-home"></i> <a
					href="<c:url value="/login.htm"/>">Home</a> <span class="divider"><i
						class="icon-angle-right"></i></span></li>
				<li class="active">Registro</li>
			</ul>
		</div>
		<!-- END Breadcrumb -->

		<!-- BEGIN Main Content -->
		<div class="row-fluid">
			<div class="span12">
				<div class="box">

					<!-- Titulo -->
					<div class="box-title">
						<h3>
							<i class="icon-reorder"></i> Registro Individual
						</h3>
						<div class="box-tool">
							<a data-action="collapse" href="#"><i class="icon-chevron-up"></i></a>
							<a data-action="close" href="#"><i class="icon-remove"></i></a>
						</div>
					</div>

					<!-- Contenido -->
					<div class="box-content">
						<form id="formID" class="form-horizontal"
							action="<c:url value="/resgistrarusuario.htm"/>" method="POST">
							<input type="hidden" name="usuariotipo" value="IND">

							<div class="control-group">
								<div class="controls">
									<h3>Datos Personales</h3>
								</div>
							</div>

							<div class="control-group">
								<label class="control-label">Nombres</label>
								<div class="controls">
									<input id="nombre" name="nombre" type="text"
										class="validate[required, custom[onlyLetterSp]] field text medium"
										maxlength="255" />
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">Apellidos</label>
								<div class="controls">
									<input id="apellido" name="apellido" type="text"
										class="validate[required, custom[onlyLetterSp]] field text medium"
										maxlength="255" />
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">Pa&iacute;s</label>
								<div class="controls">
									<select id="pais" name="pais">
										<option disabled="disabled" selected="selected">--Seleccione--</option>
										<c:forEach items="${model.paises}" var="pais">
											<option value="<c:out value="${pais.paisId}"/>"><c:out
													value="${pais.nombre}" /></option>
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">Documento de Indentidad</label>
								<div class="controls">
									<select id="doctipo" name="doctipo">
										<option disabled="disabled" selected="selected" tipo="1">--Seleccione--</option>
										<c:forEach items="${model.doctipos}" var="doctipo">
											<option
												value="<c:out value="${doctipo.documentoIdentidadId}"/>"
												tipo="<c:out value="${doctipo.tipoPersona}"/>"><c:out
													value="${doctipo.nombre}" /></option>
										</c:forEach>
									</select> <input id="docnum" name="docnum" type="text" class=""
										maxlength="45" />

								</div>
							</div>
							<div class="control-group">
								<label class="control-label">Centro de Trabajo</label>
								<div class="controls">
									<input id="trabdir" name="trabdir" type="text"
										class="field text medium" maxlength="255" />
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">Tel&eacute;fono</label>
								<div class="controls">
									<input id="telefono" name="telefono" type="text"
										class="validate[custom[onlyNumberSp], minSize[6]] field text medium"
										maxlength="255" />
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">Cargo</label>
								<div class="controls">
									<input id="trabcargo" name="trabcargo" type="text"
										class="validate[custom[onlyLetterSp]] field text medium"
										maxlength="70" />
								</div>
							</div>

							<div class="control-group">
								<div class="controls">
									<h3>Datos de Acceso</h3>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">Usuario</label>
								<div class="controls">
									<input id="usuario" name="usuario" type="text"
										class="validate[required, custom[onlyLetterNumber], minSize[4], ajax[ajaxUsername]] field text addr"
										style="width: 200px" value="" />
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">Clave</label>
								<div class="controls">
									<input id="clave" name="clave"
										class="validate[required, custom[onlyLetterNumber], minSize[4]] field text addr"
										type="password" style="width: 200px" />
								</div>
							</div>

							<div class="form-actions">
								<button class="btn btn-primary" type="submit">
									<i class="icon-ok"></i> Save
								</button>
								<button class="btn" type="button">Cancel</button>
							</div>

						</form>
					</div>
					<!-- END box-content -->

				</div>
				<!-- END box -->
			</div>
			<!-- END span-12 -->
		</div>
		<!-- END row-fluid -->
		<!-- END Main Content -->

		<footer>
			<p>2013 © GID.</p>
		</footer>

		<a id="btn-scrollup" class="btn btn-circle btn-large" href="#"><i
			class="icon-chevron-up"></i></a>

	</div>
	<!-- END Content -->
</div>
<!-- END Container -->

<%@ include file="/WEB-INF/views/inc.footer.jsp"%>
<script>
$(document).ready(function() {
	$("#docnum").attr('disabled','disabled');
	
	jQuery("#formID").validationEngine();
	$("#formID").bind("jqv.field.result", function(event, field, errorFound, prompText){ console.log(errorFound) });
	
	// quitamos opciones de empresa
	$("#doctipo option[tipo!='1']").each(function() { $(this).remove(); });
	
	// PAIS - Si es Peruano DocTipo = DNI
	$("#pais").change(function() {
		if ( $("#pais option:selected").text() == "PERU" ){
			//#doctipo
			$("#doctipo").val("1");
			$("#doctipo option[value!='1']").each(function() { $(this).attr('disabled','disabled'); });
			//#numdoc
			utilValDocnum();
		} else {
			//#doctipo
			$("#doctipo option").each(function() { $(this).removeAttr('disabled'); });
			$("#doctipo option[value='1']").attr('disabled','disabled');
			$("#doctipo").val("2");
			//#numdoc
			utilValDocnum();
		}
	});
	
	// Si es DNI size=8 || carnet ext=21
	$("#doctipo").change(function() {
		utilValDocnum();
	});
	
});

function utilValDocnum(){
	$("#docnum").removeAttr('disabled');
	
	<c:forEach items="${model.doctipos}" var="doctipo">
	if ( $("#doctipo option:selected").text() == "<c:out value="${doctipo.nombre}"/>" ){
		$("#docnum").removeClass().addClass("validate[required, custom[onlyNumberSp], minSize[${doctipo.numeroDigitos}], maxSize[${doctipo.numeroDigitos}]]");
	}
    </c:forEach>
}
</script>
</body>
</html>
