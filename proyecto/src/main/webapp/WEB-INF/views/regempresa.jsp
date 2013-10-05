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
							<i class="icon-reorder"></i> Registro Empresa
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
									<h3>Datos de Empresa</h3>
								</div>
							</div>

							<div class="control-group">
								<label class="control-label">Pa&iacute;s</label>
								<div class="controls">
									<select id="pais" name="pais" class="field select">
										<option disabled="disabled">--Seleccione--</option>
										<c:forEach items="${model.paises}" var="pais">
											<option value="<c:out value="${pais.paisId}"/>"><c:out
													value="${pais.nombre}" /></option>
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="control-group" id="dvruc">
								<label class="control-label">Ruc</label>
								<div class="controls">
									<input id="docnum" name="docnum" type="text"
										class="validate[required, custom[onlyNumberSp], minSize[11], maxSize[11]] field text small"
										maxlength="45" />
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">Razon Social</label>
								<div class="controls">
									<input id="razonsoc" name="razonsoc" type="text"
										class="validate[required, custom[onlyLetterNumber]] field text small"
										maxlength="45" />
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">Tipo de Empresa</label>
								<div class="controls">
									<select name="emptipo" class="field select" id="emptipo">
										<option>--Seleccione--</option>
										<option value="1">Tipo empresa 1</option>
										<option value="2">Tipo empresa 2</option>
										<option value="3">Tipo empresa 3</option>
									</select>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">Sector</label>
								<div class="controls">
									<select name="empsector" class="field select" id="empsector">
										<option>--Seleccione--</option>
										<option value="1">Sector 1</option>
										<option value="2">Sector 2</option>
										<option value="3">Sector 3</option>
									</select>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">Nombre del representante</label>
								<div class="controls">
									<input id="emprepresent" name="emprepresent" type="text"
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
								<label class="control-label">Correo</label>
								<div class="controls">
									<input id="correo" name="correo" type="text"
										class="validate[required, custom[email]] field text medium"
										maxlength="255" />
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
            
	// This method is called right before the ajax form validation request
	// it is typically used to setup some visuals ("Please wait...");
	// you may return a false to stop the request 
	function beforeCall(form, options){
		if (console) 
		console.log("Right before the AJAX form validation call");
		return true;
	}
           
	// Called once the server replies to the ajax form validation request
	function ajaxValidationCallback(status, form, json, options){
		if (console) 
		console.log(status);
               
		if (status === true) {
			alert("the form is valid!");
			// uncomment these lines to submit the form to form.action
			// form.validationEngine('detach');
			// form.submit();
			// or you may use AJAX again to submit the data
		}
	}
	
	
	$(document).ready(function() {
		
		jQuery("#formID").validationEngine({
		});
		
		$("#pais").change(function() {
			if($(this).val() == '1'){
				$('#dvruc').show();
			} else {
				$('#dvruc').hidden();
			}
			/*
			// Pais : 1 = PERU // DocTipo : 3 = CARNET EXT 
			if($(this).val() == '1'){
				$("#doctipo option[value='1']").each(function() {
				    $(this).remove();
				});
			} else {
				$("#doctipo").append('<option value="3" selected="selected">CARNET EXT</option>');
			}
		*/
			
	    });
	});
</script>
</body>
</html>

