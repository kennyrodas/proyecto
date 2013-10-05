<%@ include file="/WEB-INF/views/include.jsp"%>
<%@ include file="/WEB-INF/views/inc.header.jsp"%>
<%@ include file="/WEB-INF/views/menu.jsp"%>
<li><a href="#" class="dropdown-toggle"> <i
		class="icon-desktop"></i> <span>Detalles del Proyecto</span> <b
		class="arrow icon-angle-right"></b>
</a> <!-- BEGIN Submenu -->
	<ul class="submenu">
		<li><a
			href="detalles_proyecto.htm<c:out value="?id=${model.proyecto.proyectoId}"/>">Informaci&oacute;n</a></li>
		<li><a
			href="arbol.htm<c:out value="?id=${model.proyecto.proyectoId}"/>">Actividades</a></li>
		<li><a
			href="ingresodirecto.htm<c:out value="?id=${model.proyecto.proyectoId}"/>">Ingreso
				Directo</a></li>
		<li><a
			href="participantes.htm<c:out value="?id=${model.proyecto.proyectoId}"/>">Ficha
				de Participantes</a></li>
		<li><a
			href="reportes.htm<c:out value="?id=${model.proyecto.proyectoId}"/>">Reporte</a></li>

	</ul> <!-- END Submenu --></li>
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
			<h1>Detalles de Proyecto</h1>
		</div>
	</div>
	<!-- END Page Title -->

	<!-- BEGIN Breadcrumb -->
	<div id="breadcrumbs">
		<ul class="breadcrumb">
			<li><i class="icon-home"></i> <a href="home.html">Home</a> <span
				class="divider"><i class="icon-angle-right"></i></span></li>
			<li class="active">Nuevo Proyecto</li>
		</ul>
	</div>
	<!-- END Breadcrumb -->

	<!-- BEGIN Main Content -->
	<div class="row-fluid">
		<div class="box box-pink">
			<div class="box-title">
				<h3>
					<i class="icon-text-height"></i>Detalles del Proyecto
				</h3>
				<div class="box-tool">
					<a data-action="collapse" href="#"><i class="icon-chevron-up"></i></a>
					<a data-action="close" href="#"><i class="icon-remove"></i></a>
				</div>
			</div>
			<div class="box-content">
				<table>
					<tr>
						<td width="19%" class="celdas"><b>Nombre del Proyecto:</b></td>
						<td width="17%" class="celdas">${model.proyecto.nombre}</td>
						<td width="16%">&nbsp;</td>
						<td height="25" colspan="2">&nbsp;</td>
						<td width="12%" class="celdas">&nbsp;</td>
						<td width="11%" class="celdas">&nbsp;</td>
						<td width="8%" class="celdas">&nbsp;</td>
					</tr>
					<tr>
						<td><b>Descripci&oacute;n Narrativa:</b></td>
						<td height="20" colspan="2">${model.proyecto.descripcion}</td>
						<td width="9%" height="20">&nbsp;</td>
						<td width="8%">&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td><b>Fecha de Inicio:</b></td>
						<td height="20"><fmt:formatDate
								value="${model.proyecto.fechaInicio}" type="both"
								pattern="dd/MM/yyyy" /></td>
						<td><b>Fecha de Fin:</b></td>
						<td><fmt:formatDate value="${model.proyecto.fechaFin}"
								type="both" pattern="dd/MM/yyyy" /></td>
						<td>&nbsp;</td>
						<td><b>Duraci&oacute;n(meses):</b></td>
						<td>${model.proyecto.duracionMeses}</td>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td><b>&Aacute;rea del proyecto:</b></td>
						<td height="20"><c:out
								value="${model.proyecto.areaId.nombre}" /></td>
						<td>&nbsp;</td>
						<td>Pa&iacute;s:</td>
						<td><c:out value="${model.proyecto.paisId.nombre}" /></td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
					</tr>

				</table>
			</div>
		</div>
	</div>
	<div class="row-fluid">
		<div class="box box-pink">
			<div class="box-title">
				<h3>
					<i class="icon-text-height"></i>Usuarios Proyecto
				</h3>
				<div class="box-tool">
					<a data-action="collapse" href="#"><i class="icon-chevron-up"></i></a>
					<a data-action="close" href="#"><i class="icon-remove"></i></a>
				</div>
			</div>
			<div class="box-content">
				<table class="table table-advance">
					<thead>
						<tr>
							<th>Nombres</th>
							<th>Apellidos</th>
							<th>DNI</th>
							<th>Perfil</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${model.proyecto.proyectoUsuarioSet}" var="pu">
							<tr>
								<td><c:out value="${pu.usuario.nombre}" /></td>
								<td><c:out value="${pu.usuario.apellido}" /></td>
								<td><c:out value="${pu.usuario.docnum}" /></td>
								<td><c:out value="${pu.perfilId.nombre}" /></td>

							</tr>
						</c:forEach>
				</table>
			</div>
		</div>
	</div>
	<div class="row-fluid">
		<div class="box box-pink">
			<div class="box-title">
				<h3>
					<i class="icon-text-height"></i>Objetivos del Proyecto
				</h3>
				<div class="box-tool">
					<a data-action="collapse" href="#"><i class="icon-chevron-up"></i></a>
					<a data-action="close" href="#"><i class="icon-remove"></i></a>
				</div>
			</div>
			<div class="box-content">
				<table id="table1" class="table">
					<tr>
						<th>Nivel del Indicador</th>
						<th>Codigo</th>
						<th>Descripcion</th>
						<th>Indicadores</th>
						<th>Supuesto</th>
						<th></th>
					</tr>
					<c:forEach items="${model.objetivos}" var="objetivo">
						<tr class="<c:out value="${objetivo.tipoobjetivo2}" />">
							<td><input type="text" disabled=""
								value="<c:out value="${objetivo.tipoobjetivo2}" />"
								name="<c:out value="${objetivo.tipoobjetivo2}" />[<c:out value="${objetivo.codigo-1}"/>][nivel]"
								class="span6"></input> <input type="hidden" disabled=""
								value="<c:out value="${objetivo.objetivoId}"/>"
								name="<c:out value="${objetivo.tipoobjetivo2}" />[<c:out value="${objetivo.codigo-1}"/>][id]"
								id="<c:out value="${objetivo.tipoobjetivo2}" />[<c:out value="${objetivo.codigo-1}"/>][id]" />

							</td>
							<td><input
								name="<c:out value="${objetivo.tipoobjetivo2}" />[<c:out value="${objetivo.codigo-1}"/>][codigo]"
								id="<c:out value="${objetivo.tipoobjetivo2}" />[<c:out value="${objetivo.codigo-1}"/>][codigo]"
								type="text" value="<c:out value="${objetivo.codigo}"/>"
								class="span3" /></td>
							<td><textarea class="input-large"
									name="<c:out value="${objetivo.tipoobjetivo2}" />[<c:out value="${objetivo.codigo-1}"/>][descripc]"
									id="<c:out value="${objetivo.tipoobjetivo2}" />[<c:out value="${objetivo.codigo-1}"/>][descripc]"
									cols="30" rows="4" />
								<c:out value="${objetivo.descripcion}" />
								</textarea></td>
							<td><c:forEach items="${objetivo.indicadorSet}"
									var="indicador" varStatus="counter">
									<a href="#" id="">${indicador.nombre}</a>
									<img src="images/delete.png" alt="Eliminar">
									<img src="images/edit.png" alt="Editar">
									<br />
								</c:forEach> <a href="#indicadores" role="button" class="indicadores"
								data-toggle="modal"
								id="<c:out value="${objetivo.tipoobjetivo2}" />[<c:out value="${objetivo.codigo-1}"/>][indicador]"><i
									class="icon-plus"></i></a></td>
							<td><c:forEach items="${objetivo.supuestoSet}"
									var="supuesto" varStatus="counter">
									<textarea class="input-large"
										name="<c:out value="${objetivo.tipoobjetivo2}" />[<c:out value="${objetivo.codigo-1}"/>][supuesto][<c:out value="${supuesto.supuestoId}"/>]"
										id="<c:out value="${objetivo.tipoobjetivo2}" />[<c:out value="${objetivo.codigo-1}"/>][supuesto][<c:out value="${supuesto.supuestoId}"/>]"
										cols="30" rows="4"><c:out
											value="${supuesto.supuesto}" /></textarea>
								</c:forEach> <a class="supuesto" href="#"
								id="<c:out value="${objetivo.tipoobjetivo2}" />[<c:out value="${objetivo.codigo-1}"/>][supuesto]"><i
									class="icon-plus"></i></a></td>
							<td><c:if test="${objetivo.tipoObjetivoId == 1}">
									<input type="button" class="add1" value="Agregar"
										name="finalidad[<c:out value="${objetivo.codigo-1}"/>][agregar]" />
								</c:if> <c:if test="${objetivo.tipoObjetivoId == 2}">
									<input type="button" class="add2" value="Agregar"
										name="proposito[<c:out value="${objetivo.codigo-1}"/>][agregar]" />
								</c:if> <c:if test="${objetivo.tipoObjetivoId == 3}">
									<input type="button" class="add3" value="Agregar"
										name="resultado[<c:out value="${objetivo.codigo-1}"/>][agregar]" />
								</c:if> <br />
							<c:if test="${objetivo.tipoObjetivoId == 1}">
									<input type="button" class="del1" value="Eliminar"
										name="finalidad[<c:out value="${objetivo.codigo-1}"/>][eliminar]" />
								</c:if> <c:if test="${objetivo.tipoObjetivoId == 2}">
									<input type="button" class="del2" value="Eliminar"
										name="proposito[<c:out value="${objetivo.codigo-1}"/>][eliminar]" />
								</c:if> <c:if test="${objetivo.tipoObjetivoId == 3}">
									<input type="button" class="del3" value="Eliminar"
										name="resultado[<c:out value="${objetivo.codigo-1}"/>][eliminar]" />
								</c:if> <br />
							<c:if test="${objetivo.tipoObjetivoId == 1}">
									<input type="button" class="save" value="Guardar"
										name="finalidad[<c:out value="${objetivo.codigo-1}"/>][guardar]" />
								</c:if> <c:if test="${objetivo.tipoObjetivoId == 2}">
									<input type="button" class="save" value="Guardar"
										name="proposito[<c:out value="${objetivo.codigo-1}"/>][guardar]" />
								</c:if> <c:if test="${objetivo.tipoObjetivoId == 3}">
									<input type="button" class="save" value="Guardar"
										name="resultado[<c:out value="${objetivo.codigo-1}"/>][guardar]" />
								</c:if></td>
						</tr>
					</c:forEach>

				</table>
			</div>
			<div style="display: none;">
				<table id="table2" class="table">
					<tr>
						<th>Nivel del Indicador</th>
						<th>Codigo</th>
						<th>Descripcion</th>
						<th>Indicadores</th>
						<th>Supuesto</th>
						<th></th>
					</tr>

					<tr class="finalidad">
						<td><input type="text" disabled="" value="finalidad"
							name="finalidad[0][nivel]" class="span6"></input> <input
							type="hidden" disabled="" value="" name="finalidad[0][id]"
							id="finalidad[0][id]" /></td>
						<td><input name="finalidad[0][codigo]"
							id="finalidad[0][codigo]" type="text" value="1" class="span3" />
						</td>
						<td><textarea class="input-large"
								name="finalidad[0][descripc]" id="finalidad[0][descripc]"
								cols="30" rows="4" /></textarea></td>
						<td><a href="#indicadores" role="button" class="indicadores"
							data-toggle="modal" id="finalidad[0][indicador]"><i
								class="icon-plus"></i></a></td>
						<td><a class="supuesto" href="#" id="finalidad[0][supuesto]"><i
								class="icon-plus"></i></a></td>
						<td><input type="button" class="add1" value="Agregar"
							name="finalidad[0][agregar]" /> <br />
						<input type="button" class="del1" value="Eliminar"
							name="finalidad[0][eliminar]" /> <br />
						<input type="button" class="save" value="Guardar"
							name="finalidad[0][guardar]" /></td>
					</tr>

					<tr class="proposito">
						<td><input type="text" disabled="" value="proposito"
							name="proposito[0][nivel]" class="span6"></input> <input
							type="hidden" disabled="" value="" name="proposito[0][id]"
							id="proposito[0][id]" /></td>
						<td><input name="proposito[0][codigo]"
							id="proposito[0][codigo]" type="text" value="1" class="span3" />
						</td>
						<td><textarea class="input-large"
								name="proposito[0][descripc]" id="proposito[0][descripc]"
								cols="30" rows="4" /></textarea></td>
						<td><a href="#indicadores" role="button" class="indicadores"
							data-toggle="modal" id="proposito[0][indicador]"><i
								class="icon-plus"></i></a></td>
						<td><a class="supuesto" href="#" id="proposito[0][supuesto]"><i
								class="icon-plus"></i></a>
						<td><input type="button" class="add2" value="Agregar"
							name="proposito[0][agregar]" /> <br /> <input type="button"
							class="del2" value="Eliminar" name="proposito[0][eliminar]" /> <br />
							<input type="button" class="save" value="Guardar"
							name="proposito[0][guardar]" /></td>
					</tr>

					<tr class="resultado">
						<td><input type="text" disabled="" value="resultado"
							name="resultado[0][nivel]" class="span6"></input> <input
							type="hidden" disabled="" value="" name="resultado[0][id]"
							id="resultado[0][id]" /></td>
						<td><input name="resultado[0][codigo]"
							id="resultado[0][codigo]" type="text" value="1" class="span3" />
						</td>
						<td><a class="supuesto" href="#" id="proposito[0][supuesto]"><i
								class="icon-plus"></i></a>
						<td><a href="#indicadores" role="button" class="indicadores"
							data-toggle="modal" id="resultado[0][indicador]"><i
								class="icon-plus"></i></a></td>
						<td></td>
						<td><input type="button" class="add3" value="Agregar"
							name="resultado[0][agregar]" /> <br /> <input type="button"
							class="del3" value="Eliminar" name="resultado[0][eliminar]" /> <br />

							<input type="button" class="save" value="Guardar"
							name="resultado[0][guardar]" /></td>
					</tr>


				</table>
			</div>
		</div>

	</div>
	<div id="indicadores" class="modal hide" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal"
				aria-hidden="true">×</button>
			<h3 id="myModalLabel">Agregar Indicador</h3>
		</div>
		<div class="modal-body">
			<form id="objetivosform" action="detalles_proyecto.htm" method="POST">
				<input type="hidden" name="objetivoIdIndicador"
					id="objetivoIdIndicador" /> <input type="hidden" name="proyectoId"
					id="proyectoId" value="${model.proyecto.proyectoId}" />

				<table
					style="width: 995; height: 262; border: 0; cellpadding: 0; cellspacing: 0">
					<tr>
						<td height="204" colspan="2"><table width="599" height="204"
								border="0">
								<tr>
									<td height="21">&nbsp;</td>
									<td width="172"><strong>Nombre :</strong></td>
									<td colspan="2"><input name="nombre" type="text"
										class="field" id="nombre" size="30" required="" /></td>
								</tr>
								<tr>
									<td height="21">&nbsp;</td>
									<td><strong>Descrpci&oacute;n:</strong></td>
									<td colspan="2"><input name="descripcion" type="text"
										class="field" id="descripcion" size="30" required="" /></td>
								</tr>
								<tr>
									<td width="40">&nbsp;</td>
									<td width="172"><strong>Forma de calculo :</strong></td>
									<td colspan="2"><input name="calculo" type="text"
										class="field" id="calculo" size="50" required="" /></td>
								</tr>

								<tr>
									<td>&nbsp;</td>
									<td><strong>Fuente :</strong></td>
									<td colspan="2"><select name="fuente" id="fuente">
											<option>Seleccione</option>
											<option value="1">Primaria</option>
											<option value="2">Secundaria</option>
									</select></td>
								</tr>
								<tr>
									<td>&nbsp;</td>
									<td><strong>Modo Pre-calculo:</strong></td>
									<td colspan="2"><select name="modo" id="modo"
										onChange="cambiarModo();">
											<option value="0">Ingreso Directo</option>
											<option value="1">Pre-configurado</option>
									</select></td>
								</tr>
								<tr id="directo">
									<td>&nbsp;</td>
									<td><strong>Medio de verificaci&oacute;n :</strong></td>
									<td><input name="medio" type="text" class="field"
										id="medio" size="50" /></td>
									<td><input type="button" class="boton" id="agregarMdo"
										onClick="agregarModo();" " value="Agregar" /></td>
								</tr>
								<tr>
									<td colspan="2" id="tdtablamedios">
										<table id="tablamedios">
											<tr>
												<td>Ficha</td>
												<td></td>
												<td></td>
											</tr>
										</table>
									</td>
								<tr>
								<tr id="preconfigurado" style="display: none">
									<td>&nbsp;</td>
									<td><strong>Medio de verificaci&oacute;n :</strong></td>
									<td colspan="2">
										<table>
											<tr>
												<td>Ficha</td>
												<td><select name="mficha" id="mficha">
														<option value="0">ficha1</option>
														<option value="0">ficha2</option>
														<option value="0">ficha3</option>
														<option value="0">ficha4</option>
												</select></td>
											</tr>
											<tr>
												<td>Indicador</td>
												<td><select name="mindicador" id="mindicador">
														<option value="0">indicador1</option>
														<option value="0">indicador2</option>
														<option value="0">indicador3</option>
														<option value="0">indicador4</option>
												</select></td>
											</tr>
										</table>
									</td>
								</tr>
								<tr>
									<td height="21">&nbsp;</td>
									<td><strong>Periodicidad de reporte:</strong></td>
									<td colspan="2"><select name="periodicidad"
										id="periodicidad">
											<option value="1">Diaria</option>
											<option value="2">Mensual</option>
											<option value="3">Quincenal</option>
									</select></td>
								</tr>
								<tr>
									<td height="21" align="center">&nbsp;</td>
									<td><strong>Valor Inicial</strong></td>
									<td colspan="2"><input name="valorinicial" type="text"
										class="field" id="valorinicial" size="20" required="" /></td>
								</tr>
								<tr>
									<td height="21" align="center">&nbsp;</td>
									<td><strong>Valor Final</strong></td>
									<td colspan="2"><input name="valorfinal" type="text"
										class="field" id="valorfinal" size="20" required="" /></td>
								</tr>
								<tr>
									<td height="21" align="center">&nbsp;</td>
									<td><strong>Documento de reporte:</strong></td>
									<td colspan="2" align="center"><input
										name="documentoreporte" type="text" class="field"
										id="documentoreporte" size="20" required="" /></td>
								</tr>
								<tr>
									<td height="21" align="center">&nbsp;</td>
									<td><strong>Responsable</strong></td>
									<td colspan="2" align="center"><select name="responsable"
										id="responsable" required="">
											<option value="0">Seleccione</option>
											<option value="1">Juan</option>
											<option value="2">Diego</option>
											<option value="3">Pedro</option>
									</select></td>
								</tr>
								<tr>
									<td height="21" align="center">&nbsp;</td>
									<td>&nbsp;</td>
									<td colspan="2" align="center">&nbsp;</td>
								</tr>
								<tr>
									<td height="21" align="center">&nbsp;</td>
									<td align="center">&nbsp;</td>
									<td width="16" align="center"><input name="Button"
										type="button" class="boton" value="Agregar Indicador"
										onClick="agregarIndicador();" /></td>
									<td width="353"
										style="padding-right: 12px; text-align: right; font-size: 9px;">&nbsp;</td>
								</tr>

							</table></td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td
							style="padding-right: 12px; text-align: right; font-size: 9px;"><a
							href="javascript:esconder('2');">Cerrar</a></td>
					</tr>
				</table>
			</form>
		</div>

		<div class="modal-footer">
			<button class="btn" data-dismiss="modal" aria-hidden="true">Close</button>
			<button class="btn btn-primary" data-dismiss="modal">Save
				changes</button>
		</div>
	</div>


	<%@ include file="/WEB-INF/views/inc.footer.jsp"%>

	<script type="text/javascript">
