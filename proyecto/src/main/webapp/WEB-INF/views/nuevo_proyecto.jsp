<%@ include file="/WEB-INF/views/include.jsp"%>
<%@ include file="/WEB-INF/views/css.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Nuevo Proyecto</title>
<script type="text/javascript">
$(document).ready(function(){
	$("#fecha_inicio").datepicker({ dateFormat: "dd/mm/yy" });
});
var usuarios = {"usuarios": []};
var regiones = {"regiones":[]};
var dnis = new Array();
var arrayregiones = new Array();

function validarUsuario(){
	if(!validateEmail($("#correo").val()) || $("#nombres").val()=="" || $("#apellidos").val()=="" || $("#cargo").val()=="" || $("#dni").val()=="" || $("#pais_id2").val()=="0"|| $("#perfil").val()=="0"){
		alert("Por favor llene todos los datos correctamente");
	}else{
		if(jQuery.inArray($("#dni").val(), dnis) == -1){
			var usuario = [  $("#dni").val(), $("#nombres").val(), $("#apellidos").val(), $("#pais_id2 option:selected").text(),$("#correo").val(), $("#cargo").val(), $("#perfil option:selected").text()];
		 	usuarios.usuarios.push({"nombres": $("#nombres").val(), "apellidos": $("#apellidos").val(), "pais": $("#pais_id2").val() , "dni":$("#dni").val(),"correo":$("#correo").val(),"cargo":$("#cargo").val(),"perfil":$("#perfil").val()});
			dnis.push($("#dni").val());
		 	tds ="<tr>";
			for(var i = 0; i < 7; i++){
				tds += '<td>'+usuario[i]+'</td>';
				}
			tds +="</tr>";
			$("#tablausuarios").append(tds);
			$("#usuariosjson").val(JSON.stringify(usuarios.usuarios, null, 2));
			$("#regionesjson").val(JSON.stringify(regiones.regiones, null, 2));
			//alert($("#usuariosjson").val());
			$("#dialog2").dialog("close");
			$("#dni").val("");
			$("#nombres").val("");
			$("#apellidos").val("");
			$("#cargo").val("");
			$("#correo").val("");
			$("#perfil").val(0);
			$("#pais_id2").val(0);
		}else{
			alert("el documento ya existe");
		}
	}
}
function VerificaFechaInicio()
{
    if($("#fecha_inicio").val() != '')
    {
        var idia = parseInt($("#fecha_inicio").val().substr(0, 2));
        nuevafecha = "01"+$("#fecha_inicio").val().substr(2, 10);
        $("#fecha_inicio").val(nuevafecha);
    }

}

