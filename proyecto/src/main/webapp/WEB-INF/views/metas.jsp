<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Metas</title>
</head>
<body>
	<table border="0" cellpadding="0" cellspacing="0" width="94%">
		<tbody>
			<tr>
				<td><span class="texto"><b>ACTIVIDAD:</b></span></td>
			</tr>
		</tbody>
	</table>
	<fieldset class="demo_fieldset">
		<legend class="demo_legend" style="color: #404040">Metas de
			Indicadores de Actividad</legend>
		<table border="0" cellpadding="0" cellspacing="1" width="760">
			<tbody>
				<tr>
					<td height="40" width="100"><span class="texto">Indicador:</span></td>
					<td><div id="indicadores">
							<select id="indicador" class="campolista" style="WIDTH: 480px"
								tabindex="2" onchange="BuscaMetas()">
								<option value="0" selected="">Elija...</option>
								<option value="1752">NUMERO DE TALLERES DIRIGIDOS A
									DOCENTES EN LA PROMOCION DE PRACTICAS SALUDA...</option>
								<option value="1753">NUMERO DE DOCENTES CAPACITADOS EN
									PROMOCION DE PRACTICAS SALUDABLES DE CUID...</option>
							</select>
						</div></td>
				</tr>
				<tr>
					<td colspan="2">
						<table border="0" cellpadding="0" cellspacing="1" width="100%">
							<tbody>
								<tr>
									<td width="100"><span class="texto">Región:</span></td>
									<td><select id="ltregion" class="campolista"
										style="WIDTH: 256px" onchange="TraeProvincias()" tabindex="2">
											<option value="0" selected="">Elija...</option>
											<option value="12">PIURA</option>
									</select></td>
									<td><span class="texto">Provincia:</span></td>
									<td><div id="provincias">
											<select id="ltprovincia" class="campolista"
												style="WIDTH: 257px" onchange="TraeDistritos()" tabindex="3">
												<option value="0" selected="">Elija...</option>
											</select>
										</div></td>
								</tr>
								<tr>
									<td><span class="texto">Distrito:</span></td>
									<td><div id="distritos">
											<select id="ltdistrito" class="campolista"
												style="WIDTH: 257px" onchange="TraeComunidades()"
												tabindex="4">
												<option value="0" selected="">Elija...</option>
											</select>
										</div></td>
									<td><span class="texto">Comunidad:</span></td>
									<td><div id="comunidades">
											<select id="ltcomunidad" class="campolista"
												style="WIDTH: 257px" onchange="TraeParticipantes()"
												tabindex="5">
												<option value="0" selected="">Elija...</option>
											</select>
										</div></td>
								</tr>
							</tbody>
						</table>
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<div id="metas">
							<span class="texto">Seleccione un indicador</span>
						</div>
					</td>
				</tr>
			</tbody>
		</table>
	</fieldset>
	<div style="padding: 5px 0px 0px 360px">
		<table>
			<tbody>
				<tr>
					<td height="40" valign="MIDDLE" width="40"><div id="cargando"
							style="display: none;">
							<img src="imagenes/ajax.gif" height="32px" width="32px">
						</div></td>
					<td valign="MIDDLE"><input class="boton" onclick="Guardar()"
						value="Guardar" id="btnAgregar" tabindex="11" type="button">
					</td>
					<td valign="MIDDLE"><input class="boton" onclick="Cerrar()"
						value="Cerrar" id="btnCerrar" tabindex="12" type="button">
					</td>
				</tr>
			</tbody>
		</table>
	</div>

	<div id="lista" style="overflow: auto; width: 693px; height: 240px">
	</div>
</body>
</html>