var medios = {"medios": []};
function addNivel(elem,nivel){
	var tr = $("#table2").find('tr.'+nivel+':first').clone();
	var control = $("#table1").find('tr.'+nivel+':last').find('input, select, textarea')[0] || false;
	var encontrar = elem.name.substring(0,elem.name.length-9);
	var indice = parseInt(elem.name.substring(10,elem.name.length-10));
	var trs = indice + 1 ;
	var cambiar = false;
	var t_descripcion =elem.name.substring(0,elem.name.length-8)+"descripc]";
	var t_supuesto =elem.name.substring(0,elem.name.length-8)+"supuesto]";
	var t_codigo =elem.name.substring(0,elem.name.length-8)+"codigo]";
	t_codigo = document.getElementById(t_codigo).value;
	t_codigo = parseInt(t_codigo);
	var proyecto_id = $("#proyectoId").val();
	t_codigo = t_codigo +1;
	var tipo;
	switch(nivel){
	case "finalidad":
		tipo = 1;
		break;
	case "proposito":
		tipo = 2;
		break;
	case "resultado":
		tipo = 3;
		break;
	}
	if(document.getElementById(t_descripcion).value == ""){
		alert("Debe rellenar todos los datos");
		return false;
	}else{
		var nuevo_id = "0";
		$.ajax({
		    type: "POST",
		    url: "/proyecto/agregarobjetivos.htm",
		    data: "proyecto_id="+proyecto_id+"&codigo="+t_codigo+"&tipo="+tipo+"&action=insert",
		    success: function(response){
		    	nuevo_id = response;
		    },
		    error: function(e){
			    alert('Error: ' + e.type);
	
		    }
		  }); 
		$(tr).find("input, textarea, select").each(function(index, elem2) {
	       var newName = '';
	       newName = elem2.name.replace(/\[[0-9]+\]/i, '[' + (trs) + ']');
	       if(newName.indexOf("codigo") != -1){
				elem2.value = trs + 1;
			}
			if(elem2.type == 'checkbox' || elem2.type == 'radio') {
		           $(elem2).attr({'name': newName, 'checked': false});
		       }else if(elem2.type == 'button' || newName.indexOf("nivel") != -1){
				$(elem2).attr({'name': newName});
			}else{
		           $(elem2).attr({'name': newName});
		           if(newName.indexOf("codigo") == -1)$(elem2).val('');
	       }
	       $(elem2)
		 });
		var encnt = 'tr.'+nivel;
		$("#table1").find('tr.'+nivel).each(function (i,e){
			
			if(i > indice){
				$(e).find("input, textarea, select").each(function(index, elem2) {
					nuevovalor = i + 1;
					newName = elem2.name.replace(/\[[0-9]+\]/i, '[' + nuevovalor + ']');
					$(elem2).attr({'name': newName});
					if(newName.indexOf("codigo") != -1){
						elem2.value = nuevovalor+1;
					}
					$(elem2)
				});
			}
			
		
		});
		$("#table1").find('tr.'+nivel).each(function (i,e){
			if(i== indice){		
				$(e).after(tr);
				return;
			}	
		
		});
	}
}
function delNivel(elem,nivel){
	var indice = parseInt(elem.name.substring(10,elem.name.length-11));
	var t_id =elem.name.substring(0,elem.name.length-9)+"id]";
	var id = document.getElementById(t_id).value;
	var t_codigo =elem.name.substring(0,elem.name.length-9)+"codigo]";
	if($("#table1").find('tr.'+nivel).length > 1){
		t_codigo = document.getElementById(t_codigo).value;
		t_codigo = parseInt(t_codigo);
		$.ajax({
		    type: "POST",
		    url: "/proyecto/eliminarobjetivo.htm",
		    data: "id="+id+"&codigo="+t_codigo,
		    success: function(response){
		    	alert(response);
		    },
		    error: function(e){
			    alert('Error: ' + e.type);

		    }
		  });
		$("#table1").find('tr.'+nivel).each(function (i,e){
		if(i > indice){
			$(e).find("input, textarea, select").each(function(index, elem2) {
				nuevovalor = i - 1;
				newName = elem2.name.replace(/\[[0-9]+\]/i, '[' + nuevovalor+ ']');
				$(elem2).attr({'name': newName});
				if( newName.indexOf("codigo") != -1){
					elem2.value = nuevovalor+1;
				}
				$(elem2)
			});
		}
		});
	
		$(elem).closest('tr').remove(); 
		}
 }