function CalculaFechaFin()
{
    if($("#fecha_inicio").val() != '')
    {
        var numdiasmes = new Array(31,28,31,30,31,30,31,31,30,31,30,31);

        var idia = parseInt($("#fecha_inicio").val().substr(0, 2));
        var imes = parseInt($("#fecha_inicio").val().substr(3, 2));
        var ianio = parseInt($("#fecha_inicio").val().substr(6, 4));
        var meses = parseInt($("#duracion").val());
        var tanio = meses/12 - (meses/12)%1;
        var tmes = meses - tanio*12;

        var nmes = imes+tmes;
        var nanio = ianio+tanio;
        nmes = nmes + 1;
        if(nmes >= 12){
            nmes = nmes - 12;
            nanio = nanio +1;
        }

        if(nmes == 1){
            nmes = 12;
            nanio = nanio - 1;
        }else{
            nmes = nmes - 1;
        }
        
        var ndia = numdiasmes[nmes-1];

        var bisiesto = false;
        if(nanio % 100 == 0) {
            if(nanio % 400 == 0) {
                bisiesto = true;
            } else {
                bisiesto = false;
            }
        }else{
            if(nanio % 4 == 0) {
                bisiesto = true;
            }else {
                bisiesto = false;
            }
        }

        if(bisiesto && nmes==2){
            ndia = 29;
        }
        if(nmes < 10)
            nmes = '0'+nmes;
        if(ndia < 10)
            ndia = '0'+ndia;
		ndia = '01';
		
        $("#fecha_fin").val(ndia+'/'+nmes+'/'+nanio) ;
    }

}
function loadUbigeo() {
    // get the form values
    var pais = $('#pais_id').val();
    var data = "";
    var region_id = provincia_id = distrito_id =0;
    if($('#region_id').val()){
    	data+="region_id="+$('#region_id').val();
    	region_id = $('#region_id').val();
    }
    if($('#provincia_id').val()){
    	data+="&provincia_id="+$('#provincia_id').val();
    	provincia_id = $('#provincia_id').val();
    	
    }
    if($('#distrito_id').val()){
    	data+="&distrito_id="+$('#distrito_id').val();
    	distrito_id = $('#distrito_id').val();
    }
    if(parseInt(pais)==1){
    	$.ajax({
    	    type: "POST",
    	    url: "/proyecto/ubigeo.htm",
    	    data: data,
    	    success: function(response){
    	    // we have the response
    	    $('#ubigeo').html(response);
    	    $('#region_id').val(region_id);
    	    $('#provincia_id').val(provincia_id);
    	    $('#distrito_id').val(distrito_id);
    	    },
    	    error: function(e){
    	    alert('Error: ' + e);
    	    }
   	  });
    	
    }else{
    	 $('#ubigeo').html("");
    }

    
}
function mostrarDialog(id){
	$('#dialog'+id).dialog({
		  width: 600,
	      modal: false});
}
function agregarUsuario(){
	if($('#nombrepro').val()==""){
		alert("Debes digitar un nombre");
		$('#nombrepro').focus();
		return false;
	}else if($('#area').val()=="0"){
		alert("Debes seleccionar un area");
		$('#area').focus();
		return false;
	}else if($('#fecha_inicio').val()=="0"){
		$('#fecha_inicio').focus();
		alert("Debes seleccionar una fecha");
		return false;
	}
	else if($('#pais_id').val()=="0"){
		alert("Debes seleccionar un pais");
		$('#pais_id').focus();
		return false;
	}else if(parseInt($('#pais_id').val())==1){ 
		var comunidades_id = $("#comunidad_id").val() || [];
		comunidades_id = comunidades_id.join(",");
		$("<input id='comunidades_id' type='hidden' name='comunidades_id' value='"+comunidades_id+"'>").appendTo("#nuevoproyecto");
		if(comunidades_id == ""){
			alert("Debes seleccionar al menos una comunidad");
			 $("#comunidad_id").focus();
			return false;
		}
	}else if(false){
		alert("Debes agregar al menos un usuario");
		return false;
	}
		
	
	$("#usuariosjson").val(JSON.stringify(usuarios.usuarios, null, 2));
	$("#nuevoproyecto").submit();
}


