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
			<h1>Crear nuevo proyecto</h1>
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
		<div class="span12">
			<div class="box">
				<div class="box-title">
					<h3>
						<i class="icon-reorder"></i> Crear nuevo proyecto
					</h3>
					<div class="box-tool">
						<a data-action="collapse" href="#"><i class="icon-chevron-up"></i></a>
						<a data-action="close" href="#"><i class="icon-remove"></i></a>
					</div>
				</div>
				<div class="box-content">
					<form action="nuevoproyecto.htm" class="form-horizontal"
						method="post" id="validation-form" onSubmit="return validar()">
						<input type="hidden" name="usuariosjson" id="usuariosjson"
							value="" />

						<div class="control-group">
							<label class="control-label">Nombre del Proyecto:</label>
							<div class="controls">
								<input type="text" class="span6" name="nombre"
									data-rule-required="true" />
							</div>
						</div>
						<div class="control-group">
							<label class="control-label">Descripcion Narrativa del
								Proyecto</label>
							<div class="controls">
								<textarea class="span12 ckeditor" name="descripcion" rows="6"></textarea>
							</div>
						</div>
						<div class="control-group">
							<label class="control-label">&Aacute;rea del Proyecto</label>
							<div class="controls">
								<select class="span6" data-placeholder="Elija un &aacute;rea"
									tabindex="1" name="area">
									<c:forEach items="${model.areas}" var="area">
										<option value="<c:out value="${area.areaId}"/>"><c:out
												value="${area.nombre}" /></option>
									</c:forEach>
								</select>
							</div>
						</div>

						<div class="control-group">
							<label class="control-label">Fecha de Inicio</label>
							<div class="controls">
								<div class="input-append date date-picker" data-date=""
									data-date-format="dd/mm/yyyy" data-date-viewmode="days">
									<input class="span10" size="16" type="text" name="fechainicio"
										id="fechainicio" value="" data-rule-required="true" /><span
										class="add-on"><i class="icon-calendar"></i></span>
								</div>
							</div>
						</div>
						<div class="control-group">
							<label class="control-label">Duraci&oacute;n en meses</label>
							<div class="controls">
								<input class="span5" type="text" placeholder="" name="duracion"
									id="duracion" data-rule-required="true" data-rule-number="true"
									onChange="CalculaFechaFin()">
							</div>
						</div>
						<div class="control-group">
							<label class="control-label">Fecha de Fin</label>
							<div class="controls">
								<input class="span2" type="text" name="fechafin" id="fechafin"
									value="" data-rule-required="true" />
							</div>
						</div>
						<div class="control-group">
							<label class="control-label">Pa&iacute;s</label>
							<div class="controls">
								<select class="span6" name="pais_id" id="pais_id"
									onChange="loadUbigeo()" data-rule-required="true">
									<option>--Seleccione--</option>
									<c:forEach items="${model.paises}" var="pais">
										<option value="<c:out value="${pais.paisId}"/>"><c:out
												value="${pais.nombre}" /></option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div id="ubigeo"></div>
						<input type="hidden" name="regionesjson" id="regionesjson"
							value="" />
						<div class="control-group">
							<div class="controls">
								<div class="span6">
									<div class="box">
										<div class="box-content">
											<table class="table" id="regiones">
												<thead>
													<tr>
														<th>Region</th>
														<th>Provincia</th>
														<th>Distritos</th>
														<th>Comunidades</th>
													</tr>
												</thead>

											</table>
										</div>
									</div>
								</div>
							</div>

						</div>
						<div class="control-group">
							<label class="control-label">Usuarios</label>

							<div class="controls">
								<div class="box-content">
									<table class="table table-advance">
										<thead>
											<tr>
												<th style="width: 18px"></th>
												<th>Nombres</th>
												<th>Apellidos</th>
												<th>DNI</th>
												<th>Perfil</th>
											</tr>
										</thead>
										<tbody>
											<tr class="table-flag-blue">
												<td><input type="checkbox" name="usuarios[]"
													value="<c:out value="${model.miusuario.id}"/>"
													checked="checked" disabled="disabled" /></td>
												<td><c:out value="${model.miusuario.nombre}" /></td>
												<td><c:out value="${model.miusuario.apellido}" /></td>
												<td><c:out value="${model.miusuario.docnum}" /></td>
												<td><select
													name="perfil<c:out value="${model.miusuario.id}"/>"
													class="span6" id="perfil" class="input-xlarge"
													data-rule-required="true">
														<c:forEach items="${model.perfiles}" var="perfil">
															<option value="<c:out value="${perfil.perfilId}"/>"><c:out
																	value="${perfil.nombre}" /></option>
														</c:forEach>
												</select></td>
											</tr>
											<c:forEach items="${model.usuarios}" var="usuario">
												<tr class="table-flag-blue">
													<td><input type="checkbox" name="usuarios[]"
														value="<c:out value="${usuario.id}"/>" /></td>
													<td><c:out value="${usuario.nombre}" /></td>
													<td><c:out value="${usuario.apellido}" /></td>
													<td><c:out value="${usuario.docnum}" /></td>
													<td><select
														name="perfil<c:out value="${usuario.id}"/>" class="span6"
														id="perfil<c:out value="${usuario.id}"/>"
														class="input-xlarge" data-rule-required="true">
															<c:forEach items="${model.perfiles}" var="perfil">
																<option value="<c:out value="${perfil.perfilId}"/>"><c:out
																		value="${perfil.nombre}" /></option>
															</c:forEach>
													</select></td>
												</tr>
											</c:forEach>

										</tbody>
									</table>
								</div>
							</div>
						</div>

						<div class="form-actions">
							<button type="submit" class="btn btn-primary">Registrar</button>
							<button type="button" class="btn">Cancelar</button>
						</div>
					</form>

				</div>
			</div>
		</div>

	</div>





	<%@ include file="/WEB-INF/views/inc.footer.jsp"%>
	<script type="text/javascript">
var regiones = {"regiones":[]};
var arrayregiones = new Array();
var usuarios = {"usuarios": []};

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
function VerificaFechaInicio()
{
    if($("#fechainicio").val() != '')
    {
        var idia = parseInt($("#fechainicio").val().substr(0, 2));
        nuevafecha = "01"+$("#fechainicio").val().substr(2, 10);
        $("#fechainicio").val(nuevafecha);
    }

}

function CalculaFechaFin()
{
    if($("#fechainicio").val() != '')
    {
    	VerificaFechaInicio();
        var numdiasmes = new Array(31,28,31,30,31,30,31,31,30,31,30,31);

        var idia = parseInt($("#fechainicio").val().substr(0, 2));
        var imes = parseInt($("#fechainicio").val().substr(3, 5));
        var ianio = parseInt($("#fechainicio").val().substr(6, 10));
        var meses = parseInt($("#duracion").val());
        var tanio = meses/12 - (meses/12)%1;
        var tmes = meses - tanio*12;
        var nmes = parseInt(imes+tmes);
        var nanio = parseInt(ianio+tanio);
        nmes = nmes + 1;
        if(nmes > 12){
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
        $("#fechafin").val(ndia+'/'+nmes+'/'+nanio) ;
    }

}
function validar(){
		$("input:checked").each(function(i) {
		 	usuarios.usuarios.push({"id": $(this).val()});
		});
		$("#usuariosjson").val(JSON.stringify(usuarios.usuarios, null, 2));

	return true;
	}
</script>
	</body>
	</html>