$(document).ready(function(){
  $(document).on("click",'.add1', function(){
	addNivel(this,"finalidad");
  });
  $(document).on("click",'.del1', function(){
	delNivel(this,"finalidad");
  });
  $(document).on("click",'.del2', function(){
	delNivel(this,"proposito");
  });
  $(document).on("click",'.del3', function(){
	delNivel(this,"resultado");
  });
  $(document).on("click",'.add2', function(){
	addNivel(this,"proposito");
  });
   $(document).on("click",'.add3', function(){
	addNivel(this,"resultado");
  });
   $(document).on("click",'.save', function(){
		save(this);
	  });
   $(".indicadores").click(function() {
	   var botonid = this.id;
	   id = botonid.substring(0,botonid.length-10)+"id]";	   
	   objetivo_id = document.getElementById(id).value
	   $("#objetivoIdIndicador").val(objetivo_id);
   });
   $(".supuesto").click(function() {
	   var elem = this;
	   var t_id =this.id.substring(0,this.id.length-9)+"id]";
		var t_descripcion=this.id.substring(0,this.id.length-9)+"descripc]";
		var t_supuesto=this.id.substring(0,this.id.length-9)+"supuesto]";
		var t_codigo=this.id.substring(0,this.id.length-9)+"codigo]";
		var id = document.getElementById(t_id).value;
		
		$.ajax({
		    type: "POST",
		    url: "/proyecto/agregarsupuesto.htm",
		    data: "id="+id,
		    success: function(response){	
		    	var texto = '<textarea id="';
		    	texto = texto + elem.id +'['+response+']';
		    	texto = texto + '" class="input-large" rows="4" cols="30"';
		    	texto = texto + 'name="'+elem.id +'['+response+']'+'"></textarea>';
		    	$(elem).before(texto);
		    },
		    error: function(e){
			    alert('Error: ' + e.type);

		    }
		  });

   });
});
function save(elem){
	var t_id =elem.name.substring(0,elem.name.length-8)+"id]";
	var t_descripcion=elem.name.substring(0,elem.name.length-8)+"descripc]";
	var t_supuesto=elem.name.substring(0,elem.name.length-8)+"supuesto]";
	var t_codigo=elem.name.substring(0,elem.name.length-8)+"codigo]";
	id = document.getElementById(t_id).value;
	descripcion = document.getElementById(t_descripcion).value;
	supuesto = document.getElementById(t_supuesto).value;
	codigo =  document.getElementById(t_codigo).value;
	$(elem).closest('tr').find(t_supuesto)each(function(i) {
		supuestos.supuestos.push({"supuesto": $(this).val(),"id": this.id});
		
	});
	$.ajax({
	    type: "POST",
	    url: "/proyecto/actualizarobjetivo.htm",
	    data: "id="+id+"&desc="+descripcion+"&sup="+supuesto+"&codigo="+codigo,
	    success: function(response){
	    },
	    error: function(e){
		    alert('Error: ' + e.type);

	    }
	  });
}

