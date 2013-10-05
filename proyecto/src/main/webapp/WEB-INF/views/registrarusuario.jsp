<%@ include file="/WEB-INF/views/include.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<title><fmt:message key="title" /></title>
<%@ include file="/WEB-INF/views/inc.js.jsp"%>
<%@ include file="/WEB-INF/views/inc.css.jsp"%>
<style>
.error {
	color: red;
}
</style>
<script>
$(document).ready(function() {
	$(".empre").css('display','none');
	$(".indv").css('display','block');
	$("#doctipo").attr('disabled','disabled');
	
	$("#usuariotipo").change(function() {
		if($(this).val() == 'EMP'){
			$(".indv").css('display','none');
			$(".empre").css('display','block');
		} else {
			$(".indv").css('display','block');
			$(".empre").css('display','none');
		}
	});
	
	$("#pais").change(function() {
		$("#docnum").val('');
		
		if($(this).val() == 'PER'){
			$("#doctipo").val('DNI');
			$("#doctipo").attr('disabled','disabled');
		} else {
			$("#doctipo").val('PAS');
			$("#doctipo").removeAttr('disabled');
			$("#doctipo option[value=DNI]").attr('disabled','disabled');
			
		}
		
    });
});

function mostrarFormulario(id){
	$("#form"+id).css('display','');
	$("#banner").css('display','none');
}
</script>
</head>
<body>


	<div id="rightbar">
		<div id="evento" class="panelContainer">
			<div id="panel"
				style="width: 600px; height: 300px; margin-left: 20px;">

				<table width="600px" height="40" border="0" cellpadding="0"
					cellspacing="0">
					<tr>
						<td width="520" height="32" class="topBar"
							style="vertical-align: top">REGISTRARSE</td>
						<td width="75" class="topBar logoPanel"><img
							src="images/logoPrueba.gif" alt="" /></td>
					</tr>
				</table>
				<div id="banner" style="margin-left: 200px;">
					<button onclick="mostrarFormulario('1');" name="Button">Registro
						Individual</button>
					<br />
					<button onclick="mostrarFormulario('2');" name="Button">Registro
						Empresa</button>
				</div>

				<div id="form1" style="display: none">
					<form action="" method="post">
						<table width="600px" height="262" border="0" cellpadding="0"
							cellspacing="0">
							<tr>
								<td width="40">&nbsp;</td>
								<td width="109"><strong>Nombres :</strong></td>
								<td colspan="2"><input name="nombres" type="text"
									class="field" id="nombres" /></td>
							</tr>
							<tr>
								<td>&nbsp;</td>
								<td><strong>Apellidos :</strong></td>
								<td colspan="2"><input name="apellidos" type="text"
									class="field" id="apellidos" size="50" /></td>
							</tr>

							<tr>
								<td>&nbsp;</td>
								<td><strong>Pa&iacute;s :</strong></td>
								<td colspan="2"><select id="paises" name="paises">
										<option>Seleccione</option>
								</select></td>
							</tr>
							<tr>
								<td height="21">&nbsp;</td>
								<td><strong>Documento de identidad:</strong></td>
								<td colspan="2"><select id="documento_identidad"
									name="documento_identidad">
										<option>Seleccione</option>
								</select>&nbsp;<input name="valor_documento" type="text" class="field"
									id="valor_documento" size="50"
									onchange="validarCampos('documento');" /></td>
							</tr>
							<tr>
								<td>&nbsp;</td>
								<td><strong>Correo :</strong></td>
								<td colspan="2"><input name="correo" type="email"
									class="field" id="correo" size="30" /></td>
							</tr>
							<tr>
								<td>&nbsp;</td>
								<td><strong>Centro de Trabajo :</strong></td>
								<td colspan="2"><input name="centro_trabajo" class="field"
									id="centro_trabajo" size="60" /></td>
							</tr>
							<tr>
								<td>&nbsp;</td>
								<td><strong>Cargo</strong></td>
								<td colspan="2"><input name="cargo" type="text"
									class="field" id="cargo" size="30" /></td>
							</tr>
							<tr>
								<td>&nbsp;</td>
								<td><strong>Usuario</strong></td>
								<td colspan="2"><input name="usuario" type="text"
									class="field" id="usuario" size="30" /></td>
							</tr>
							<tr>
								<td height="21" align="center">&nbsp;</td>
								<td align="center">&nbsp;</td>
								<td colspan="2" align="center">&nbsp;</td>
							</tr>
							<tr>
								<td height="21" align="center">&nbsp;</td>
								<td align="center">&nbsp;</td>
								<td width="79" align="center"><input name="Button"
									type="button" class="btn guardar" value="" onclick="submit();" /></td>
								<td width="353"
									style="padding-right: 12px; text-align: right; font-size: 9px;">&nbsp;</td>
							</tr>

						</table>
					</form>
				</div>


			</div>
		</div>
	</div>

	<h1>
		<fmt:message key="registro.heading" />
	</h1>
	<form:form method="post" commandName="registro">
		<table width="95%" bgcolor="f8f8ff" border="0" cellspacing="0"
			cellpadding="5">
			<tr style="display: none;">
				<td align="right" width="20%">Id :</td>
				<td width="20%"><form:input path="id" /></td>
				<td width="60%"><form:errors path="id" cssClass="error" /></td>
			</tr>

			<tr>
				<td align="right" width="20%">Tipo Usuario :</td>
				<td width="20%"><form:select path="usuariotipo">
						<form:option value="IND" label="Individual" selected="selected" />
						<form:option value="EMP" label="Empresa" />
					</form:select></td>
				<td width="60%"><form:errors path="usuariotipo"
						cssClass="error" /></td>
			</tr>

			<tr class="indv empre">
				<td align="right" width="20%">Nombres :</td>
				<td width="20%"><form:input path="nombre" /></td>
				<td width="60%"><form:errors path="nombre" cssClass="error" />
				</td>
			</tr>

			<tr class="indv empre">
				<td align="right" width="20%">Apellidos :</td>
				<td width="20%"><form:input path="apellido" /></td>
				<td width="60%"><form:errors path="apellido" cssClass="error" />
				</td>
			</tr>

			<tr class="indv empre">
				<td align="right" width="20%">País :</td>
				<td><form:select path="pais">
						<form:option value="PER" label="PERU" selected="selected" />
						<form:option value="EXT" label="EXTRANJERO" />
					</form:select></td>
				<td width="60%"><form:errors path="pais" cssClass="error" /></td>
			</tr>

			<tr class="indv">
				<td>Tipo documento :</td>
				<td><form:select path="doctipo">
						<form:option value="DNI" label="DNI" />
						<form:option value="PAS" label="Pasaporte" />
						<form:option value="DOC" label="NumDocumento" />
					</form:select></td>
				<td><form:errors path="doctipo" cssClass="error" /></td>
			</tr>

			<tr class="indv">
				<td align="right" width="20%">Número de documento :</td>
				<td width="20%"><form:input path="docnum" /></td>
				<td width="60%"><form:errors path="docnum" cssClass="error" />
				</td>
			</tr>

			<tr class="indv">
				<td align="right" width="20%">Usuario :</td>
				<td width="20%"><form:input path="usuario" /></td>
				<td width="60%"><form:errors path="usuario" cssClass="error" />
				</td>
			</tr>

			<tr class="indv">
				<td align="right" width="20%">Clave :</td>
				<td width="20%"><form:input path="clave" /></td>
				<td width="60%"><form:errors path="clave" cssClass="error" /></td>
			</tr>

			<tr class="indv">
				<td align="right" width="20%">Teléfono :</td>
				<td width="20%"><form:input path="telefono" /></td>
				<td width="60%"><form:errors path="telefono" cssClass="error" />
				</td>
			</tr>

			<tr class="indv empre">
				<td align="right" width="20%">Correo :</td>
				<td width="20%"><form:input path="correo" /></td>
				<td width="60%"><form:errors path="correo" cssClass="error" />
				</td>
			</tr>

			<tr>
				<td colspan="3">
					--------------------------------------------------------------------------------
				</td>
			</tr>

			<tr class="empre">
				<td align="right" width="20%">Razón social :</td>
				<td width="20%"><form:input path="razonsoc" /></td>
				<td width="60%"><form:errors path="razonsoc" cssClass="error" />
				</td>
			</tr>

			<tr class="empre">
				<td align="right" width="20%">Tipo Empresa :</td>
				<td width="20%"><form:input path="emptipo" /></td>
				<td width="60%"><form:errors path="emptipo" cssClass="error" />
				</td>
			</tr>

			<tr class="empre">
				<td align="right" width="20%">Sector :</td>
				<td width="20%"><form:input path="empsector" /></td>
				<td width="60%"><form:errors path="empsector" cssClass="error" />
				</td>
			</tr>

			<tr class="empre">
				<td align="right" width="20%">Representante :</td>
				<td width="20%"><form:input path="emprepresent" /></td>
				<td width="60%"><form:errors path="emprepresent"
						cssClass="error" /></td>
			</tr>

			<tr class="empre">
				<td align="right" width="20%">Cargo :</td>
				<td width="20%"><form:input path="trabcargo" /></td>
				<td width="60%"><form:errors path="trabcargo" cssClass="error" />
				</td>
			</tr>

			<tr class="empre">
				<td align="right" width="20%">Dirección Trab:</td>
				<td width="20%"><form:input path="trabdir" /></td>
				<td width="60%"><form:errors path="trabdir" cssClass="error" />
				</td>
			</tr>
		</table>
		<br>
		<input type="submit" align="center" value="Execute">
	</form:form>
	<a href="<c:url value="home.htm"/>">Home</a>
</body>
</html>