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
			<h1>Mis Proyectos</h1>
		</div>
	</div>
	<!-- END Page Title -->

	<!-- BEGIN Breadcrumb -->
	<div id="breadcrumbs">
		<ul class="breadcrumb">
			<li><i class="icon-home"></i> <a href="home.html">Home</a> <span
				class="divider"><i class="icon-angle-right"></i></span></li>
			<li class="active">Mis Proyectos</li>
		</ul>
	</div>
	<!-- END Breadcrumb -->

	<!-- BEGIN Main Content -->
	<div class="row-fluid">
		<div class="span10">
			<div class="box">
				<div class="box-title">
					<h3>
						<i class="icon-table"></i> Mis Proyectos
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
								<th>Nombre</th>
								<th>Perfil</th>
								<th>Fecha Inicio</th>
								<th>Fecha Fin</th>
								<th>Opciones</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${model.proyectosusuarios}" var="pu">

								<tr class="table-flag-blue">
									<td><c:out value="${pu.proyecto.nombre}"></c:out></td>
									<td><c:out value="${pu.perfilId.nombre}"></c:out></td>
									<td><c:out value="${pu.proyecto.fechaInicio}"></c:out></td>
									<td><c:out value="${pu.proyecto.fechaFin}"></c:out></td>
									<td><input type="button" name="accion"
										onClick="verProyecto(<c:out value="${pu.proyecto.proyectoId}"></c:out>)"
										value="Detalles" class="btn btn-info" /></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<%@ include file="/WEB-INF/views/inc.footer.jsp"%>
		<script type="text/javascript">
function verProyecto(id){
	$(location).attr('href','detalles_proyecto.htm?id='+id);
}
</script>

		</body>
		</html>