function cambiarModo(){
	if($("#modo option:selected").val()=="0"){
		$("#directo").css("display", "");
		$("#preconfigurado").css("display", "none");
		$("#tablamedios").css("display", "");
	}
	if($("#modo option:selected").val()=="1"){
		$("#directo").css("display", "none");
		$("#preconfigurado").css("display", "");
		$("#tablamedios").css("display", "none");
		medios = {"medios": []};
		var trs=$("#tablamedios tr").length; 
		while(trs>1) {
			 $("#tablamedios tr:last").remove(); 
			 trs=$("#tablamedios tr").length; 
		}
	}
}
function deleteModo(elem){
	$(elem).closest('tr').remove(); 
}
function agregarModo(){
	medios.medios.push({"ficha": $("#mficha").val(), "indicador": $("#mindicador").val()});
 	tds ="<tr>";
		tds += '<td>'+$("#medio").val()+'</td>';
		tds += '<td><img src="images/delete.png" alt="Eliminar" onClick="deleteModo(this)"></td>';
		tds += '<td>'+'</td>';
	tds +="</tr>";
	$("#mficha").val("");
	$("#mindicador").val("");
	$("#tdtablamedios").css("display", "");
	$("#tablamedios").append(tds);
}

function agregarIndicador(){
	if($("#nombre").val()==""|| $("#descripcion").val()=="" || $("#calculo").val()=="" || $("#fuente").val()=="0" || $("#valorinicial").val()==""  || $("#valorfinal").val()==""  || $("#responsable").val()=="0" ){
		alert("Ingrese todos los datos");
		return false;
	}
	if($("#modo option:selected").val()=="1"){
		if(medios.medios.length > 0){
			$("#mediosverificacionjson").val(JSON.stringify(medios.medios, null, 2));
			$("#objetivosform").submit();
		}else{
			alert("Debe agregar al menos un medio de verificacion");
			return false;
		}
	}else{
		if($("#medio").val()==""){
			alert("Debe agregar el medio de verificacion");
			return false;
		}
	}
	$("#objetivosform").submit();
	
	
}
</script>