function agregarUbigeo(){
	var region_id = 0;
	var provincia_id = 0;
	var distrito_id = 0;
	var comunidades_id = 0;
	var region = "Todas";
	var provincia = "Todas";
	var comunidades = "Todas";
	var distrito = "Todas";
	
	if($("#region_id").val()){
		region_id = $("#region_id").val();
		region = $("#region_id option:selected").text();
	}
	if($("#provincia_id").val()){
		provincia_id = $("#provincia_id").val();
		provincia = $("#provincia_id option:selected").text();
	}
	if($("#distrito_id").val()){
		distrito_id = $("#distrito_id").val();
		distrito = $("#distrito_id option:selected").text();
	}
	if($("#comunidad_id").val()){
		comunidades_id = $("#comunidad_id").val() || [];
		comunidades_id = comunidades_id.join(",");
		comunidades = $("#comunidad_id option:selected").text() || [];
	}
	var regionu = [region_id, provincia_id , distrito_id , comunidades_id  ];
	var regionnombre = [region, provincia , distrito , comunidades  ];
 	
	var agregado = false;
	$.each(arrayregiones, function(index, value) {
		if($(value).not(regionu).length == 0 && $(regionu).not(value).length == 0){
			alert("Ya se agrego esta region");
			agregado = true;
			return;			
		}
	});
	if(!agregado){
		regiones.regiones.push({"region_id": region_id, "provincia_id": provincia_id, "distrito_id": distrito_id , "comunidades_id":comunidades_id});
		arrayregiones.push(regionu);
		tds ="<tr>";
		for(var i = 0; i < 4; i++){
			tds += '<td>'+regionnombre[i]+'</td>';
			}
		tds +="</tr>";
		$("#regiones").append(tds);
	}
	

}
</script>
</head>
<body>
	<div id="tabs">
		<table>
			<tr>
				<td><ul>
						<li id="w" style="font: bold"><a href="nuevo_proyecto.htm"
							onmousedown="javascript:pre('0')"><span>Nuevo</span></a></li>
					</ul></td>
				<td><ul>
						<li id="w" style="font: bold"><a href="listado_proyectos.htm"
							onmousedown="javascript:pre('0')"><span>Proyectos</span></a></li>
					</ul></td>
			</tr>
		</table>
	</div>


	<div id="rightbar">
		<div id="seguimiento" class="panelContainer">
			<div id="panel">
				<div id="panelheader">
					<div id="title">Nuevo Proyecto</div>
					<div id="panelcontroller" onclick="switchPanel(this);">
						<img src="images/min.png" alt="" width="7" height="6" />
					</div>
				</div>
				<div id="content" style="height: 600x;">
					<form id="nuevoproyecto" action="nuevo_proyecto.htm" method="post">
						<input type="hidden" name="usuariosjson" id="usuariosjson"
							value="" /> <input type="hidden" name="regionesjson"
							id="regionesjson" value="" />
						<table>
							<tr>
								<td width="17%" height="27"><b>Nombre del Proyecto:</b></td>
								<td height="25" colspan="5"><input name="nombrepro"
									type="text" class="field" size="35" id="nombrepro" /></td>
							</tr>
							<tr>
								<td height="27" class="box"><b>Descripci&oacute;n
										Narrativa:</b></td>
								<td width="23%" height="25" class="box"><textarea
										name="descripcion" id="descripcion"></textarea></td>
								<td height="25" colspan="4" class="box">&nbsp;</td>
							</tr>

							<tr>
								<td height="27" class="box"><b>&Aacute;rea del
										proyecto:</b></td>
								<td height="25" class="box"><select name="area" id="area">
										<option value="0" selected="selected">--Seleccione el
											Area --</option>
										<c:forEach items="${model.areas}" var="area">
											<option value="<c:out value="${area.areaId}"/>"><c:out
													value="${area.nombre}" /></option>
										</c:forEach>
								</select></td>
								<td width="12%" height="25" class="box">&nbsp;</td>
								<td width="21%" height="25" class="box">&nbsp;</td>
								<td width="6%" height="25" class="box">&nbsp;</td>
								<td width="21%" height="25" class="box">&nbsp;</td>
							</tr>


							<tr>
								<td height="27" class="box"><b>Fecha de Inicio:</b></td>
								<td height="25" class="box"><input name="fecha_inicio"
									type="text" id="fecha_inicio" onChange="VerificaFechaInicio()" /></td>
								<td colspan="4" class="box"><b>Duraci&oacute;n(meses):
								</b> <input name="duracion" type="text" id="duracion" class="field"
									size="5" onChange="CalculaFechaFin()" /></td>
							</tr>
							<tr>
								<td height="27" class="box"><b>Fecha de Fin:</b></td>
								<td height="25" class="box"><input name="fecha_fin"
									type="text" class="field" id="fecha_fin" style="width: 65px;"
									autocomplete="off" readonly="readonly" /></td>
								<td colspan="4" class="box">&nbsp;</td>
							</tr>
							<tr>
								<td height="27" class="box"><b>Pais:</b></td>
								<td height="25"><select name="pais_id" id="pais_id"
									onChange="loadUbigeo()">
										<option value="0">Pais</option>
										<c:forEach items="${model.paises}" var="pais">
											<option value="<c:out value="${pais.paisId}"/>"><c:out
													value="${pais.nombre}" /></option>
										</c:forEach>
								</select></td>
								<td colspan="4" class="box">&nbsp;</td>
							</tr>

							<tr id="ubigeo">
							<tr>
							<tr>
								<td colspan="4"><table id="regiones"
										style="width: 995; border: 1px black; cellpadding: 0; cellspacing: 0">
										<tr
											style="background-color: orange; font-size: 12; align: center;">
											<th>Region</th>
											<th>Provincia</th>
											<th>Distritos</th>
											<th>Comunidades</th>
										</tr>
									</table></td>
							</tr>
							<td height="32" class="box"><b>Usuarios del Proyecto:</b></td>
							<td height="32" colspan="5" class="box"><input type="button"
								name="mostraragregarusuarios" value="Agregar Usuarios"
								class="boton" onclick="mostrarDialog(1)" /> &nbsp;</td>
							</tr>
							<tr>
								<td>
									<div id="dialog1" style="display: none">
										<table style="width: 500px; align: center" id="tablausuarios">
											<tr>
												<td class="dgtitle">DNI</td>
												<td class="dgtitle">Nombres</td>
												<td class="dgtitle">Apellidos</td>
												<td class="dgtitle">Pais</td>
												<td class="dgtitle">Correo</td>
												<td class="dgtitle">Cargo</td>
												<td class="dgtitle">Perfil</td>
											</tr>
										</table>
										<p>
											<input name="agregarusuario" type="button" class="boton"
												onclick="mostrarDialog(2)" value="Agregar Usuario" />
										</p>
									</div>
								</td>
							</tr>
							<tr>
								<td><div id="dialog2" style="display: none">
										<table style="width: 600px">
											<tr>
												<td height="21">&nbsp;</td>
												<td width="109"><strong>Pa&iacute;s</strong></td>
												<td><select name="pais_id2" id="pais_id2">
														<option value="0">Seleccione</option>
														<c:forEach items="${model.paises}" var="pais">
															<option value="<c:out value="${pais.paisId}"/>"><c:out
																	value="${pais.nombre}" /></option>
														</c:forEach>
												</select></td>
											</tr>
											<tr>
												<td height="21">&nbsp;</td>
												<td><strong>DNI:</strong></td>
												<td colspan="2"><input name="dni" type="text"
													class="field" id="dni" size="30" /></td>
											</tr>
											<tr>
												<td width="40">&nbsp;</td>
												<td width="109"><strong>Nombres :</strong></td>
												<td colspan="2"><input name="nombres" type="text"
													class="field" id="nombres" size="50" /></td>
											</tr>
											<tr>
												<td>&nbsp;</td>
												<td><strong>Apellidos :</strong></td>
												<td colspan="2"><input name="apellidos" type="text"
													class="field" id="apellidos" size="50" /></td>
											</tr>
											<tr>
												<td>&nbsp;</td>
												<td><strong>Correo :</strong></td>
												<td colspan="2"><input name="correo" type="text"
													class="field" id="correo" size="30" /></td>
											</tr>
											<tr>
												<td>&nbsp;</td>
												<td><strong>Cargo</strong></td>
												<td colspan="2"><input name="cargo" type="text"
													class="field" id="cargo" size="30" /></td>
											</tr>
											<tr>
												<td>&nbsp;</td>
												<td><strong>Perfil</strong></td>
												<td colspan="2"><select name="perfil" id="perfil">
														<option value="0">Seleccione</option>
														<c:forEach items="${model.perfiles}" var="perfil">
															<option value="<c:out value="${perfil.perfil_id}"/>"><c:out
																	value="${perfil.nombre}" /></option>
														</c:forEach>
												</select></td>
											</tr>

											<tr>
												<td height="21" align="center">&nbsp;</td>
												<td align="center">&nbsp;</td>
												<td colspan="2" align="center">&nbsp;</td>
											</tr>
											<tr>
												<td height="21" align="center">&nbsp;</td>
												<td align="center">&nbsp;</td>
												<td width="79" align="center"><input
													name="registrarusuario" type="button" class="boton"
													value="Regitrar Usuario" onclick="validarUsuario()" /></td>
												<td width="353"
													style="padding-right: 12px; text-align: right; font-size: 9px;">&nbsp;</td>
											</tr>
										</table>
									</div></td>
							</tr>
						</table>
						<p align="center">
							<input type="button" name="Submit32" value="Guardar"
								class="boton" onclick="agregarUsuario();" />
						</p>
					</form>

				</div>
			</div>
		</div>

	</div>

</body>
</html>