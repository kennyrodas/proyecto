<%@ include file="/WEB-INF/views/inc.header.jsp"%>
<%@ include file="/WEB-INF/views/menu.jsp"%>
</ul>
<!-- END Navlist -->
</div>
<!-- END Sidebar -->
</div>
<!-- BEGIN Content -->
<div id="main-content">
	<!-- BEGIN Page Title -->
	<div class="page-title">
		<div>
			<h1>Crear nuevo usuario</h1>
		</div>
	</div>
	<!-- END Page Title -->

	<!-- BEGIN Breadcrumb -->
	<div id="breadcrumbs">
		<ul class="breadcrumb">
			<li><i class="icon-home"></i> <a href="home.html">Home</a> <span
				class="divider"><i class="icon-angle-right"></i></span></li>
			<li class="active">Nuevo Usuario</li>
		</ul>
	</div>
	<!-- END Breadcrumb -->
	<!-- BEGIN Main Content -->
	<div class="row-fluid">
		<div class="span12">
			<div class="box">
				<div class="box-title">
					<h3>
						<i class="icon-reorder"></i>Registrar Usuario
					</h3>
					<div class="box-tool">
						<a data-action="collapse" href="#"><i class="icon-chevron-up"></i></a>
						<a data-action="close" href="#"><i class="icon-remove"></i></a>
					</div>
				</div>
				<div class="box-content">
					<form id="formID" class="form-horizontal"
						action="<c:url value="/nuevousuario.htm"/>" method="POST">
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
								<select id="pais" name="pais" class="field select">
									<option disabled="disabled">--Seleccione--</option>
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
								<select id="doctipo" name="doctipo" class="field select">
									<option disabled="disabled">--Seleccione--</option>
									<c:forEach items="${model.doctipos}" var="doctipo">
										<option
											value="<c:out value="${doctipo.documentoIdentidadId}"/>"
											tipo="<c:out value="${doctipo.tipoPersona}"/>"><c:out
												value="${doctipo.nombre}" /></option>
										<%-- 		    	<c:if test="${doctipo.tipoPersona == 1}"> --%>
										<%-- 		    	    <option value="<c:out value="${doctipo.documentoIdentidadId}"/>"><c:out value="${doctipo.nombre}"/></option> --%>
										<%-- 	    	    </c:if> --%>
									</c:forEach>
								</select> <input type="text" class="span3" name="docnum" id="docnum"
									minlength="8" />

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
			</div>
		</div>
	</div>
	<!-- END Main Content -->
	<!--                 <a id="btn-scrollup" class="btn btn-circle btn-large" href="#"><i class="icon-chevron-up"></i></a> -->


	<%@ include file="/WEB-INF/views/inc.footer.jsp"%>
	<script>
$(document).ready(function() {
	
	jQuery("#formID").validationEngine();
	$("#formID").bind("jqv.field.result", function(event, field, errorFound, prompText){ console.log(errorFound) });
	
	// quitamos opciones de empresa
	$("#doctipo option[tipo!='1']").each(function() { $(this).remove(); });
	
	// Si es Peruano DocTipo = DNI
	$("#pais").change(function() {
		if($(this).val() == '1'){ // PERU
			$("#doctipo").val("1"); // DNI
			$("#doctipo option[value!='1']").each(function() { $(this).attr('disabled','disabled'); });
		} else {
			$("#doctipo option").each(function() { $(this).removeAttr('disabled'); });
		}
	});
	
	// Si es DNI size=8 || carnet ext=21
	$("#doctipo").change(function() {
		<c:forEach items="${model.doctipos}" var="doctipo">
		if ( $("#doctipo option:selected").text() == "<c:out value="${doctipo.nombre}"/>" ){
			$("#docnum").removeClass().addClass("validate[custom[onlyNumberSp], minSize[<c:out value="${doctipo.numeroDigitos}"/>]] field text small");
		}
	    </c:forEach>
	});
	
	$("#usuariotipo").change(function() {
		if($(this).val() == 'EMP'){
			$(".indv").css('display','none');
			$(".empre").css('display','block');
		} else {
			$(".indv").css('display','block');
			$(".empre").css('display','none');
		}
	});

});
</script>
	</body>
	</html>